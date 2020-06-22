package exceptions.y_speed;

public class Main {

    public static void main(String[] args) {

        int N = 1_000_000_000;
        byte[] bytes = {1, 2, 3};

        long before = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            getByteIf(bytes, 7);
        }
        System.out.println("Elapsed time for if(ms): " + (System.currentTimeMillis() - before));

        before = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            getByteException(bytes, i%3);
        }
        System.out.println("Elapsed time for exception(ms): " + (System.currentTimeMillis() - before));

    }

    static void getByteIf(byte[] bytes, int pos) {
        if (pos >= 0 && pos < bytes.length) {
            byte aByte = bytes[pos];
        }
    }

    static void getByteException(byte[] bytes, int pos) {
        try {
            byte aByte = bytes[pos];
        } catch (IndexOutOfBoundsException ex) {
        }
    }

}
