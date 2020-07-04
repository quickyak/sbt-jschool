package video.net;

import java.net.*;
import java.io.*;

// SOurce - https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
// Reading Directly from a URL

public class URLReader {
    public static void main(String[] args) throws Exception {

        String urlAddress = "https://www.donnews.ru/Bolee-35-tysyachi-vypusknikov-Rostovskoy-oblasti-sdali-pervyy-EGE_108945";
//        String urlAddress = "http://www.oracle.com/";
         urlAddress = "https://www.youtube.com/watch?v=BQidh8H0fMo";

        URL url = new URL(urlAddress);


        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}