package multithread1;

public class AnnonymSleepRunnableExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            System.out.println(String.format("Run thread %s", Thread.currentThread().getName()));
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();
        while (t.getState()!=Thread.State.TERMINATED){
            System.out.println(String.format("%s in %s", t.getName(),t.getState()));
            Thread.currentThread().sleep(1000);
        }
    }
}
