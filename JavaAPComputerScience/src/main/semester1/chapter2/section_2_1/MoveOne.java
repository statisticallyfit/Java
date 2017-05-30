package semester1.chapter2.section_2_1;
import BookClasses.vics.Vic;

// Note: amount of digits in command like (0111) sets slot number
//       zero means empty slot with no letter (CD), 1 means CD in slot
//       EXAMPLE: 0111 1110 101 === three sequences, four slots and three slots, each has an empty slot.

/**
 * Created by user1928 on 9/26/14.
 */
public class MoveOne extends Vic
{
    // Take a CD from the third slot; put it in the second slot.

    public static void main (String[ ] args)
    {
        //set args to: 101 so second slot is empty and third is full
        Vic.reset(args);
        Vic sue;          // 1
        sue = new Vic();  // 2

        sue.moveOn();     // 3  move to the second slot
        sue.moveOn();     // 4  move to the third slot
        sue.takeCD();     // 5  take CD from slot 3, put on stack

        sue.backUp();     // 6  move back to the second slot
        sue.putCD();      // 7  put CD in slot 2, taken from stack
    }
}
