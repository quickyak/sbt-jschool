package spring.a27;

public class Car {

    private String name;
    private Engine engine;
    private ChildSeat childSeat;

    public Car(Engine engine, String name) {
        System.out.println("Вызван конструктор " + name);
        this.engine = engine;
        this.name = name;
    }

    public static Car create(Engine engine, String name) {
        System.out.println("Вызван статический метод создания " + name);
        return new Car(engine, name);
    }

    public static Car create(String engine, String name) {
        return null;
    }

    public void go() {
        engine.work();
        if (this.childSeat != null) {
            childSeat.isEnabled();
        }
        System.out.println("Машина " + name + " покатилась.");
    }

    public ChildSeat getChildSeat() {
        return childSeat;
    }

    public void setChildSeat(ChildSeat childSeat) {
        this.childSeat = childSeat;
    }

    public static Car createInstance(Engine engine, String name) {
        System.out.println("Вызван статический метод создания " + name);
        return new Car(engine, name);
    }

    public Passenger getPassengerOnBoard() {
        return null;
    }
}
