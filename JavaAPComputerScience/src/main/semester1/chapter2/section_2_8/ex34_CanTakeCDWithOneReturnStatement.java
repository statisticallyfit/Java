package semester1.chapter2.section_2_8;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/17/14.
 */
public class ex34_CanTakeCDWithOneReturnStatement extends Vic {

    public boolean canTakeCD()
    {
        /*
        if (seesSlot())
        {
            if (seesCD())
                return true;
        }
        return false;
         */
        return seesSlot() && seesCD();
    }
}
