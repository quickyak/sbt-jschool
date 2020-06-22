package exceptions.x_cause;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            throw new IOException("IO exception!");
        } catch (IOException ex) {
            try {
                UserIOException userIOException = new UserIOException(2343, ex);
                throw userIOException;
            } catch (RuntimeException e) {
                if (e.getCause() != null) {
                    System.out.println("Cause: " + e.getCause());
                }
                throw new Error("Error!", e);
            }
        }
    }
}

class UserIOException extends RuntimeException {
    private int userId;

    public UserIOException(int userId, Throwable cause) {
        super(cause);
        this.userId = userId;
    }
}
