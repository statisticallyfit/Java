package main;


public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 8;

    /**
     * The number of values to shuffle.
     */
    private static final int VALUE_COUNT = 10; //was 4

    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    /*public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT + " consecutive perfect shuffles:");

        int[] values1 = new int[VALUE_COUNT];

        for (int i = 0; i < values1.length; i++) {
            values1[i] = i;
        }

        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                " consecutive efficient selection shuffles:");
        int[] values2 = new int[VALUE_COUNT];
        for (int i = 0; i < values2.length; i++) {
            values2[i] = i;
        }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values2.length; k++) {
                System.out.print(" " + values2[k]);
            }
            System.out.println();
        }
        System.out.println();
    }*/


    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void perfectShuffle(int[] values) {
        int[] shuffled = new int[VALUE_COUNT];

        int k = 0;
        for(int j = 0; j < (values.length + 1)/2; j++){
            shuffled[k] = values[j];
            k += 2;
        }

        k = 1;
        for(int j = (values.length + 1)/2; j < values.length; j++){
            shuffled[k] = values[j];
            k += 2;
        }

        //copy shuffled elements into the values array
        for(int i = 0; i < values.length; i++){
            values[i] = shuffled[i];
        }
    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(int[] values) {

        for(int k = values.length - 1; k > 0; k--){
            int randIndex = (int)(Math.random() * (k + 1));
            //swap
            int temp = values[k];
            values[k] = values[randIndex];
            values[randIndex] = temp;
        }
    }

    public static String flip(){
        int randNum = (int)(Math.random() * 3);

        if(randNum == 0 || randNum == 1)
            return "heads";
        return "tails";
    }

    //Precondition: arrays are same length but
    //and each do not have duplicates
    public static boolean arePermutations(int[] a1, int[] a2){
        boolean commonElementWasFound = false;

        for(int i = 0; i < a1.length; i++){
            for(int j = 0; j < a2.length; j++){
                if(a1[i] == a2[j]){
                    commonElementWasFound = true;
                }
            }
            if(!commonElementWasFound)
                return false;
            commonElementWasFound = false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4};
        selectionShuffle(values);
        for(int val : values)
            System.out.print(val + " ");

    }
}
