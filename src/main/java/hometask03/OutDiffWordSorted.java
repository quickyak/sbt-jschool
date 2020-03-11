package hometask03;

//    Задание 2: Выведите на экран список различных слов файла,
//    отсортированный по возрастанию их длины
//    (компаратор сначала по длине слова, потом по тексту).

// через

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Comparator;

public class OutDiffWordSorted {
    public static void main(String[] args) {
        String wordsArray[];
        wordsArray = new String[]{"ADF", "Adfda", "afaddas", "asdfas", "adfsd"};
        sortThenPrint(wordsArray);


    }

    public static void sortThenPrint(String[] splitContent) {
        ArrayImpl(splitContent);
    }

    public static void ArrayImpl(String[] splitContent) {
        // !!! splitArray при пустой строке состоит из 1го элемента - то есть кол-во элементов надо проверять - один элемент и не пустой ли он!  equals ""

        //делаем копию массива
        String wordsArray[];
        wordsArray = Arrays.copyOf(splitContent, splitContent.length);
        //System.arraycopy(): System class arraycopy() is the best way to do partial copy of an array.
        // clone

        //создаем компаратор
        Comparator<String> comparator = Comparator.comparing(obj -> obj.length()); //сортировка по длине
        comparator = comparator.thenComparing(obj -> obj); //сортировка по имени
        //comparator = comparator.thenComparing(obj -> obj.toString()); //избыточно пишет, так как toString - дефолтный метод итак

//        CharacterSortOut(); //разбираюсь с последовательностью сортировки символов


        Arrays.sort(wordsArray, comparator);
//        Collections.sort(messages, comparator);
        System.out.println(Arrays.toString(wordsArray));
        //дополнительно про печать массивов - https://codengineering.ru/q/whats-the-simplest-way-to-print-a-java-array-27108/


/*
        Collections.sort(Arrays.asList(wordsArray), Comparator
                .comparing( String::length )
                .thenComparing( String::toString ));
*/


    }

    private static void CharacterSortOut() {
        //разбираюсь с последовательностью сортировки символов
        Character[] arrChar = {'a', 'A', 'а', 'А', 'z', 'Z', 'я', 'Я'};
        Arrays.sort(arrChar); //по возрастанию чисел - так как это целые числа
        Character chMin = arrChar[0]; //первый элемент минимальный
        Character chMax = arrChar[arrChar.length - 1]; //последний элемент максимальный
//        System.out.println("chMin = " + chMin);
//        System.out.println("chMax = " + chMax);

//        for (char ch = 'a'; ch <= 'Я'; ch++) {
        for (char ch = chMin; ch <= chMax; ch++) {
            char lch = Character.toLowerCase(ch);
            if ((lch >= 'a' && lch <= 'z') || (lch >= 'а' && lch <= 'я')) {
//                System.out.println("code=" +  (int) ch + "\tsumbol=" + ch);
                System.out.printf("code= %1$4d \tsumbol=" + ch + "\n", (int) ch);
            }
        }
    }
}




