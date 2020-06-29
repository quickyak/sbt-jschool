package video;

import hometask03.FileWorker;

import java.util.*;

public class Subtitle {
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        // Считаем текст из файла
        Subtitle subtitle = new Subtitle();
//        subtitle.setFileName("/Users/yaroslav/Downloads/Youtube/2020-06-26 Виктор.srt");
        subtitle.setFileName("/Users/yaroslav/Desktop/2020-06-26 Виктор.srt");
        String content = subtitle.getTextFromFile();

        // Перееведем текст в мапу
        Map <Integer, TupleSrt<String, String>> mapSrt= new TreeMap<>();
        subtitle.textToMap(content, mapSrt);
        subtitle.printMap(mapSrt);

        // Сохраним содержимое мапы в Excel
        //      Apache POI - the Java API for Microsoft Documents
        //      http://poi.apache.org
        //      https://habr.com/ru/post/56817/
        //      https://ru.stackoverflow.com/questions/1084328/Работа-с-excel-с-помощью-java-стандартными-библиотеками


        // Сохраним содержимое мапы в Базу данных

    }

    private void printMap(Map<Integer, TupleSrt<String, String>> mapSrt) {
        for (Map.Entry<Integer, TupleSrt<String, String>> entry : mapSrt.entrySet()) {
            TimeSrt timeSrt = new TimeSrt(entry.getValue().getFirst());

            System.out.println(
                    entry.getKey()
//                                + " (" + timeSrt.toStringStart() + ") "
                            + " (" + timeSrt.toStringMiddle() + ") "
                            + entry.getValue().getSecond()
//                                + " || " + timeSrt.toStringStart()
                    //                       + entry.getValue().getFirst()
            );
        }
    }


    public  String getTextFromFile ()   {
        String result = new FileWorker().getTextFromFile(getFileName());

//        System.out.println("Содержимое файла " + getFileName());
//        System.out.println(result);

        return result;
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
