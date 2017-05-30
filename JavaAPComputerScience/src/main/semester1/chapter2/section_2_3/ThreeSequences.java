package semester1.chapter2.section_2_3;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */
public class ThreeSequences {
    // try1: 11110
    // try2:

    public static void main(String[] args){
        Vic.reset(args);

        Shifter one = new Shifter();
        Shifter two = new Shifter();
        Shifter three = new Shifter();

        one.shiftFromThreeToFive();

        if(two.seesSlot()){
            two.shiftFromThreeToFive();

            if(three.seesSlot())
                three.shiftFromThreeToFive();
        }
    }
}

