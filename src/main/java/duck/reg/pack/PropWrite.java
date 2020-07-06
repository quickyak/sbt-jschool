package duck.reg.pack;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropWrite {

    public static void main(String[] args) {
//        new PropWrite().writeNew();
        new PropWrite().append("yt.test", "test Youtube value");

    }

    private  void writeNew() {
        //        try (OutputStream output = new FileOutputStream( "path/to/config.properties")) {
        try (OutputStream output = new FileOutputStream(PropLoad.getPath(), true)) {

            Properties properties = new Properties();

            // load a properties file
//            properties.load(input);

            // set the properties value
            properties.setProperty("db.url", "localhost");
            properties.setProperty("db.user", "mkyong");
            properties.setProperty("db.password", "password");
            properties.setProperty("yt.apikey223", "AIzaSyDe9uKNLiuvdIkq9ZBc1G8wJUKjLBeb4o4_223");
            properties.setProperty("yt.videopath", "https://youtu.be/BQidh8H0fMo");
            properties.setProperty("yt.videoid", "BQidh8H0fMo");


            // save properties to project root folder
            properties.store(output, null);

            System.out.println(properties);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private  void append(String nameProp, String valueProp) {
        Properties propertiesIn = new PropLoad().getPropertiesFromFile();


        //        try (OutputStream output = new FileOutputStream( "path/to/config.properties")) {
        try (OutputStream output = new FileOutputStream(PropLoad.getPath(),true)) {

            Properties properties = new Properties();

            // load a properties file
//            properties.load(input);

            // set the properties value
            properties.setProperty(nameProp, valueProp);

            // save properties to project root folder
            properties.store(output, null);

            System.out.println(properties);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}