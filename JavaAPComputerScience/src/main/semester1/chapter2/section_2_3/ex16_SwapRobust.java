package semester1.chapter2.section_2_3;
import semester1.chapter2.section_2_2.SmartVic;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */
public class ex16_SwapRobust {

    public static void main(String[] args) {

        Vic.reset(args);

        SmartVic smarty = new SmartVic();

        smarty.swapTwo();
    }
}
