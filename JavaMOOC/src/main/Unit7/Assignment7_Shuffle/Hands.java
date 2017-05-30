package main.Unit7.Assignment7_Shuffle;


import java.util.ArrayList;

public class Hands {

    public static final int NUM_CARDS_IN_HAND = 5;
    private ArrayList<Card> firstHand = new ArrayList<Card>(5);
    private ArrayList<Card> secondHand = new ArrayList<Card>(5);


    public Hands(){
        this.deal();
    }

    public void deal(){
        Deck deck = new Deck();
        for(int i = 0; i < NUM_CARDS_IN_HAND; i++){
            firstHand.add(deck.getTopCard());
            secondHand.add(deck.getTopCard());
        }
    }

    public int[] getPointsForHands(){
        int[] firstSecond = new int[2];

        for(Card card : firstHand)
            firstSecond[0] += card.pointValue();
        for(Card card : secondHand)
            firstSecond[1] += card.pointValue();

        return firstSecond;
    }

    public void declareWinner(){
        int[] points = getPointsForHands();

        System.out.println("Hand 1: total points " + points[0]);
        for(Card card : firstHand)
            System.out.println(card);

        System.out.println("\nHand 2: total points " + points[1]);
        for(Card card : secondHand)
            System.out.println(card);

        if(points[0] <= points[1])
            System.out.println("\nHand 2 wins");
        else
            System.out.println("\nHand 1 wins");
    }

    public static void main(String[] args) {
        Hands twoHands = new Hands();
        twoHands.declareWinner();
    }
}
