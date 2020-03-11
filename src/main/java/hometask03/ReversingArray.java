package hometask03;

import java.util.Arrays;
import java.util.Collections;

public class ReversingArray {

    /*function reverses the elements of the array*/
    static void reverse(String strings[]) {
        Collections.reverse(Arrays.asList(strings));
        System.out.println(Arrays.asList(strings));
    }

    public static void main(String[] args) {
        String[] arr = {"ADFAd", "afdafads", "zzz", "xxx"};
        reverse(arr);
    }
}
