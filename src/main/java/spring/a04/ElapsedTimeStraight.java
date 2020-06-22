package spring.a04;

public class ElapsedTimeStraight {

    public static void main(String[] args) {

        Evaluator evaluator = new Evaluator();
        // Задача измерить время работы метода
        long start = System.nanoTime();

        double value = evaluator.evaluate();

        System.out.println("Elapsed time: " + (System.nanoTime() - start) + " ns");

        System.out.println("value: " + value);

    }
}
