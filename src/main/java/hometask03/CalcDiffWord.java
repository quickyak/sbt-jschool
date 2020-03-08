package hometask03;


// Задание 1: Подсчитайте количество различных слов в файле.
// реализация через HashSet

// на входе строка из файла?
// на входе массив различных строк

import java.util.HashSet;

public class CalcDiffWord {
    static int countDiffWord = 0; //количество различных слов

    public static int getCountDiffWord() {
        return countDiffWord;
    }

    public static void setCountDiffWord(int countDiffWordNew) {
        countDiffWord = countDiffWordNew;
    }

    public static void main(String[] args) {
//        HashSetImpl("ываыва ываыва   ываыва   авопвап лолод ождлодложд  пвапвапвап ываыва" );
        HashSetImpl("" );

        System.out.println(getCountDiffWord());
    }

    public static void  HashSetImpl(String content) {
        // !!! splitArray при пустой строке состоит из 1го элемента - то есть кол-во элементов надо проверять - один элемент и не пустой ли он!
        String[] splitContent = content.split("\\s"); //ловим и пробелы и новую строку - то есть как раз разделим по словам
        HashSetImpl(splitContent);
    }

    public static void  HashSetImpl(String[] splitContent) {
        // !!! splitArray при пустой строке состоит из 1го элемента - то есть кол-во элементов надо проверять - один элемент и не пустой ли он!  equals ""

        HashSet<String> myHashSet = new HashSet<>();

        for (String word : splitContent) {
            if (!(word.equals("")))  //проверка на непустой элемент - из-за splitArray
                myHashSet.add(word);

        }
        setCountDiffWord(myHashSet.size());
    }
}


