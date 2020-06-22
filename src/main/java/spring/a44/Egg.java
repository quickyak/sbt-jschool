package spring.a44;

public class Egg {

    private static int counter = 0;

    private int number;

    public Egg() {
        this.number = counter++;
    }

    public int getNumber() {
        return number;
    }
}
