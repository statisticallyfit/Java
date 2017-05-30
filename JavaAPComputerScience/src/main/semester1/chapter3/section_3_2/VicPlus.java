package semester1.chapter3.section_3_2;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/24/14.
 */
public class VicPlus extends Vic {
    /** tell whether sequence has any CD. **/

    public boolean hasSomeFilledSlot(){
        String spot = getPosition();
        boolean returnValue;

        while(seesSlot() && !seesCD())
            moveOn();
        //LOGIC: if while failed because there was no slot, then there was no CD so far either
        //       if while loop failed because there was CD, then seesSlot is true = retval = true
        returnValue = seesSlot();

        while(!spot.equals(getPosition()))
            backUp();

        return returnValue;
    }

    public void goToLastCD(){
        String spot = getPosition();

        while(seesSlot()){
            if(seesCD())
                spot = getPosition(); //mark spot of empty slot
            moveOn();
        }
        while(!spot.equals(getPosition()))
            backUp();
    }

}
