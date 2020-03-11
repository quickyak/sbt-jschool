package hometask03;

import java.util.ArrayList;
import java.util.Scanner;

public class OutFromConsole {

    ArrayList<Integer> nums = new ArrayList<>();

    public void main(String[] args) {
        readFromConsole(args);
        printToConsole(args);
    }

    //По одному int считывать или массив?
    private void readFromConsole(String[] strings) {
        System.out.println("Введите номера строк от 1 до " + (strings.length));
        System.out.println("Для завершения наберите end или любой текст, отличный от целого числа");

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int num = scan.nextInt();
            nums.add(num);
        }
    }

    //По одному int считывать или массив?
    private void printToConsole(String[] strings) {
        for (Integer num : nums) {
            Integer idxArray = num - 1; //это индекс массива - он с 0, а пользователь вводит сроки с 1
            System.out.print(num + " : ");
            if (idxArray >= 0 && idxArray < strings.length) {
                //есть такая строка
                System.out.println(strings[idxArray]);
            }
        }
    }
}



