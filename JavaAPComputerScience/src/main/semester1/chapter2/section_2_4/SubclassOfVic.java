package semester1.chapter2.section_2_4;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */

//ASSIGNMENT 2.20: part 1, creating fillThree() in subclass of Vic
public class SubclassOfVic extends Vic{

    /*
    Goal: fill the first three slots, stop when stack is empty
     */


    public void fillThree(){
        if(stackHasCD() && seesSlot() && !seesCD()){
            putCD(); //at first slot
            moveOn(); //to second slot
            if(stackHasCD() && seesSlot() && !seesCD()){
                putCD(); //at second slot
                moveOn();
                if(stackHasCD() && seesSlot() && !seesCD()){
                    putCD(); // at third slot
                }
            }
        }
    }
}
