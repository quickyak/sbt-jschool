package hometask09;

import java.util.concurrent.atomic.AtomicInteger;

public class FibonacciNumbers implements Runnable {
        AtomicInteger baseFib;

        @Override
        public void run() {
//                System.out.println(String.format("%d - thread %s is running", i, Thread.currentThread().getName()));
            System.out.println(baseFib + "  " + calc(baseFib.get() ) + " в потоке " + Thread.currentThread().getName());
        }

        public FibonacciNumbers(AtomicInteger n) {
            baseFib = n;
        }

        public static long calc(int n) {
            return fibCycle(n); //может сделаю еще другую реализацию - через лямбду или массивы
        }

        private static long fibCycle(int n) {
            long n0 = 1;
            long n1 = 1;
            long n2 = 1;

            for (int i = 3; i < n + 1; i++) {
                n2 = n0 + n1;
                n0 = n1;
                n1 = n2;
            }
            return n2;
        }

        private static void fibCycleTest(int n) {
            for (int i = 1; i < n + 1; i++) {
                System.out.println("input = " + i + "  result = " + fibCycle(i));
            }
        }

        private static void fibCycleTest() {
            fibCycleTest(60);
        }
}
