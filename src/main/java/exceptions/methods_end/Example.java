package exceptions.methods_end;

public class Example {

    static String[] strings = new String[3];

    public static void main(String[] args) {
        System.out.println(getArrayLength(strings));
    }

    static int getArrayLength(String[] array) {
        if (array == null) {
            throw new IllegalStateException("Array can't be null.");
        }
        System.out.println("!!!");
        return 0;
    }
}
