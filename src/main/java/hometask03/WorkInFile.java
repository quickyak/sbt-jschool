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
        strText += "This old text\nThis New text2\nThis Old text3\nThis pro text4\nThis Pru text5\n";
        strText += "this new text2\nthis new text3\nThis new text4\nThis new text\nThis new text\n";
//        strText = "";
        fileInit.setText(strText);

        //Запись в файл
        String fileName = fileInit.getFullName();
        FileWorker fileWorker = new FileWorker();
        fileWorker.setFileName(fileName);
        fileWorker.write(fileInit.getText());

        //Читаем из файла
        fileWorker.setFileName(fileName);
        String strRead = fileWorker.read();
//        String strRead = strText;
        System.out.println("Содержимое:  ");
        System.out.println(strRead); //Для больших файлов надо переделать? Так как слишком большая strRead
        System.out.println();

        //Читаем в массив
        String[] words = strRead.split("\\s"); //ловим и пробелы и новую строку - то есть как раз разделим по словам
        // !!! words при пустой строке состоит из 1го элемента - то есть кол-во элементов надо проверять - один элемент и не пустой ли он!

        // Задание 1: Подсчитайте количество различных слов в файле.
        // В реализациях используйте наиболее подходящие имплементации коллекций!
        //CalcDiffWord.HashSetImpl(strRead); //можно через строку
        CalcDiffWord.hashSetImpl(words); //можно через массив
        System.out.println("Количество различных слов = " + CalcDiffWord.getCountDiffWord());

        //Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
        OutDiffWordSorted.sortThenPrint(words);

        //Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
        System.out.println("\n-- Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле. ");
        CountWords.countThenPrint(words);

        //Задание 4: Выведите на экран все строки файла в обратном порядке.
        System.out.println("\n -- Задание 4: Выведите на экран все строки файла в обратном порядке. ");
        String[] strings = strRead.split("\\n"); //массив строк
        ReversingArray.reverse(strings);

        //Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке
        //Сказали, что можно не делать, а почитать про Iterator

        //Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
        // Значит нужен ввод номеров строк, проверка, что строка с таким номером существует и вывод строки
        System.out.println("\n --Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.");
        OutFromConsole outFromConsole = new OutFromConsole();
        outFromConsole.main(strings);
    }
}







