package semester1.chapter2.section_2_6;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */
public class ex29_OneInStack_assignment extends Vic{

    /*
    Goal: program finds whether exactly one CD is in the stack.
    Precondition: current slot exists empty.
    REMEMBER: leave executor in original state.
     */
    public boolean hasJustOneInStack(){

        if(stackHasCD() && seesSlot()){
            if(!seesCD()){
                putCD();
                if(stackHasCD()){
                    takeCD(); // to return to original state
                    say("More than one CD");
                    return false;
                }else{
                    takeCD(); //to return to original state
                    say("Just one in stack");
                    return true;
                }
            }else{ //if sees CD
                say("Can't tell, since slot is full");
            }
        }return false; //since there's either empty stack or no slot
    }

    public static void main(String[] args){
        //set args to: 0000 or 1111 to test conditions

        Vic.reset(args);

        ex29_OneInStack_assignment sue = new ex29_OneInStack_assignment();

        sue.hasJustOneInStack();
    }
}
