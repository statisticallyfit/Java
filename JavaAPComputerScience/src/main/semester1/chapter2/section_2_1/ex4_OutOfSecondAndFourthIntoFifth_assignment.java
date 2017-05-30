package semester1.chapter2.section_2_1;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */


//ASSIGNMENT 2.4
public class ex4_OutOfSecondAndFourthIntoFifth_assignment {
//Goal: take CD from second and fourth and put top CD into fifth
    public static void main(String[] args) {

        // set args to 111101 so fifth slot is empty and second and fourth have a CD
        Vic.reset(args);

        Vic obj = new Vic();

        obj.moveOn(); // move to second slot
        obj.takeCD(); // take cd

        obj.moveOn();
        obj.moveOn();// move to fourth slot
        obj.takeCD(); // take cd

        obj.moveOn();// move to fifth
        obj.putCD();

        // ANSWER: the second CD (d1) that was taken from the fourth slot will be placed in
        // the fifth slot. This is because the takeCD() method arranges the CDs in a stack:
        // the last CD taken is the first one picked.
    }
}
