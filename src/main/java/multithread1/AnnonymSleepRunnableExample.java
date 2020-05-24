package multithread1;

public class  AnnonymSleepRunnableExample {
    static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            while (true) {
                System.out.println(String.format("Thread %s run", Thread.currentThread().getName()));
                Thread.yield(); //готов уступить процессорное время другому потоку - сообщает планировщику
            }
//            try {
//                Thread.currentThread().sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(String.format("Thread 2 %d iteration", i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        t2.start();

//        while (t.getState() != Thread.State.TERMINATED) {
//            System.out.println(String.format("%s in %s", t.getName(), t.getState()));
////            Thread.currentThread().sleep(1000);
//
//            //Аналогично - заснуть
//            TimeUnit.SECONDS.sleep(1); //делает код более читаемым по сравнению с Thread.currentThread().sleep(1000);
//        }
    }
}
