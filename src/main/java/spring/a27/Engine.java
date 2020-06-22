package spring.a27;

public class Engine {

    private String name;

    public Engine(String volume) {
        this.name = volume;
    }

    public Engine(int volume) {
        this.name = "vol:" + (volume/10.0);
    }

    public void work() {
        System.out.println(String.format("Двигатель %s фр-фр-фр.", name));
    }

}
