package semester1.chapter2.section_2_3;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */
public class TwoFour {

    //If CD is in 2nd slot, remove it and put it in fourth slot

    public static void main(String[] args){
        // try 1: set args to 1110
        //try 2: set args to 101
        //try 3: set args to 111

        Vic.reset(args);

        //testing class method say
        Vic.say("Hi, I'm going to switch some CDs");

        Vic sue = new Vic();
        sue.moveOn(); //move to second slot

        if (sue.seesCD()){
            sue.takeCD();
            sue.moveOn();
            sue.moveOn();
            if (sue.seesSlot()) {
                sue.putCD();
            }
        }
    }
}
