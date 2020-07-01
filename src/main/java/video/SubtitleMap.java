package video;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SubtitleMap {
    private String fileName;


    public static void main(String[] args) {
        // Считаем текст из файла
        String content = new SubtitleFile(2).getTextFromFile();

        // Перееведем текст в мапу
        SubtitleMap subtitleMap = new SubtitleMap();
        Map <Integer, TupleSrt<String, String>> mapSrt= new TreeMap<>();
        subtitleMap.textToMap(content, mapSrt);
        subtitleMap.printMap(mapSrt);

        // Сохраним содержимое мапы в Excel
        //      Apache POI - the Java API for Microsoft Documents
        //      http://poi.apache.org
        //      https://habr.com/ru/post/56817/
        //      https://ru.stackoverflow.com/questions/1084328/Работа-с-excel-с-помощью-java-стандартными-библиотеками


        // Сохраним содержимое мапы в Базу данных

    }

    private void printMap(Map<Integer, TupleSrt<String, String>> mapSrt) {
        for (Map.Entry<Integer, TupleSrt<String, String>> entry : mapSrt.entrySet()) {
            SubtitleTime subtitleTime = new SubtitleTime(entry.getValue().getFirst());

            System.out.println(
                    entry.getKey()
//                                + " (" + timeSrt.toStringStart() + ") "
                            + " (" + subtitleTime.toStringMiddle() + ") "
                            + entry.getValue().getSecond()
//                                + " || " + timeSrt.toStringStart()
                    //                       + entry.getValue().getFirst()
            );
        }
    }


    public  void textToMap(String text, Map mapSrt)   {
        //? Как напечатать только 1,5,9 строки
//        Stream

//        System.out.println("Текст ");
//        System.out.println(text);


        //? Сколько строк \n
        // https://ru.stackoverflow.com/questions/725999/Как-посчитать-количество-вхождений-символа-в-строку
//        long occurence = text.codePoints().filter(ch -> ch == '\n').count();
//        System.out.println("Количество строк в файле = " + occurence);
//        long occurenceBlock = occurence/4;

        List<String> strings;
        strings = Arrays.asList(text.split("\n"));

//        int numRow=0;
        int idxBlock=0;

        int key=0;
        String first="";
        String second="";


        for (String string:strings
        ) {
            switch(idxBlock) {
                //0 - is key
                //1 - is String diapason
                //2 - is Caption
                //3 - is empty String
                case 0:
                    key = Integer.parseInt(string);
                    break;
                case 1:
                    first = string;
                    break;
                case 2:
                    second = string;;
                    break;
                case 3:
                    //empty string
                    //populate map
                    mapSrt.put(key,
                            new TupleSrt(first, second)
                    );
                    break;
            }

//            numRow++;
            idxBlock++;
            if (idxBlock==4) idxBlock = 0; //далее идет новый блок
        }
    }
}
