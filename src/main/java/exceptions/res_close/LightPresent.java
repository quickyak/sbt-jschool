package exceptions.res_close;

import java.io.FileInputStream;
import java.io.IOException;

public class LightPresent {

    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("some.file")) {
            int read = fis.read();
            // some work ...

        } catch (IOException ex) {
            System.out.println("Please, enter correct file.");
            throw ex;
        }
    }

}
