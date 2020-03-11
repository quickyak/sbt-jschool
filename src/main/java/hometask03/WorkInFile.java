package hometask03;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class WorkInFile {
    public static void main(String[] args) throws FileNotFoundException {

        //Вначале создадим файл, если он не существует
        //Либо перезапишем его, если он уже есть
        FileInit fileInit = new FileInit();

        fileInit.setDirName(System.getProperty("user.dir")); //в пользовательской директории
        System.out.println(fileInit.getDirName());

        fileInit.setFileName("lesson03.txt");

        String strText;
        strText = "This new text\nThis new text2\nThis new text3\nThis new text4\nThis new text5\n";
        strText += "This old text\nThis New text2\nThis Old text3\nThis pro text4\nThis Pru text5\n";
        strText += "this new text2\nthis new text3\nThis new text4\nThis new text\nThis new text\n";
//        strText = "";
        fileInit.setText(strText);

        //Запись в файл
        String fileName = fileInit.getFullName();
        FileWorker.write(fileName, fileInit.getText());

        //Читаем из файла
        String strRead = FileWorker.read(fileName);
//        String strRead = strText;
        System.out.println("Содержимое:  ");
        System.out.println(strRead); //Для больших файлов надо переделать? Так как слишком большая strRead
        System.out.println();

        //Читаем в массив
        String[] splitArray = strRead.split("\\s"); //ловим и пробелы и новую строку - то есть как раз разделим по словам
        // !!! splitArray при пустой строке состоит из 1го элемента - то есть кол-во элементов надо проверять - один элемент и не пустой ли он!

        // Задание 1: Подсчитайте количество различных слов в файле.
        // В реализациях используйте наиболее подходящие имплементации коллекций!
        //CalcDiffWord.HashSetImpl(strRead); //можно через строку
        CalcDiffWord.hashSetImpl(splitArray); //можно через массив
        System.out.println("Количество различных слов = " + CalcDiffWord.getCountDiffWord());

        //Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
        OutDiffWordSorted.sortThenPrint(splitArray);

        //Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
        System.out.println();
        System.out.println("-- Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле. ");
        CountWords.countThenPrint(splitArray);


        // можно в HashMap - Имя, Кол-во

        //? Как считаем - через Set


/*

        strRead.
        List<String> lines = new ArrayList<String>();

        strRead.split("\n")
        List<String> lines = new ArrayList<String>();

        String [] linesAsArray = lines.toArray(new String[lines.size()]);
        System.out.println("" + Arrays.toString(linesAsArray));
*/



    }
}


//Домашнее задание
//Исходные данные: текстовый файл со средней длиной строки равной 10 символам (файл или прошить текст в коде)
//В реализациях используйте наибоее подходящие имплементации коллекций !!!!

//Задание 1: Подсчитайте кол-во различных слов в файле

//Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастания их длины
// (компаратор сначала по длине слова, потом по тексту

//Задание 3: Подсчитайте и выведите на экран сколько каждое слово встречается в файле

//Задание 4: Выведите на экран все строки файла в обратном порядке
// reverse

//Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке

//Задание 6: Выведите на экран строки, номера которых задаются пользоватлем в производльном порядке
//shuffle ?



