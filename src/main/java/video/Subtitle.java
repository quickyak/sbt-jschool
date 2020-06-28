package video;

import hometask03.FileWorker;

import java.util.HashMap;
import java.util.Map;

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
        subtitle.setFileName("/Users/yaroslav/Downloads/Youtube/2020-06-26 Виктор.srt");
        String content = subtitle.getTextFromFile();

        // Перееведем текст в мапу
        Map mapSrt = new HashMap();
        subtitle.textToMap(content, mapSrt);
        System.out.println("Map:" + mapSrt);
        // https://javarush.ru/groups/posts/1940-klass-hashmap-




        // Сохраним содержимое мапы в Excel
        //      Apache POI - the Java API for Microsoft Documents
        //      http://poi.apache.org
        //      https://habr.com/ru/post/56817/
        //      https://ru.stackoverflow.com/questions/1084328/Работа-с-excel-с-помощью-java-стандартными-библиотеками


        // Сохраним содержимое мапы в Базу данных

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

        System.out.println("Текст ");
        System.out.println(text);
    }

}
