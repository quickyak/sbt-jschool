package spring.a05;

import java.util.ArrayList;
import java.util.List;

public class DI {

    static class Car {

        private Tank tank;
        private List<Wheel> wheels;
        private Engine engine;

        public Car() {
            this.tank = new Tank();
            this.wheels = new ArrayList<>() {{
                add(new Wheel("Переднее левое"));
                add(new Wheel("Переднее правое"));
                add(new Wheel("Заднее левое"));
                add(new Wheel("Заднее правое"));
            }};
            this.engine = new Engine();
        }

        public void go() {
            tank.getFuel();
            engine.work();
            for (Wheel wheel : wheels) {
                wheel.roll();
            }
        }
    }

    static class Tank{
        public void getFuel() {
            System.out.println("Бак выдал 100 мл 92-го");
        }
    }
    static class Wheel {
        private String name;

        public Wheel(String name) {
            this.name = name;
        }

        public void roll() {
            System.out.println(name + " колесо крутится.");
        }
    }
    static class Engine {
        public void work() {
            System.out.println("Двигатель фр-фр-фр.");
        }
    }

    public static void main(String[] args) {
        new Car().go();
    }
}
