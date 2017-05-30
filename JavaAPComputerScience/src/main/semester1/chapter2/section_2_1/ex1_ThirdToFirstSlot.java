package semester1.chapter2.section_2_1;
//import chapter2.Vic;
import BookClasses.vics.Vic;

/**
 * Created by user1928 on 9/26/14.
 */
public class ex1_ThirdToFirstSlot {

    public static void main(String[] args) {
        // set args to 01111 so first slot is empty
        Vic.reset(args);

        Vic victoria = new Vic();

        victoria.moveOn();
        victoria.moveOn();

        victoria.takeCD();

        victoria.backUp();
        victoria.backUp();

        victoria.putCD();
    }
}
