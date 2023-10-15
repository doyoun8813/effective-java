import item69.App;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;

public class ExceptionTest {

    @Test
    public void test1() {

        int i = 0;
        Mountain[] range = new Mountain[100_000_000];

        try {
            while (true) {
                range[i] = new Mountain();
                range[i++].climb();
            }
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        } finally {
            System.out.println(range[range.length-1]);
        }
    }

    @Test
    public void test2() {
        Mountain[] range = new Mountain[100_000_000];

        for (int i = 0; i < range.length; i++) {
            range[i] = new Mountain();
            range[i].climb();
        }
        System.out.println(range[range.length-1]);
    }

    private static class Mountain {
        public void climb() {
        }
    }

    @Test
    public void exceptionTest() {
        int i = 0;
        int[] arr = new int[100_000_000];

        try {
            while (true) {
                arr[i] = i++;
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void loopTest() {
        int size = 100_000_000;
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
    }
}
