package multithread1;

import hometask09.RunnableExample;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i <10 ; i++) {
            executor.execute(new RunnableExample());
        }
        System.out.println("main");
    }
}
