package labs.elevens.ElevensLab;



public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
		Card card1 = new Card("four", "spades", 4);
        System.out.println(card1);

        Card card2 = new Card("ace", "hearts", 1);
        System.out.println(card2);

        Card card3 = new Card("queen", "clubs", 11);
        System.out.println(card3);
    }
}
