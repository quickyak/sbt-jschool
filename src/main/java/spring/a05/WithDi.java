package spring.a05;

import java.util.ArrayList;
import java.util.List;

public class WithDi {

    static class Car {

        private DI.Tank tank;
        private List<DI.Wheel> wheels;
        private DI.Engine engine;

        public Car(DI.Tank tank, DI.Engine engine, List<DI.Wheel> wheels) {
            this.tank = tank;
            this.wheels = wheels;
            this.engine = engine;
        }

        public void go() {
            tank.getFuel();
            engine.work();
            for (DI.Wheel wheel : wheels) {
                wheel.roll();
            }
        }
    }

    public static void main(String[] args) {
        DI.Wheel wheel = new DI.Wheel("name");
        new Car(new DI.Tank(), new DI.Engine(), new ArrayList<>());
    }

}
