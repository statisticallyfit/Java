package semester1.chapter3.section_3_2;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/24/14.
 */
public class ex8_HasAtLeastTwoFilledSlots extends Vic  {

    public boolean hasAtLeastTwoFilledSlots(){
        String spot = getPosition();
        boolean returnValue;

        while(seesSlot() && !seesCD())
            moveOn();
        moveOn();
        while(seesSlot() && !seesCD()) // a second time
            moveOn();
        //LOGIC: if while failed because there was no slot, then there was no CD so far either
        //       if while loop failed because there was CD, then seesSlot is true = retval = true
        returnValue = seesSlot();

        while(!spot.equals(getPosition()))
            backUp();

        return returnValue;
    }

    public static void main(String[] args){

        Vic.reset(args);

        ex8_HasAtLeastTwoFilledSlots busybee = new ex8_HasAtLeastTwoFilledSlots();

        busybee.hasAtLeastTwoFilledSlots();
    }
}
