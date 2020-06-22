package spring.a27;

public class AutoFactory {

    public Car createCar(Engine engine, String name) {
        return Car.create(engine, name);
    }

}
