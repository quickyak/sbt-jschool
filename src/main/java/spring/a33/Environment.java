package spring.a33;

public class Environment {

    private String name;

    public Environment(String name) {
        System.out.println("Создаю среду обитания " + name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
