package semester1.chapter3.section_3_5;

import BookClasses.vics.Vic;

/**
 * Created by user1928 on 10/31/14.
 */

/*
    Process sequence of slots until the end, sometimes leaving executor in original state
     */

public class Looper extends Vic {

    /*
    Back up to position. Precondition: someSpot records slot at or before current slot
     */
    private void backUpTo(String someSpot){

        while(!someSpot.equals(getPosition())){
            backUp();
        }
    }

    /*
    Fill current all further slots from stack until end is reached
     */
    public void fillSlots(){
        String spot = getPosition();

        while(seesSlot()){
            if(!seesCD()){
                putCD();
            }
            moveOn();
        }
        backUpTo(spot);
    }


    /*
    Move all CDs in slots to stack
     */
    public void clearSlotsToStack(){
        String spot = getPosition();

        while(seesSlot()){
            if(seesCD()){
                takeCD();
            }
            moveOn();
        }
        backUpTo(spot);
    }


    /*
    Fill in odd slots only
     */
    public void fillOddSlots(){
        String spot = this.getPosition();

        while(this.seesSlot() && stackHasCD()){
            if(!this.seesCD()){
                this.putCD();
            }
            this.moveOn();
            if(this.seesSlot()){
                this.moveOn();
            }
        }
        this.backUpTo(spot);
    }


    /*
    Fill even slots
     */
    public void fillEvenSlots(){

        if(this.seesSlot()){
            this.moveOn(); //to second slot
            this.fillOddSlots(); //will back up to original spot
        }
    }


    /*
    Tells whether all odd slots are filled. Returns false if not all odd filled.
     */
    public boolean seesOddsFilled(){
        String originalSpot = getPosition();

        while(seesSlot()){
            if(!seesCD()){
                backUpTo(originalSpot);
                return false;
            }
            moveOn();
            if(seesSlot()){
                moveOn();
            }
        }
        backUpTo(originalSpot);

        return true; //executed when while statement is false == happens at END.
        //means all odds slots so far were filled.
    }

    /*
    Tells whether all evens are filled
     */
    public boolean seesEvenFilled(){

        boolean returnValue = false;

        if(seesSlot()){
            moveOn();// to first even

            returnValue = seesOddsFilled();
            backUp(); //to first slot from second
        }
        return returnValue;
    }

    /*
    Tell whether every slot in sequence has a CD. Return false if 1 or more doesn't.
    Method is vacuous: returns true if starting at END, assuming all slots before are filled.
     */
    public boolean seesAllFilled(){
        String spot = getPosition();
        boolean returnValue;

        while(seesSlot() && seesCD()){
            moveOn();
        }
        returnValue = !seesSlot();
        backUpTo(spot);

        return returnValue;
    }


    /** Return the position for the last empty spot in
     *  the sequence, or the current spot if no empty spot. */

    public String lastEmptySlot()
    {
        String spot = this.getPosition();
        String lastEmpty = spot;  // in case no later slot is empty

        while (this.seesSlot())
        {
            if ( ! this.seesCD())
                lastEmpty = this.getPosition();
            this.moveOn();
        }
        this.backUpTo (spot);
        return lastEmpty;
    }


    //EXERCISE 3.36: Return Vic with fewer slots, either executor or parameter.
    //restore state
    //Precondition: sequences do not have equal slot numbers

    public Vic shorterOne(Vic par){

        Vic vicWithFewestSlots = new Vic();

        while(this.seesSlot() && par.seesSlot()){
            this.moveOn();
            par.moveOn();
        }

        //If either this or par does not see slot
        if(this.seesSlot() && !par.seesSlot()){
            vicWithFewestSlots = par;
        }
        else if(!this.seesSlot() && par.seesSlot()){
            vicWithFewestSlots = this;
        }
        else{
            vicWithFewestSlots = null;
        }

        return vicWithFewestSlots;
    }






    //-------------------------------------------------------------------------------------------

    /*
    ASSIGNMENT 3.23:
    Removes CD from first slot and shifts all cds up by one slot.
    */


