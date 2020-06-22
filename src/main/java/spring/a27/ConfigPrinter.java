package spring.a27;

public class ConfigPrinter {

    private String info;

    public ConfigPrinter() {
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void printInfo() {
        System.out.println("info: " + info);
    }
}
