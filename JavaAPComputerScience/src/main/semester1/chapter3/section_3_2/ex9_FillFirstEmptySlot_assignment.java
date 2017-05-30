package semester1.chapter3.section_3_2;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/24/14.
 */
//ASSIGNMENT 3.9
public class ex9_FillFirstEmptySlot_assignment extends Vic {
/*
Goal: executor puts CD in first empty slot. Leave position unchanged.
Precondition: stack has CD and there is empty slot
 */
    public void fillFirstEmptySlot(){
        String originalSpot = getPosition(); //getposition returns (1, 0) if at beginning
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
        //restore position
        while(!originalSpot.equals(getPosition()))
            backUp();

    }


}
