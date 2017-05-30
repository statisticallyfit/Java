package semester1.chapter2.section_2_2;
import BookClasses.vics.Vic;

/**
 * Created by user1928 on 9/26/14.
 */
public class ex13_BringThreeBackRobust {

    // Move the CDs in slots 2, 3, and 4 back to slots 1, 2, 3,
    // respectively.  Presumes a reset with at least 4 slots.

    public static void main (String[ ] args)
    {
        Vic.reset(args);     // 1
        SmartVic sue = new SmartVic(); // 3
        sue.moveTake();       // 4  move to slot 2 and take CD
        sue.backPut();        // 5  back to slot 1 and put CD there

        sue.moveOn();         // 6
        sue.moveTake();       // 7  move to slot 3 and take CD
        sue.backPut();        // 8  back to slot 2 and put CD there

        sue.moveOn();
        sue.moveOn();
        sue.moveOn();
        // now sue is at position END out of 4 slots
        if(sue.seesSlot()) { /// method is made to only see slot you are standing on (not ahead)
            sue.takeCD();
            sue.backPut();
        }
    }
}
