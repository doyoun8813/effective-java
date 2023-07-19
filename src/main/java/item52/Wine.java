package item52;

import java.io.ObjectOutputStream;
import java.util.List;

public class Wine {
    String name() { return "������"; }
}

class SparklingWine extends Wine {
    @Override
    String name() {
        return "������ ������";
    }
}

class Champagne extends SparklingWine {
    @Override
    String name() {
        return "������";
    }
}

class Overriding {
    public static void main(String[] args) {
        List<Wine> wineList = List.of(new Wine(), new SparklingWine(), new Champagne());

        for (Wine wine : wineList) {
            System.out.println(wine.name());
        }
    }
}
