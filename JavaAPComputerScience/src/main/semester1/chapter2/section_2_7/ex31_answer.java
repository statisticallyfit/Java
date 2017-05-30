package semester1.chapter2.section_2_7;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/17/14.
 */
public class ex31_answer extends Vic {

    /** Tell whether the stack has at most one CD.
     *  Precondition: the executor is not at the end
     *  of its slots and the current slot is empty. */

    public boolean atMostOneOnStack()
    {
        boolean result;

        if(!stackHasCD())
            result = true;
        else{
            putCD();                             // modify state
            result = !stackHasCD();
            takeCD();                            //  restore state
        }

        return result; //result after checking second time if stack has CD
    }

    public static void main(String[] args){
        Vic.reset(args);

        ex31_answer booly = new ex31_answer();

        booly.atMostOneOnStack();
    }

}
