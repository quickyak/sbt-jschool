package multithread1;

public class RunnableExample implements Runnable
{
    @Override
    public void run () {
        for (int i = 0; i < 5; i++) {
            System.out.println(String.format("%d - thread %s is running", i, Thread.currentThread().getName()));
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            Thread t = new Thread(new RunnableExample());
            t.start();
        }
        System.out.println("Main thread finished");
    }

}
