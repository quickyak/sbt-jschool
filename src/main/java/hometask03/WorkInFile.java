package hometask03;

import java.io.FileNotFoundException;

public class WorkInFile {
    public static void main(String[] args) throws FileNotFoundException {
        FileInit fileInit = new FileInit();
        fileInit.setDirName(System.getProperty("user.dir"));
        fileInit.setFileName("lesson03.txt");
        fileInit.setText("This new text \nThis new text2\nThis new text3\nThis new text4\n");

        //Запись в файл
        //FileWorker.write( fileInit.getFileName(), fileInit.getText());

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



