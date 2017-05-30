package semester1.chapter2.section_2_6;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */
public class ex24_Slot extends Vic{

    public boolean hasNoSlot(){
        if(!seesSlot())
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        Vic.reset(args);

        ex24_Slot sue = new ex24_Slot();

        sue.moveOn();
        sue.hasNoSlot();
    }
}
