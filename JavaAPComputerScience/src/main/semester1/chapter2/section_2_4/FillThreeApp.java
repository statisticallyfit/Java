package semester1.chapter2.section_2_4;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */

// ASSIGNMENT 2.20: part 2, revising listing 2.6 with fillThree()
public class FillThreeApp {

    /*
    Goal: fill the first three slots, stop when stack is empty
    */

    public static void main (String[ ] args)
    {

        //set args: 000 000 so that all three slots are empty

        Vic.reset (args);

        Vic.say ("This program fills the first three slots.");

        SubclassOfVic vicOne = new SubclassOfVic();
        SubclassOfVic vicTwo = new SubclassOfVic();

        vicOne.fillThree();
        vicTwo.fillThree();

        Vic.say ("All done!");
    }
}
