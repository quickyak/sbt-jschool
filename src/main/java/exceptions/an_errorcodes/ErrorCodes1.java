package exceptions.an_errorcodes;

public class ErrorCodes1 {

    public static void main(String[] args) {
        int x1 = 6;
        int x2 = 0;

        int result = resolveEquation(x1, x2);
        System.out.println("Result is: " + result);
    }

    /**
     *
     * @return equation root
     */
    static int resolveEquation(int x1, int x2) {
        if (x2 != 0) {
            return x1/x2;
        } else {
            return 0; // O_O ???
        }
    }
}
