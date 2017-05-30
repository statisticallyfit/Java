package semester1.chapter3.section_3_1;
//import chapter3.Vic;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/24/14.
 */

//ASSIGNMENT 3.4
public class ex4_fillFirstSlotOfSequences_assignment extends Vic {
/*
Goal: fill first slot of sequences. This stops when stack is empty or when no more sequences are given in command line args
 */

    public static void main(String[] args){

        Vic.reset(args);

        ex4_fillFirstSlotOfSequences_assignment busybee = new ex4_fillFirstSlotOfSequences_assignment();

        while(busybee.seesSlot()){
            if(!busybee.seesCD() && Vic.stackHasCD())
                busybee.putCD();
            //create new object for given sequences; if no more sequences in args, busybee.seesSlot() is false
            busybee = new ex4_fillFirstSlotOfSequences_assignment();

        }

    }
}
