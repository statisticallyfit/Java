package semester1.chapter2.section_2_7;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/17/14.
 */

//ASSIGNMENT 2.32
public class ex32_CDInPreviousSlot_assignment extends Vic {

    /*
    Goal: the executor tells whether a CD is in the slot before the current one.
    Use only one return stadtement.

    Precondition: executor is not at the first slot in its sequence.
     */
    public boolean hasOneBefore(){
        //args 10 will return TRUE, args 00 will return FALSE.
        boolean result;

        moveOn(); //to second slot (this should be called the original state to satisfy the method assumptions)

        backUp(); // to first slot

        if(seesSlot() && seesCD())
            result = true; // case1: there is a CD in previous slot
        else// seesCD must be false. seesSlot() is always true since there is always at least one slot available
            result = false; //case2: there is no CD in previous slot

        moveOn(); //back to second slot to restore original state

        return result;
    }

}
