package item60;

import java.math.BigDecimal;

public class App3 {

    public static void main(String[] args) {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");

        int itemsBought = 0;
        BigDecimal founds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; founds.compareTo(price) >= 0; price = price.add(TEN_CENTS)){
            founds = founds.subtract(price);
            itemsBought++;
        }

        System.out.println(itemsBought + "∞≥ ±∏¿‘");
        System.out.println("¿‹µ∑ : " + founds);
    }

}
