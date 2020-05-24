package multithread1;

public class ExceptionHandlerExample {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            throw new RuntimeException();
        });
    }
}
