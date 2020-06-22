package spring.a33;

public class Tiger {

    private Environment environment;
    private String name;

    public Tiger(Environment environment, String name) {
        System.out.println("Создаю тигра " + name);
        this.environment = environment;
        this.name = name;
    }

    public void printAbout() {
        System.out.println("Мое имя " + name + " и я живу в " + environment.getName());
    }
}