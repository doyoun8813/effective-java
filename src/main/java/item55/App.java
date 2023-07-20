package item55;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class App {

    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("ºó ÄÃ·º¼Ç");

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        }

        return result;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        System.out.println(max(list));
    }
}
