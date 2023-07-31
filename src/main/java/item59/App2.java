package item59;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class App2 {

    public static void main(String[] args) throws IOException {
        try (InputStream in = new URL("https://www.google.com/").openStream()){
            in.transferTo(System.out);
        }
    }

}
