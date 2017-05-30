package semester1.chapter2.section_2_3;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */
public class Shifter extends Vic {
    //take CD from slot3(check before) and put it in slot5 (checking for slots  all the way

    public void shiftFromThreeToFive() {
        moveOn();
        moveOn(); //if 1 slot, then at least 3 slots too (definition of vics)
        if(seesCD()){
            takeCD();
            moveOn();
            if(seesSlot()){
                moveOn();
                if(seesSlot()){
                    putCD();
                }
            }
        }
    }
}

/*
MYCODE:
moveOn();
        moveOn(); //if 1 slot, then at least 3 slots too (definition of vics)
        if(seesCD()){
            takeCD();
            if(seesSlot()){
                moveOn();
                if(seesSlot()){
                    moveOn();
                    putCD();
                }
            }
        }else{
            say("CANNOT SEE CD"); //remain blocked
        }
 */
