package item52;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        // 1¹ø
        new Thread(System.out::println).start();

        // 2¹ø
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit((Runnable) System.out::println);
    }
}
