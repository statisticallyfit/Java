package semester1.chapter2.section_2_1;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */

//ASSIGNMENT 2.5
public class ex5_Swap2And3_assignment {
//Goal: swap CDs from slots2 and 3
    public static void main(String[] args) {

        //set args to 1111 so all slots (including slots 2 and 3) are filled

        Vic.reset(args);

        Vic vic = new Vic();

        vic.moveOn(); //move to second slot
        vic.takeCD();
        vic.moveOn(); //move to third slot
        vic.takeCD();
        vic.backUp(); //move back to 2nd slot
        vic.putCD(); // this will place slot 3's CD in slot2 because slot3's CD is on top of the stack since it is last
        vic.moveOn(); //move to third slot
        vic.putCD();


    }
}
