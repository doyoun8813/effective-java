package item59;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class App {

    static Random rnd = new Random();

    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) throws IOException {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if(random(n) < n / 2) {
                low++;
            }
        }

         System.out.println(low);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(Math.abs(Integer.MAX_VALUE));
        System.out.println(Math.abs(Integer.MIN_VALUE) % 15);

    }
}
