package semester1.chapter2.section_2_6;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */
public class Checker extends Vic
{
    /** Tell whether the stack has at least two CDs.
     *  Precondition: the executor is not at the end
     *  of its slots and the current slot is empty. */

    public boolean hasTwoOnStack()
    {
        if(!stackHasCD()){
            say("No CDs");
            return false;
        }
        putCD();

        if(stackHasCD())
        {
            takeCD();
            say("Has two CDs");
            return true;
        }
        else
        {
            takeCD();    //have one CD now
            return false;
        }
    }


    /** Tell whether the executor's current slot and the one
     *  after it exist and have no CD.  No precondition. */

    public boolean seesTwoEmpty()
    {
        if(!seesSlot())
            return false;

        if (seesCD())
            return false;
        //else
        moveOn();

        if(seesSlot())
        {
            if(!seesCD())
            {
                backUp();
                return true;
            }
        }//else
        backUp();
        return false;
    }

    public static void main(String[] args){
        Vic.reset(args);

        Checker checks = new Checker();

        //checks.takeCD(); //take CD so we have something to work with
//        checks.putCD();
//        checks.moveOn();
//        checks.putCD();
//        checks.backUp();

        //checks.hasTwoOnStack();

        checks.seesTwoEmpty();
    }
}