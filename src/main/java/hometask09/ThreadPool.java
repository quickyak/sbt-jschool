package hometask09;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


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

        AtomicInteger atomicInteger = new AtomicInteger();

//        //здесь просто в цикле
//        for (Integer i = 0; i < 50; i++) {
//            atomicInteger.set(i);
//            Runnable runnable = new FibonacciNumbers(atomicInteger);
//            execute(runnable);
//        }

        //здесь из файла
        ArrayList<Integer> tokens = new ArrayList<Integer>();

        ReadFileLineByLine readFileLineByLine = new ReadFileLineByLine();
        tokens = readFileLineByLine.readFileTest();
        System.out.println(tokens);

        for (Integer token : tokens) {
            atomicInteger.set(token);
            Runnable runnable = new FibonacciNumbers(atomicInteger);
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