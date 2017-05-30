package semester1.chapter2.section_2_7;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/17/14.
 */
public class Checker3 extends Vic {

    /** Tell whether the executor's current slot and the
     *  one after it exist and have no CD.  No precondition. */

    public boolean seesTwoEmpty()
    {
        boolean valueToReturn;

        if(!seesSlot() || seesCD())
            return false;
        moveOn(); //to second slot          // change state
        valueToReturn = seesSlot() && !seesCD();
        backUp();                            // restore state

        return valueToReturn;
    }
}
