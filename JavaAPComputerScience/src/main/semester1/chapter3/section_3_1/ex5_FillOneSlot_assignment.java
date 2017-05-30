package semester1.chapter3.section_3_1;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/24/14.
 */

//ASSIGNMENT 3.5
public class ex5_FillOneSlot_assignment extends Vic {
/*
Goal: fill the first empty slot you see. If all empty, advance to end of sequence. Fill one slot only.
 */
    public void fillOneSlot(){

        int slotsFilled = 0;

        while(seesSlot()){
            if(!seesCD()){
                putCD();
                slotsFilled++;
            }
            if(slotsFilled >=1)
                break;
            moveOn();
        }
    }
}
