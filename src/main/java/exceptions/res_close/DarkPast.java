package exceptions.res_close;

import java.io.FileInputStream;
import java.io.IOException;

public class DarkPast {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        IOException exception = null;
        try {
            fis = new FileInputStream("some.file");
            int read = fis.read();
            // some work ...

        } catch (IOException ex) {
            System.out.println("Please, enter correct file.");
            exception = ex;
            throw ex;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    if (exception != null) {
                        exception.addSuppressed(ex);
                        throw exception;
                    }
                    throw ex;
                }
            }
        }
    }

}
