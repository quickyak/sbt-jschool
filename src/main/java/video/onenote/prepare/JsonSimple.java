package video.onenote.prepare;

//source - https://attacomsian.com/blog/java-read-write-json-files#
// Jackson
// Gson
// Moshi

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;


public class JsonSimple {
    public static void main(String[] args) {


//        new JsonSimpleWrite().jsonSimpleWrite();
        new JsonSimple().jsonSimpleRead();
    }

    private  void jsonSimpleWrite() {
        try {
            // create a writer
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("customer.json"));

            // create customer object
            JsonObject customer = new JsonObject();
            customer.put("id", 1);
            customer.put("name", "John Doe");
            customer.put("email", "john.doe@example.com");
            customer.put("age", 32);

            // create address object
            JsonObject address = new JsonObject();
            address.put("street", "155 Middleville Road");
            address.put("city", "New York");
            address.put("state", "New York");
            address.put("zipCode", 10045);

            // add address to customer
            customer.put("address", address);

            // add customer payment methods
            JsonArray pm = new JsonArray();
            pm.addAll(Arrays.asList("PayPal", "Stripe"));
            customer.put("paymentMethods", pm);

            // create projects
            JsonArray projects = new JsonArray();

            // create 1st project
            JsonObject p1 = new JsonObject();
            p1.put("title", "Business Website");
            p1.put("budget", 4500);

            // create 2nd project
            JsonObject p2 = new JsonObject();
            p2.put("title", "Sales Dashboard");
            p2.put("budget", 8500);

            // add projects
            projects.addAll(Arrays.asList(p1, p2));

            // add projects to customer
            customer.put("projects", projects);

            // write JSON to file
            Jsoner.serialize(customer, writer);

            //close the writer
            writer.close();

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }

    private  void jsonSimpleRead() {
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("customer.json"));
            System.out.println(Paths.get("customer.json").toAbsolutePath());
            //Paths.get("customer.json").toUri

            // create parser
            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

            // read customer details
            BigDecimal id = (BigDecimal) parser.get("id");
            String name = (String) parser.get("name");
            String email = (String) parser.get("email");
            BigDecimal age = (BigDecimal) parser.get("age");

            System.out.println(id);
            System.out.println(name);
            System.out.println(email);
            System.out.println(age);

            // read address
            Map<Object, Object> address = (Map<Object, Object>) parser.get("address");
            address.forEach((key, value) -> System.out.println(key + ": " + value));

            // read payment method
            JsonArray paymentMethods = (JsonArray) parser.get("paymentMethods");
            paymentMethods.forEach(System.out::println);

            // read projects
            JsonArray projects = (JsonArray) parser.get("projects");
            projects.forEach(entry -> {
                JsonObject project = (JsonObject) entry;
                System.out.println(project.get("title"));
                System.out.println(project.get("budget"));
            });

            //close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
