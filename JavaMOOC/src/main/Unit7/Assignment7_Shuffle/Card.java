package main.Unit7.Assignment7_Shuffle;

/*
 * AP CS MOOC
 * Term 2 - Assignment 5: Shuffle
 * A class which represents a single playing card, Card. Use this class to test the
 * methods in your Deck and Main classes.
 */

public class Card {

    private String suit;
    private String rank;
    private int pointValue;

    public Card(String cardRank, String cardSuit, int cardPointValue) {
        rank = cardRank;
        suit = cardSuit;
        pointValue = cardPointValue;
    }

    public String suit() {
        return suit;
    }

    public String rank() {
        return rank;
    }

    public int pointValue() {
        return pointValue;
    }

    public boolean matches(Card otherCard) {
        return otherCard.suit().equals(this.suit())
                && otherCard.rank().equals(this.rank())
                && otherCard.pointValue() == this.pointValue();
    }

    @Override
    public String toString() {
        return rank + " of " + suit + " (point value = " + pointValue + ")";
    }
}
