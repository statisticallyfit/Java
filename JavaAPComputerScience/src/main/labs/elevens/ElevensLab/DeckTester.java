package labs.elevens.ElevensLab;


public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
/*
        //TESTING CONSTRUCTOR:

        String[] ranks1 = new String[]{"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
        String[] suits1 = new String[]{"hearts", "diamonds", "spades", "clubs"};
        int[] points1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        Deck deck1 = new Deck(ranks1, suits1, points1);
        System.out.println(deck1 + "\n\n");

        //------------------------------------------------------------
        String[] ranks2 = new String[]{"A", "B", "C"};
        String[] suits2 = new String[]{"Giraffes", "Lions"};
        int[] values2 = new int[]{2, 1, 6};

        Deck deck2 = new Deck(ranks2, suits2, values2);
        System.out.println(deck2 + "\n\n");

        //------------------------------------------------------------
        String[] ranks3 = new String[]{"rose", "lily", "narcissa"};
        String[] suits3 = new String[]{"pink", "white", "violet"};
        int[] numPetals = new int[]{3, 5, 8};

        Deck deck3 = new Deck(ranks3, suits3, numPetals);
        System.out.println(deck3 + "\n\n");




        //TESTING IS EMPTY

        if(deck2.isEmpty())
            System.err.println("ERROR: deck1 is full and cannot be declared empty");


        //TESTING DEAL

        System.out.println("Dealing a card: ");
        System.out.println("    deal: " + deck2.deal() + "\n\n");
        System.out.println("Deck after 1 card dealt: ");
        System.out.println("    test toString(): " + deck2.toString());
        System.out.println("    test isEmpty(): ");
        if((deck2.size() == 0) != (deck2.isEmpty()))
            System.err.println("Method isEmpty() failed since size is " + deck2.size() + " and isEmpty() returned: " + deck3.isEmpty());

        System.out.println("Deal the leftover five cards: " );
        for(int i = 0; i < 5; i++){
            System.out.println("    deal: " + deck2.deal());
        }

        System.out.println("Deal from empty deck:");
        System.out.println("    deal(): " + deck2.deal());*/

        String[] ranks = {"jack", "queen", "king"};
        String[] suits = {"blue", "red"};
        int[] pointValues = {11, 12, 13};
        Deck deck = new Deck(ranks, suits, pointValues);


        String[] ranks1 = new String[]{"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
        String[] suits1 = new String[]{"hearts", "diamonds", "spades", "clubs"};
        int[] points1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        Deck d = new Deck(ranks1, suits1, points1);

        System.out.println("**** Original Deck Methods ****");
        System.out.println("  toString:\n" + d.toString());
        System.out.println("  isEmpty: " + d.isEmpty());
        System.out.println("  size: " + d.size());
        System.out.println();
        System.out.println();

        System.out.println("**** Deal a Card ****");
        System.out.println("  deal: " + d.deal());
        System.out.println();
        System.out.println();

        System.out.println("**** Deck Methods After 1 Card Dealt ****");
        System.out.println("  toString:\n" + d.toString());
        System.out.println("  isEmpty: " + d.isEmpty());
        System.out.println("  size: " + d.size());
        System.out.println();
        System.out.println();

        int deckSize = d.size();
        System.out.println("**** Deal Remaining " + deckSize + " Cards ****");
        for (int i = 0; i < deckSize; i++) {
            System.out.println("  deal: " + d.deal());
            System.out.println("  size: " + d.size());
        }
        System.out.println();
        System.out.println();

        System.out.println("**** Deck Methods After All Cards Dealt ****");
        System.out.println("  toString:\n" + d.toString());
        System.out.println("  isEmpty: " + d.isEmpty());
        System.out.println("  size: " + d.size());
        System.out.println();
        System.out.println();

        System.out.println("**** Deal a Card From Empty Deck ****");
        System.out.println("  deal: " + d.deal());
        System.out.println();
        System.out.println();

		/* *** TO BE COMPLETED IN ACTIVITY 4 *** */
    }
}

