package spring.a03;

import java.util.Scanner;

public class NoIoC {

    public static void main(String[] args) {

        System.out.println("Enter a,b,c (ax^2 + bx + c = 0) divided by space: ");
        Scanner scanner = new Scanner(System.in);
        String user_enter = scanner.nextLine();

        String[] split = user_enter.split(" ");

        solveEquation(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    private static void solveEquation(int a, int b, int c) {
        String NO_ROOTS = "Equation does'n have roots.";

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("x is any.");
                } else {
                    System.out.println(NO_ROOTS);
                }
            } else {
                System.out.println("x = " + (1.0 * c / b));
            }
        } else {
            if (b == 0) {
                if (-c / a < 0) {
                    System.out.println(NO_ROOTS);
                } else {
                    System.out.println("x = " + (Math.sqrt(-c * 1.0 / a)));
                }
            } else {
                if (c == 0) {
                    System.out.println("x1 = 0, x2 = " + (-1.0 * b / a));
                } else {
                    int discriminant = b * b - 4 * a * c;
                    if (discriminant < 0) {
                        System.out.println(NO_ROOTS);
                    } else {
                        System.out.println(
                                String.format("x1 = %s, x2 = %s",
                                        ((-b + Math.sqrt(discriminant)) / (2 * a)),
                                        ((-b - Math.sqrt(discriminant)) / (2 * a))));
                    }
                }
            }
        }
    }
}
