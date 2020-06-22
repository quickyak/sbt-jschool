package exceptions.q_finally;

public class Main {
    public static void main(String[] args) {
        System.out.println("From invoke: " + getMessage());
    }

    static String getMessage() {
        try {
            System.out.println("In try");
            throw new RuntimeException("Ops!");
        } catch (Exception ex) {
            System.out.println("In catch");
//            System.exit(0);
            return "catch";
        } finally {
            System.out.println("In finally");
            return "Not on my watch!";
        }
    }
}
