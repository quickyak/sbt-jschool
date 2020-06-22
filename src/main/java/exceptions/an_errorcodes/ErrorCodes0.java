package exceptions.an_errorcodes;

public class ErrorCodes0 {

    public static void main(String[] args) {
        String[] messages = {"1", "2", null, "4"};
        int errorCode = sendMessages(messages);
        if (errorCode == 0) {
            // Что-то сделать полезное
            System.out.println("Error code: " + errorCode);
        }
    }

    /**
     *
     * @param messages
     * @return error code. -27 = null message in array
     */
    static int sendMessages(String[] messages) {
        for (String message : messages) {
            if (message != null) {
                System.out.println(message);
            } else {
                return -27;
            }
        }
        return 0;
    }
}
