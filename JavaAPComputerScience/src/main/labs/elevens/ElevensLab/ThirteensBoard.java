package labs.elevens.ElevensLab;


import java.util.List;

public class ThirteensBoard extends Board {

    private static final int BOARD_SIZE = 10;
    private static final String[] RANKS = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
    private static final String[] SUITS = {"spades", "hearts", "diamonds", "clubs"};
    private static final int[] POINT_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private static final boolean I_AM_DEBUGGING = false;

    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ThirteensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        if (selectedCards.size() == 2) {
            return containsPairSum13(selectedCards);
        } else if (selectedCards.size() == 1) {
            return containsKing(selectedCards);
        } else {
            return false;
        }
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {
        List<Integer> cIndexes = cardIndexes();
        return containsPairSum13(cIndexes) || containsKing(cIndexes);
    }

    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum13(List<Integer> selectedCards) {
        for(int sk1 = 0; sk1 < selectedCards.size() - 1; sk1++){
            int k1 = selectedCards.get(sk1);
            for(int sk2 = sk1 + 1; sk2 < selectedCards.size(); sk2++){
                int k2 = selectedCards.get(sk2);
                if(this.cardAt(k1).pointValue() + this.cardAt(k2).pointValue() == 13) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsKing(List<Integer> selectedCards) {

        for (Integer selectedIndex : selectedCards) {
            if (this.cardAt(selectedIndex).rank().equals("king")) {
                return true;
            }
        }
        return false;
    }


    /**
     * Looks for a legal play on the board.  If one is found, it plays it.
     * @return true if a legal play was found (and made); false othewise.
     */
    public boolean playIfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 11 *** */
        return false; // REPLACE !
    }

    /**
     * Looks for a pair of non-face cards whose values sum to 13.
     * If found, replace them with the next two cards in the deck.
     * The simulation of this game uses this method.
     * @return true if an 13-pair play was found (and made); false othewise.
     */
    private boolean playPairSum13IfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 11 *** */
        return false; // REPLACE !
    }

    /**
     * Looks for a King.
     * If found, replace it with the next card in the deck.
     * The simulation of this game uses this method.
     * @return true if a king play was found (and made); false othewise.
     */
    private boolean playKingIfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 11 *** */
        return false; // REPLACE !
    }
}
