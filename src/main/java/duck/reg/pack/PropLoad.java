package duck.reg.pack;

        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Properties;

public class PropLoad {

    public static void main(String[] args) {

//        try (InputStream input = new FileInputStream("path/to/config.properties")) {
        try (InputStream input = new FileInputStream(PropPath.getPath())) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    public static String getYoutubeApi () {
        String result = "";

//        try (InputStream input = new FileInputStream("path/to/config.properties")) {
        try (InputStream input = new FileInputStream(PropPath.getPath())) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            result = prop.getProperty("yt.apikey");
            System.out.println(prop.getProperty("yt.apikey"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            return result;
        }
    }

}
