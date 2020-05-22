package multithread1;

public class AnnonymRunnableExample {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println(String.format("Run thread %s", Thread.currentThread().getName()));
        });
        t.start();
        System.out.println("Main thread finished");
    }
}
