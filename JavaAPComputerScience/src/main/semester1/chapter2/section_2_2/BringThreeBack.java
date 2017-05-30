package semester1.chapter2.section_2_2;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */
public class BringThreeBack {

    public static void main(String[] args) {
        //set args to 0111 so first slot is empty and the rest are full

        Vic.reset(args);

        SmartVic sue = new SmartVic();

        sue.moveTake(); // move to slot 2 and take it
        sue.backPut(); // move to slot 1 and put it

        sue.moveOn(); //move to slot2
        sue.moveTake(); //move to slot3 and take it
        sue.backPut();// move to slot2 and put it

        sue.moveOn(); //move to slot3
        sue.moveTake(); //move to slot4 and take it
        sue.backPut();// move to slot3 and put it


    }
}
