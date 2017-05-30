package semester1.chapter2.section_2_8;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/17/14.
 */
public class ex35_CanPutCDOneReturnStatement extends Vic {

    public boolean canPutCD()
    {
        /*
        if ( ! seesSlot())
            return false;
        if (seesCD())
            return false;
        if (stackHasCD())
            return true;
        else
            return false;
         */
        return seesSlot() && !seesCD() && stackHasCD();
    }

}
