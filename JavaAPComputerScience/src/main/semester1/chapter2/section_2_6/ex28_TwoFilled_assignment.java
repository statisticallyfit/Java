package semester1.chapter2.section_2_6;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */


//ASSIGNMENT 2.28
public class ex28_TwoFilled_assignment extends Vic{

    /*
    Goal: tell whether current and next slot exist and both have CDs.
    This program returns true only if both slots exists and are filed. Returns false in any other condition
    REMEMBER: leave executor in original state.
    */

    //set args to: 00, 1, 10, 11 to test all conditions
    public boolean seesTwoFilled()
    {
        if(!seesSlot()){
            say("No slot, so further analysis is terminated");
            return false;
        }

        //else if slot is there
        //and if does not see CD
        if (!seesCD()){
            say("No CD, so further analysis is terminated");
            return false;
        }
        //else if sees CD
        say("First slot is filled. So we can move on.");
        moveOn(); // to second slot


        if(seesSlot()) //at second spot
        {
            if(seesCD())
            {
                backUp(); //return to original state
                say("YAY! Both slots exists and are filled! ");
                return true; //since both slots exist filed
            }else{
                //else if sees no CD
                say("Second slot is unfilled");
                return false;
            }

        }else{  //else if sees no slot
            say("No second slot, so further analysis is terminated");
            backUp(); //return to original state
            return false;
        }
    }
}

