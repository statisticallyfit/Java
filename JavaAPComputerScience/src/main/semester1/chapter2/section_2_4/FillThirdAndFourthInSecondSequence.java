package semester1.chapter2.section_2_4;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */

//ASSIGNMENT 2.19
public class FillThirdAndFourthInSecondSequence {

    /*
    Goal: Fill in third and fourth slots in the second sequence
     */

    public static void main(String[]args) {
        //args = 0000 1100 so third and fourth can be filled in second sequence (first sequence is set to arbitrary numbers)
        Vic.reset(args);

        Vic sam = new Vic();
        Vic sue = new Vic();


        Vic.say("Hi there! I'm going to try and fill in some slots!");
        if(sue.seesSlot()){
            sue.moveOn(); //to second slot
            if(sue.seesSlot()){
                sue.moveOn(); // to third slot
                if(Vic.stackHasCD() && sue.seesSlot()){
                    sue.putCD();
                    sue.moveOn(); // to fourth slot
                    if(Vic.stackHasCD() && sue.seesSlot()){
                        sue.putCD();
                    }
                }
            }
        }
        Vic.say("Job's done or can't do anymore!");
    }
}
