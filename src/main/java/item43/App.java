package item43;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("key", 2);

        map.merge("key", 1, Integer::sum);

        System.out.println(map);
    }
}
