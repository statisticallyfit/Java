package semester1.chapter3.section_3_3;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/24/14.
 */
public class ex12_MoveToFront2 extends Vic {
    /** Move all the CDs in the first sequence of slots up to the
     *  front of the sequence. Precondition: stack is empty. */


    public void moveToFront(){

        int numberOfCDs = 0;
        int pos = 1;


        while (seesSlot()) {                   // design step 3
            if(seesCD()){
                takeCD();
                numberOfCDs++;
            }
            moveOn();
            pos++;
        }
        //now at the END
        //String stringNum = Integer.toString(numberOfCDs);


        say("All CDs are now on the stack.");

        //move to the correct slot
        while (pos > numberOfCDs){// design step 4
            backUp();
            pos--;
        }

        //now put the CDs
        while(seesSlot()){ //conditions are arbitrary since we know there are slots
            putCD();
            backUp();
            pos--;

            if(pos == 1){
                putCD(); //put the last one
                break;
            }

        }

        say ("The first few slots are now filled.");
    }


    public static void main (String[] args){
        Vic.reset(args);

        ex12_MoveToFront2 busybee = new ex12_MoveToFront2();

        busybee.moveToFront();
    }
}