package exceptions.default_handler;

public class StandartExceptionHandler {

    public static void main(String[] args) {
        int x1 = 5;
        int x2 = 0;
        count(x1, x2);
        System.out.println("End of program.");
    }

    static void count(int x1, int x2) {
        System.out.println("Start count");
        if (x2 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int result = x1 / x2;
        System.out.println(result);
    }
}
