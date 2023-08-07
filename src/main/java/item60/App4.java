package item60;

public class App4 {

    public static void main(String[] args) {
        int itemsBought = 0;
        int founds = 100;
        for (int price = 10; founds >= price; price += 10){
           founds -= price;
           itemsBought++;
        }
        System.out.println(itemsBought + "∞≥ ±∏¿‘");
        System.out.println("¿‹µ∑ : " + founds);
    }

}
