package semester1.chapter2.section_2_8;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/17/14.
 */


//ASSIGNMENT 2.37
public class ex37_SeesTwoEmptyOneReturnStatement_assignment extends Vic {
/*
Goal: verify if first and second slots are empty with one return statement.
 */
    public boolean seesTwoEmpty()
    {//args 10, 11, 0, 1 will return false, arg 00 will return true.

        boolean result;

        if(seesSlot() && !seesCD()){
            //result = true;                              //case1: first slot and first CD
            moveOn();

            if(seesSlot() && !seesCD())
                result = true;                          //case3: second slot and CD exist
            else
                result = false;                         //case4: second slot or second CD does not exist.
            backUp(); //restore state in either case
        }
        else
            result = false;                             //case2: either no first slot or no first CD

        return result;
    }

}



