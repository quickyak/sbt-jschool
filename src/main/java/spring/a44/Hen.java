package spring.a44;

public class Hen {

    private String name;
    private Egg egg;

    public Hen(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printYourself() {
        System.out.println(String.format("Name is %s, egg: %s", this.name, getEgg().getNumber()));
    }

    public void setName(String name) {
        this.name = name;
    }

    public Egg getEgg() {
        return egg;
    }

    public void setEgg(Egg egg) {
        this.egg = egg;
    }
}
