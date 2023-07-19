package item52;

import java.math.BigInteger;
import java.util.*;

public class CollectionClassifier {

    /*public static String classify(Set<?> s) {
        return "����";
    }

    public static String classify(List<?> list) {
        return "����Ʈ";
    }

    public static String classify(Collection<?> c) {
        return "�� ��";
    }*/

    public static String classify(Collection<?> c) {
        return c instanceof Set ? "����" :
                c instanceof List ? "����Ʈ" : "�׿�";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> collection : collections) {
            System.out.println(classify(collection));
        }
    }

}
