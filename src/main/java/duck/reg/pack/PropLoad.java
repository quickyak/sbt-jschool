package duck.reg.pack;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropLoad {
    static String path = "/Users/yaroslav/Library/Keychains/java.properties";

    public  static String getPath() {
        return path;
    }

    public static void main(String[] args) {
        new PropLoad().printAll();
    }

    private void printAll() {
        Properties properties = new PropLoad().getPropertiesFromFile();

        // get the property value and print it out
        properties.forEach((key, value) -> System.out.println("Key : " + key + ", Value : " + value));

        //  Как напечатать конкретное свойство
//            System.out.println(properties.getProperty("yt.apikey"));

        // Get all keys
        properties.keySet().forEach(System.out::println);

        Set<Object> objects = properties.keySet();
    }

    public Properties getPropertiesFromFile() {
        Properties properties = null;
        String fileName = PropLoad.getPath();

        try (InputStream input = new FileInputStream(fileName)) {
            properties = new Properties();
            // load a properties file
            properties.load(input);

        } catch (IOException ex) {
            System.out.println("Sorry, unable to find " + fileName);
            ex.printStackTrace();
        }
        return properties;
    }

    public String getYoutubeApiKey() {
        return getProperty("yt.apikey");
    }

    public String getProperty(String nameProperty) {
        String result;
        Properties properties = new PropLoad().getPropertiesFromFile();

        // get the property value and print it out
        result = properties.getProperty(nameProperty);
        System.out.println(properties.getProperty(nameProperty));
        return result;
    }


}
