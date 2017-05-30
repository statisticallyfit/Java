package semester1.chapter4.section_4_7;

import semester1.chapter3.section_3_5.Looper;

/**
 * Created by user1928 on 12/12/14.
 */
public class BigVic extends Looper {

    private int itsNumFilled; //count this's filled slots
    private int itsNumEmpty; //count this's empty slots

    /*
     * Assignment 4.34: write BigVic constructor
     */
    public BigVic(){
        super();
    }

    public int getItsNumFilled(){
        return itsNumFilled;
    }

    public int getItsNumEmpty(){
        return itsNumEmpty;
    }

    public void putCD(){
        if(!seesCD() && stackHasCD()){
            itsNumFilled++;
            itsNumEmpty--;
            super.putCD();
        }
    }

    public void takeCD(){
        if(seesCD()){
            itsNumFilled--;
            itsNumEmpty++;
            super.takeCD();
            //calls the superclass takeCD() (Vic's, not Looper's
            // since Looper doesn't override takeCD().
        }
    }
}

/*
 * Polymorphism: execution of polymorphic method calls.
 *
 * polymorphic: having more than one form (putCD() statement in the fillSlots() method
 * is polymorphic
 *
 *
 * EXAMPLE OF POLYMORPHISM: Using Looper object to call fillSlots() (which has putCD() in it)
 * does not change the itsNumFilled or itsNumEmpty.
 *
 * Only using BigVic object to call fillSlots() will change
 * itsNumFilled and itsNumEmpty
 *
 *
 * EXAMPLE 2: the command shouldContinue() in the BasicGame class is polymorphic
 * since it has different effects depending on class of object that is executing it.
 *
 */