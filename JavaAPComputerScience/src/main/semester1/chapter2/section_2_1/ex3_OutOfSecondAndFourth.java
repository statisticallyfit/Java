package semester1.chapter2.section_2_1;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */
public class ex3_OutOfSecondAndFourth {

    public static void main(String[] args) {

        // set args to 11111
        Vic.reset(args);

        Vic sue = new Vic();

        sue.moveOn();
        sue.takeCD();
        sue.moveOn();
        sue.moveOn();
        sue.takeCD();

    }
}
