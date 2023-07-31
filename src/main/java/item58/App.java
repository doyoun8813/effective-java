package item58;

import java.util.*;

public class App {

    static class Card {
        Suit suit;
        Rank rank;

        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public Suit getSuit() {
            return suit;
        }

        public Rank getRank() {
            return rank;
        }
    }

    enum Suit { CLUB, DIAMOND, HEART, SPADE }
    enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }
    
    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        for(Iterator<Suit> i = suits.iterator(); i.hasNext();){
            Suit suit = i.next();
            for(Iterator<Rank> j = ranks.iterator(); j.hasNext();){
                deck.add(new Card(suit, j.next()));
            }
        }

        for (Card card : deck) {
            System.out.println(card.getRank() + ", " + card.getSuit());
        }
    }
}
