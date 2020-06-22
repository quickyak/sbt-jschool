package exceptions.w_inheritance;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Bird[] birds = new Bird[] {new Eagle()};
        try {
            for (Bird bird : birds) {
                bird.fly();
            }
        } catch (IOException ex) {
            System.out.println("!!");
        };
    }
}

class Bird {
    public void fly() throws IOException {
        System.out.println("fly");
    }
}

class Eagle extends Bird {

    @Override
    public void fly() throws FileNotFoundException {
        System.out.println("Eagle fly");
        throw new FileNotFoundException();
    }
}

//class Vulture extends Bird {
//    @Override
//    public void fly() throws ClassNotFoundException {
//        System.out.println("Vulture fly");
//        throw new ClassNotFoundException();
//    }
//}

