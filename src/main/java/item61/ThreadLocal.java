package item61;


import java.util.HashMap;
import java.util.Map;

public class ThreadLocal {

    private static final Map<String, Object> datamap = new HashMap<>();

    private ThreadLocal() { }

    public static class Key {
        Key() {}
    }

    public static Key getKey(){
        return new Key();
    }

    public static void set(String key, Object value){
        datamap.put(key, value);
    }

    public static Object get(String key){
        return datamap.get(key);
    }

    public static void main(String[] args) {

        ThreadLocal.set("key1", "value1");

        System.out.println(ThreadLocal.get("key1"));

        Thread thread = new Thread(() -> {

            ThreadLocal.set("key2", "value2");
            ThreadLocal.set("key1", "value3");

            System.out.println(ThreadLocal.get("key1"));
            System.out.println(ThreadLocal.get("key2"));
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ThreadLocal.get("key1"));
        System.out.println(ThreadLocal.get("key2"));



    }
}
