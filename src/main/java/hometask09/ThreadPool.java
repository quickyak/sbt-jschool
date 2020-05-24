package hometask09;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


//реализовать ThreadPool
//
//public interface ThreadPool {
//    void start(); // запускает потоки. Потоки бездействуют, до тех пор пока не появится новое задание в очереди (см. execute)
//
//    void execute(Runnable runnable); // складывает это задание в очередь. Освободившийся поток должен выполнить это задание. Каждое задание должны быть выполнено ровно 1 раз
//}



//Runtime.getRuntime().availableProcessors() - количество доступных процессоров
//Предположим, что это оптимальная величина по количеству потоков
//оптимальный пул потоков = Runtime.getRuntime().availableProcessors() + 1.

public class ThreadPool {
    static Executor executor;

    public static void main(String[] args) {
        start();

        for (int i = 0; i < 10; i++) {
//            executor.execute(new RunnableExample());
            Runnable runnable = new RunnableExample();
            execute(runnable);
        }

    }

    // запускает потоки. Потоки бездействуют, до тех пор пока не появится новое задание в очереди (см. execute)
    public static void start() {
//        Executor executor = Executors.newFixedThreadPool(4);
        executor = Executors.newFixedThreadPool(4);
    }

    // запускает потоки. Потоки бездействуют, до тех пор пока не появится новое задание в очереди (см. execute)
    public static void execute(Runnable runnable) {
        executor.execute(runnable);
    }

}

//FixedThreadPool

//
//public class ThreadExam {
//    //Для запуска задачи в отдельном потоке можно использовать класс Thread
//    public static void main(String[] args) {
////        Thread t = new Thread(new SomeTask());
////        t.start();
//    }
//}