    public void bringBack(){

        int numberOfCDs = 0;
        int pos = 1;

        while (seesSlot()) {
            if(seesCD()){
                takeCD();
                numberOfCDs++;
            }
            moveOn();
            pos++;
        }
        //now at the END

        //move to the correct slot
        while (pos > numberOfCDs){
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
    }


    //-------------------------------------------------------------------------------------------
    /*
    ASSIGNMENT 3.24:

    If there is a not operator (!) in both places (before the seesCD() and in the statement
    returnValue = !seesSlot(), then a good name for this method is: seesAllEmpty().
    The executor keeps moving on if the executor sees slots and no CDs. Therefore, if the while statement is
    false because the executor saw a CD, the statement !seesSlot() = !true = false, so return value = false.
    Therefore, if the method returns false due to a filled slot, it must be named seesAllEmpty().
    This would return true if all slots were empty.

    If there is no not operator (!) in both places, the method name should be: hasSomeEmptySlot().
    The executor keeps moving if if sees slots and CDs. Therefore, if the while condition is false
    because the executor saw no CD, the statement returnValue = seesSlot() = true, since only the condition
    seesCD() returned false, while seesSlot() was true. Therefore, if the method returns true
    due to an empty slot, it must be called hasSomeEmptySlot(). This would return false if all
    slots were filled.
     */

    //-------------------------------------------------------------------------------------------

    /*
    ASSIGMMENT 3.25:
    Move the CD in each slot to the next slot if next slot is empty; if not empty, move to stack. Continue.
     */
    public void overOrOut(){
        String originalSpot = getPosition();

        while(seesSlot()){
            if(seesCD())
                takeCD(); //move to stack

            //stackhasCD condition is for first execution only: the executor has no CD in hand
            //to put it if it has no CDs in the stack since it did not pick up CDs from the slots.
            else if(!seesCD() && stackHasCD())
                putCD(); //this is next slot
            moveOn();
        }

        //restore position
        while(!originalSpot.equals(getPosition()))
            backUp();

    }

    //-------------------------------------------------------------------------------------
    /******* NOTE
     I did the assignment with your help Mrs. Creasy; below I provided explanations
     of how the method and boolean variable work to show I understand the program.
     */

    // ASSIGNMENT 3.30:

    // let executor tell whether it has more than twice
    // as many slots as vic parameter. Do without numeric variables
    // Precondition: executor must have even numbered slots
    //Extra credit: remove precondition .

    public boolean hasMoreThanDouble(Vic par){
        String thisSpot = par.getPosition();            // design step 1

        // Executor (this) gets incrementally more ahead with each  run through
        //the while statements. This way, it gets ahead by a distance of
        //double the par's slots + 1.
        while (this.seesSlot() && par.seesSlot())       // design step 2
        {
            this.moveOn();
            par.moveOn();
            this.moveOn();
        }

        //Boolean valueToReturn accurately answers the HasMoreThanDouble() question
        //since the executor is placed on the position = double(par slots) + 1
        //If it sees the slot at +1, method returns true. If not, method returns false.

        boolean valueToReturn = this.seesSlot();        // design step 3

        //Back up the par and executor. Executor will not fully return to original first slot
        //since it got ahead of the par and they back up the same number of times.
        while (! thisSpot.equals (par.getPosition()))   // design step 4
        {
            this.backUp();
            par.backUp();
        }

        return valueToReturn;                 // design step 5
    }
    //-------------------------------------------------------------------------------------------

    /*
    ASSIGNMENT 3.32: method tells whether the sequences match in terms of CD presence
     */
    public boolean matches(Vic par){

        //boolean valueToReturn = false;

        while(this.seesSlot() && par.seesSlot()){
            if((this.seesCD() && par.seesCD()) || ((!this.seesCD() && !par.seesCD()))){
                this.moveOn();
                par.moveOn();
            }else{
                return false;
            }
        }
        return true;
    }
    //-------------------------------------------------------------------------------------------


    /*
    ASSIGNMENT 3.34
    Tell whether executor has same number of CDs as vic parameter
     */
    public boolean sameNumber(Vic par){
        boolean flag = true; //initialize

        while(this.seesSlot() && par.seesSlot()){
            if(this.seesCD() && par.seesCD()){
                flag = true;
            }
            else if(!this.seesCD() && !par.seesCD()){
                flag = true;
            }
            else
                return false;
            this.moveOn();
            par.moveOn();
        }

        //FOR SEQUENCES WITH DIFFERENT SIZED SLOTS
        if(this.seesSlot() && !par.seesSlot()){
            par.backUp();
            if(par.seesCD() && !this.seesCD()){
                return true;
            }
            else{
                return false;
            }
        }
        else if(!this.seesSlot() && par.seesSlot()){
            this.backUp();
            if(!par.seesCD() && this.seesCD()){
                return true;
            }
            else{
                return false;
            }
        }
        return flag;
    }

    //-------------------------------------------------------------------------------------------
    /*
    ASSIGNMENT 3.37:
    return position of second last empty slot
    if there are less than 2 slots, return initial position instead
     */
    public String lastEmptySlotAssignment37(){

        String originalSpot = getPosition();
        String posOfSecondLastEmpty = null;
        int numberOfEmptySlots = 0;

        while(this.seesSlot()){
            if(!this.seesCD()){
                numberOfEmptySlots++;
            }
            this.moveOn();
        }
        this.backUp();


        //if less than two empty slots, return originalSpot
        if(numberOfEmptySlots < 2){
            return originalSpot;
        }


        if(!this.seesCD()){
            this.backUp();
            if(!this.seesCD()){
                //if CD is seen, that means it is the second last, so get its position
                posOfSecondLastEmpty = this.getPosition();
            }
            else if(this.seesCD()){
                while(this.seesCD()){
                    this.backUp();
                }
                //when this does not see CD, loop is broken at second last empty slot, so get its position
                posOfSecondLastEmpty = this.getPosition();
            }
        }
        else if(this.seesCD()){
            while(this.seesCD()){
                this.backUp();
            }
            this.backUp();
            if(!this.seesCD()){
                posOfSecondLastEmpty = this.getPosition();
            }
            else if(this.seesCD()){
                while(this.seesCD()){
                    this.backUp();
                }
                posOfSecondLastEmpty = this.getPosition();
            }
        }

        // lastly, back up
        this.backUpTo(originalSpot);

        return posOfSecondLastEmpty;
    }

    //-------------------------------------------------------------------------------------------
    /*
    ASSIGNMENT 3.38:
    Return position of second last empty slot as executor is backing up
     */
    public String lastEmptySlotAssignment38(){
        String originalSpot = getPosition();
        String posOfLastEmpty = null;

        while(this.seesSlot()){
            this.moveOn();
        }
        backUp();

        if(!this.seesCD()){
            posOfLastEmpty = getPosition();
        }
        else if(this.seesCD()){
            while(this.seesCD()){
                this.backUp();
            }
            posOfLastEmpty = getPosition();
        }

        // lastly, back up to original spot
        this.backUpTo(originalSpot);

        return posOfLastEmpty;
    }
}
