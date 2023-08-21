package item61;

import java.util.Comparator;

public class App {

    public static void main(String[] args) {
        Comparator<Integer> naturalOrder =
                (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        System.out.println(naturalOrder.compare(new Integer(42), new Integer(42)));

        Comparator<Integer> naturalOrder2 = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed;
            return i < j ? -1 : ( i == j ? 0 : 1);
        };

        System.out.println(naturalOrder2.compare(new Integer(42), new Integer(42)));
    }

}
