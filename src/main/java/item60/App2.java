package item60;

public class App2 {

    public static void main(String[] args) {

        double founds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; founds >= price; price += 0.10){
            founds -= price;
            itemsBought++;
        }

        System.out.println(itemsBought + "∞≥ ±∏¿‘");
        System.out.println("¿‹µ∑ : " + founds);

    }
}
