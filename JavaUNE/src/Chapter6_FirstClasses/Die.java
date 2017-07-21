package Chapter6_FirstClasses;

import java.util.Random;

/**
 *
 */
public class Die {

    private final int NUMBER_OF_SIDES = 6;
    private int dieValue;

    public Die() {
        roll();
    }

    public void roll(){
        Random rand = new Random();
        dieValue = rand.nextInt(NUMBER_OF_SIDES) + 1; // + 1 makes from 0->5 to 1->6
    }

    public int getDieValue() {
        return dieValue;
    }

}