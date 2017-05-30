package semester1.chapter2.section_2_5;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */
public class TwoVics
{
    /** Take the CD in slot 1 if there is one, otherwise put a
     *  CD there; repeat for the second sequence, if any. */

    public static void main (String[ ] args)
    {
        Vic first;                       // 1
        first = new Vic();               // 2

        if (first.seesCD())              // 3
            first.takeCD();               // 4
        else                             // 5
            first.putCD();                // 6

        Vic second;                      // 7
        second = new Vic();
                                         // 8
        if (second.seesSlot())           // 9
        {
            if (second.seesCD())          // 10
                second.takeCD();           // 11
        else                          // 12
            second.putCD();            // 13
        }                                // 14
    }
}