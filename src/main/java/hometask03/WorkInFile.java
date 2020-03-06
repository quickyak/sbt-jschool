package hometask03;

import java.io.FileNotFoundException;



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
        strText += "This new text\nThis new text2\nThis new text3\nThis new text4\nThis new text5\n";
        strText += "this new text2\nthis new text3\nThis new text4\nThis new text\nThis new text\n";
        fileInit.setText(strText);

        //Запись в файл
        String fileName = fileInit.getFullName();
        FileWorker.write(fileName, fileInit.getText());

        //Читаем из файла
        String strRead = FileWorker.read(fileName);
        System.out.println(strRead);
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



