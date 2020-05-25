package hometask09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;


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
    static int nThreads = 4;
//    static ExecutorService pool;

    public static void main(String[] args) {
        start();

        AtomicLong AtomicLong = new AtomicLong();

//        //здесь просто в цикле
//        for (int i = 0; i < 51; i++) {
//            Runnable runnable = new FibonacciNumbers(i);
//            execute(runnable);
//        }

        //здесь из файла
        ArrayList<Integer> tokens = new ArrayList<>();

        ReadFileLineByLine readFileLineByLine = new ReadFileLineByLine();
        tokens = readFileLineByLine.readFileTest();
        System.out.println("tokens = " + tokens);

        //потокобезопасная коллекция
        List<Integer> list; // = new ArrayList<>();
        list = Collections.synchronizedList(tokens);
        System.out.println("list = " + list);

        // печать значений коллекции
        for (int i = 0; i < list.size(); i++) {
            System.out.println("i = " + list.get(i));
            Runnable runnable = new FibonacciNumbers(list.get(i));
            execute(runnable);
        }
    }

    // запускает потоки. Потоки бездействуют, до тех пор пока не появится новое задание в очереди (см. execute)
    public static void start() {
        executor = Executors.newFixedThreadPool(nThreads);
    }

    // запускает потоки. Потоки бездействуют, до тех пор пока не появится новое задание в очереди (см. execute)
    public static void execute(Runnable runnable) {
        executor.execute(runnable);
    }
}