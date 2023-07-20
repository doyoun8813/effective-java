package item54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    private final List<Cheese> cheeseInStock = new ArrayList<>();

    /*public static List<Cheese> getCheese() {
        return cheeseInStock.isEmpty() ? null : new ArrayList<>(cheeseInStock);
    }*/

    /*public List<Cheese> getCheese() {
        return new ArrayList<>(cheeseInStock);
    }*/

    /*public List<Cheese> getCheese() {
        return cheeseInStock.isEmpty() ? Collections.emptyList() : new ArrayList<>(cheeseInStock);
    }*/

    public Cheese[] getCheese() {
        return cheeseInStock.toArray(new Cheese[0]);
    }

    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

    /*public Cheese[] getCheeses() {
        return cheeseInStock.toArray(EMPTY_CHEESE_ARRAY);
    }*/

    public Cheese[] getCheeses() {
        return cheeseInStock.toArray(new Cheese[cheeseInStock.size()]);
    }

    public static void main(String[] args) {
        /*List<Cheese> cheeses = getCheese();
        if(cheeses != null && cheeses.contains(Cheese.STILTON))
            System.out.println("좋았어, 바로 그거야");*/
    }
}
