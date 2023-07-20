package item55;

import java.util.*;

public class App3 {

    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        System.out.println(max(list));
    }
}
