package semester1.chapter2.section_2_7;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/17/14.
 */

public class Checker2 extends Vic   // improved version
{
    /** Tell whether the stack has at least two CDs.
     *  Precondition: the executor is not at the end
     *  of its slots and the current slot is empty. */

    public boolean hasTwoOnStack()
    {
        if(!stackHasCD())
            return false;
        putCD();                             // modify state
        boolean result;
        result = stackHasCD();
        takeCD();                            //  restore state

        return result; //result after checking second time if stack has CD
    }

    /** Tell whether the executor's current slot and the
     *  one after it exist and have no CD.  No precondition. */

    public boolean seesTwoEmpty()
    {
        if(!seesSlot())
            return false;
        if (seesCD())
            return false;

        moveOn();                            //  modify state
        boolean valueToReturn;

        if(!seesSlot())
            valueToReturn = false;
        else
            valueToReturn = ! seesCD();
        backUp();                            // restore state

        return valueToReturn;
    }

    public static void main(String[] args){

        Vic.reset(args);

        Checker2 booly = new Checker2();

        booly.hasTwoOnStack();

        booly.seesTwoEmpty();

    }
}
