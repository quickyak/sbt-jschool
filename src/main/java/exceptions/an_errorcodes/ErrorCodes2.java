package exceptions.an_errorcodes;

public class ErrorCodes2 {

    public static void main(String[] args) {
        int x1 = 6;
        int x2 = 0;

        IntResult result = resolveEquation(x1, x2);
        System.out.println("Result is: " + result);
    }

    /**
     *
     * @return equation root
     */
    static IntResult resolveEquation(int x1, int x2) {
        if (x2 != 0) {
            return new IntResult(x1/x2);
        } else {
            return new IntResult("Alarm! Error!");
        }
    }
}

class IntResult {
    private int result;
    private String errorString;

    public IntResult(int result) {
        this.result = result;
    }

    public IntResult(String errorString) {
        this.errorString = errorString;
    }

    public int getResult() {
        return this.result;
    }

    public String getErrorString() {
        return this.errorString;
    }

    @Override
    public String toString() {
        if (this.errorString == null) {
            return String.valueOf(this.result);
        } else {
            return this.errorString;
        }
    }
}
