package semester1.chapter2.section_2_3;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */
public class ex14_TakeFromFourthAndFifthRobustly {

    public static void main(String[] args) {
        // set args to 11111
        // try: 111
        // try: 1110
        // try: 1111
        // try: 11110

        Vic.reset(args);

        Vic sue = new Vic();

        sue.moveOn(); //move to second
        sue.moveOn(); //move to third (no need to check so far
        // since all sequences have at least 3 slots
        sue.moveOn();

        //check if you are standing on a slot or END
        if(sue.seesSlot()){
            //check if there is CD in slot4
            if(sue.seesCD()){
                sue.takeCD(); //take the fourth CD
            }
            sue.moveOn(); //move to fifth place
            if(sue.seesSlot()){
                if(sue.seesCD()){
                    sue.takeCD(); // take fifth CD
                }
            }
        }
    }
}
