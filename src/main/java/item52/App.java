package item52;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        // 1��
        new Thread(System.out::println).start();

        // 2��
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit((Runnable) System.out::println);
    }
}
