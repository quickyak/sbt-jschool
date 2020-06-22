package exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {

        try {
            parse(new FileInputStream("some"));
        } catch (IOException ex) {
            System.out.println("!!");
        }

    }

    static void parse(InputStream inputStream) throws IOException {
        inputStream.read();
    }

}
