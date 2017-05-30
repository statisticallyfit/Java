package semester1.chapter3.section_3_2;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/24/14.
 */

//ASSIGNMENT 3.11
public class ex11_FillLastEmptySlot_assignment extends Vic {
/*
Goal: fill last empty slot. Restore original position.
Precondition: there must be empty slot and CD on stack.
 */
    public void fillLastEmptySlot(){
        String originalSpot = getPosition();
        String posOfLastEmpty = "";

        while(seesSlot() && stackHasCD()){
            if(!seesCD())
                posOfLastEmpty = getPosition();
            moveOn();
        }

        //Now put CD at posOfLastEmpty
        while(!posOfLastEmpty.equals(getPosition()))
            backUp();
        putCD();


        //Now restore original position
        while(!originalSpot.equals(getPosition()))
            backUp();
    }


}
