package semester1.chapter3.section_3_3;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/24/14.
 */

public class MoveToFront extends Vic {
    /** Move all the CDs in the first sequence of slots up to the
     *  front of the sequence. Precondition: stack is empty. */


    public void backUp(String spot){
        while(!spot.equals(getPosition())){
            super.backUp();
        }
    }

    public void moveToFront(){
        String originalSpot = getPosition();

        while(seesSlot()){
            if(seesCD()){
                takeCD();
            }
            moveOn();
        }
        //all cds are now in stack
        backUp(originalSpot);

        while(seesSlot() && stackHasCD()){//arbitrary since we know there are slots
            putCD();
            moveOn();
        }
        backUp(originalSpot);
        say("The first few slots are now filled");
    }


    public static void main(String[] args) {
        Vic.reset(args);
        MoveToFront mover = new MoveToFront();
        mover.moveToFront();
    }





    /*public static void main (String[ ] args){
        Vic chun;                                  // design step 1
        chun = new Vic();
        String spot;                               // design step 2
        spot = chun.getPosition();

        while (chun.seesSlot()) {                   // design step 3
            chun.takeCD();
            chun.moveOn();
        }
        Vic.say ("All CDs are now on the stack.");

        while (! spot.equals (chun.getPosition()))// design step 4
            chun.backUp();

        while (chun.seesSlot() && Vic.stackHasCD()){// design step 5
            chun.putCD();
            chun.moveOn();
        }
        Vic.say ("The first few slots are now filled.");
    }*/
}