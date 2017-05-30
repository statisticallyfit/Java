package semester1.chapter2.section_2_1;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */
public class ex2_CDInEachThreeSlots {

    public static void main(String[] args) {
        // set args to 00011 so first three slots are empty

        Vic.reset(args);

        Vic vicky = new Vic();

        // move beyond the three empty slots
        vicky.moveOn();
        vicky.moveOn();
        vicky.moveOn();

        // get three cds
        vicky.shiftFromSlotToStack();
        vicky.moveOn();
        vicky.shiftFromSlotToStack();
        vicky.moveOn();
        vicky.shiftFromSlotToStack();

        //move back to first slot
        vicky.backUp();
        vicky.backUp();
        vicky.backUp();

        //now place them
        vicky.putCD();
        vicky.backUp();

        vicky.putCD();
        vicky.backUp();

        vicky.putCD();

    }
}
