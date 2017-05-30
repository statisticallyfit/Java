package semester1.chapter2.section_2_6;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */
public class ex27_NextAvailable_assignment extends Vic{
/*
Goal: executor puts CD in next available slot.
Precondition: stack is not empty and either current or next slot is empty.
 */

    public boolean canPutCD(){
        if(seesSlot() && !seesCD() && stackHasCD())
            return true;
        else
            return false;
    }


    public void putNextAvailable(){
        moveOn(); //move to next slot

        if(stackHasCD() && canPutCD()){
            putCD();
        }
    }

}
