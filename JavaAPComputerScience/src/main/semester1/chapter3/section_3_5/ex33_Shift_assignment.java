package semester1.chapter3.section_3_5;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/31/14.
 */

/*
ASSIGNMENT 3.33: shift CDs from either par to the executor
 */
public class ex33_Shift_assignment extends Vic {

    public void shiftOne(Vic one, Vic two){

        while(this.seesSlot() && one.seesSlot() && two.seesSlot()){
            if (!this.seesCD() && (one.seesCD() && !two.seesCD())){
                one.takeCD();
                this.putCD();
            }else if((!this.seesCD() && (!one.seesCD() && two.seesCD()))){
                two.takeCD();
                this.putCD();
            }
            this.moveOn();
            one.moveOn();
            two.moveOn();
        }
    }
}
