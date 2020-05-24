package multithread1;

public class RunnableSleepExample implements Runnable
{
    @Override
    public void run () {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(String.format("%d - thread %s is running", i, Thread.currentThread().getName()));
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i <10 ; i++) {
            Thread t = new Thread(new RunnableSleepExample());
            t.setDaemon(true);
            t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        }
        System.out.println("Main thread finished");
    }
}
