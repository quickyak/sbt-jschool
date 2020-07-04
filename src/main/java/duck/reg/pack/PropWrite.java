package duck.reg.pack;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropWrite {

    public static void main(String[] args) {

//        try (OutputStream output = new FileOutputStream( "path/to/config.properties")) {
        try (OutputStream output = new FileOutputStream(PropPath.getPath())) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("db.url", "localhost");
            prop.setProperty("db.user", "mkyong");
            prop.setProperty("db.password", "password");
            prop.setProperty("yt.apikey223", "AIzaSyDe9uKNLiuvdIkq9ZBc1G8wJUKjLBeb4o4_223");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}