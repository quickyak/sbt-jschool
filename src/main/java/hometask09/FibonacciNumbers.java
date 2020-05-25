package hometask09;

import java.util.concurrent.atomic.AtomicLong;

public class FibonacciNumbers implements Runnable {
    AtomicLong baseFib = new AtomicLong();
    AtomicLong resFib = new AtomicLong();

    @Override
    public void run() {
//                System.out.println(String.format("%d - thread %s is running", i, Thread.currentThread().getName()));
        resFib=calc();
        String sResFib = FibonacciTest.df(resFib);
        System.out.println("Fib(" + baseFib + ") =  " + sResFib + " // в потоке " + Thread.currentThread().getName());
    }

    public FibonacciNumbers(Integer n) {
        //конструктор класса - инициализирует значение базы для расчета фибоначи
        //по нему потом происходит calc
        baseFib.set(n);
    }

    public  AtomicLong calc() {
        return fibCycle(baseFib); //может сделаю еще другую реализацию - через лямбду или массивы
    }

    private  AtomicLong fibCycle(AtomicLong n) {
        AtomicLong n0 = new AtomicLong(1);
        AtomicLong n1 = new AtomicLong(1);
        AtomicLong n2 = new AtomicLong(1);

        for (int i = 3; i < n.get()+1; i++) {
            n2.set(n0.addAndGet(n1.get()));
            n0.set(n1.get());
            n1.set(n2.get());
        }

//            for (int i = 3; i < n + 1; i++) {
//                n2 = n0 + n1;
//                n0 = n1;
//                n1 = n2;
//            }
//
        return n2;
    }

    public  void fibCycleTest(int n) {
        for (int i = 1; i < n + 1; i++) {
            System.out.println("input = " + i + "  result = " + fibCycle(new AtomicLong(i)));
        }
    }

    public  void fibCycleTest() {
        fibCycleTest(60);
    }
}
