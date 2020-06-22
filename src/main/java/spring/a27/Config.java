package spring.a27;

public class Config {

    private String os = System.getenv("OS");
    private String computername = System.getenv("COMPUTERNAME");

    public String getOs() {
        return os;
    }

    public String getComputername() {
        return computername;
    }
}
