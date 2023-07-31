package item58;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

public class Dice {

    enum Face { ONE, TWO, THREE, FOUR, FIVE, SIX }

    public static void main(String[] args) {
        Collection<Face> faces = EnumSet.allOf(Face.class);

        for (Face firstDice : faces) {
            for (Face secondDice : faces) {
                System.out.println(firstDice + " " + secondDice);
            }
        }
    }
}
