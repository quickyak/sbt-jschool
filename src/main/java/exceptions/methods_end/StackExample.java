package exceptions.methods_end;

public class StackExample {

    public static void main(String[] args) {
        System.out.println(method1());
    }

    static int method1() {
        System.err.println("method1: Before");
        int result =  method2();
        System.err.println("method1: After");
        return result;
    }

    static int method2() {
        System.err.println("method2: Before");
        int result = method3();
        System.err.println("method1: After");
        return result;
    }

    static int method3() {
        System.err.println("method3: Before");
        int result = method4();
        System.err.println("method1: After");
        return result;
    }

    static int method4() {
        System.err.println("method4: Before");
        throw new IllegalStateException("Не нравится мне все это...");
        //System.err.println("method4: After");
    }
}
