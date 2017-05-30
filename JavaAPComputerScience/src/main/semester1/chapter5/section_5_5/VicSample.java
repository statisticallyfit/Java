package semester1.chapter5.section_5_5;

import javax.swing.JOptionPane;
import java.util.Random;


public class VicSample extends Object {

    private static final String NONE = "0";
    private String itsSequence = "";
    private int itsPos = 1;
    private /*final*/ int itsID = 0;  // why final?... mustn't it change for each Vic object?
    private static String theStack = "";
    private static String theStack2 = "";
    private static String[] theTableau = {"", "", ""};
    private static final Random randy = new Random();
    private static final String LETTERS = " abcdefghijkl";
    private static int theNumVics = 0;


    //constructor
    public VicSample(){
        super();

        if(theNumVics < theTableau.length){ //this is only false if the user declares more
        // objects than gives sequences in cmd line
            itsSequence = theTableau[theNumVics];

            if(itsSequence.length() == 0){
                for(int k = 3 + randy.nextInt(6); k >= 1; k--){

                    if(randy.nextInt(2) == 0){ //half the time, do nothing
                        itsSequence = NONE + itsSequence;

                    }else{ //the other half of the time, assign letters to sequence to stand for cds
                        itsSequence = LETTERS.substring(k, k+1) + itsSequence;
                    }
                }
            }
            itsSequence = " " + itsSequence; //make a space in front of sequence code so
            // counting itsPos becomes 1-based
        }
        theNumVics++; //one vic has been created
        itsID = theNumVics; // its id is the same as the order it was created in
        trace("constructed ");
    }




    public String getPosition(){
        return itsPos + "," + itsID;
    }


    public static void say (String message){
        System.out.println ("SAYS: " + message);
    }


    private void trace (String action){
        System.out.println("Stack has " + theStack + "   | Vic# " + itsID + ": " + action
                + itsPos + "; sequence= " + itsSequence);
    }


    public static void reset(String[] args){
        if(theNumVics == 0 && args.length > 0){ /** NOTE: arrays have attribute length and strings have method length() */
            theTableau = args;
        }
    }




    public static boolean stackHasCD(){
        return theStack.length() > 0;
    }

    public void backUp(){
        if (itsPos == 1){
            explainError();
        }
        itsPos--;
        trace("backUp to slot ");
    }

    public void moveOn() {
        if(!seesSlot()){
            explainError();
        }
        itsPos++;
        trace("moveOn to slot ");
    }

    public boolean seesSlot(){
        return itsPos < itsSequence.length();
    }

    public boolean seesCD(){
        if(!seesSlot()){
           explainError();
        }
        return !getSubstring(itsSequence, itsPos).equals(NONE);
    }

    public void takeCD(){
        if(seesCD()){
            theStack += getSubstring(itsSequence, itsPos); //move CD to the stack
            itsSequence = itsSequence.substring(0, itsPos) + NONE +
                    itsSequence.substring(itsPos + 1, itsSequence.length());
        }
        trace("takeCD at slot ");
    }

    public void putCD(){
        if(!seesCD() && stackHasCD()){
            int atEnd = theStack.length() - 1;
            itsSequence = itsSequence.substring(0, itsPos)
                    + theStack.substring(0, 1) //was theStack.substring(atEnd, atEnd + 1)
                    + itsSequence.substring(itsPos + 1, itsSequence.length());
            theStack = theStack.substring(0, atEnd);
        }
        trace("putCD at slot ");
    }

    /**
     * Assignment 5.15: explain errors with JOptionPane and then terminate with System.exit(0)
     */
    public void explainError(){
        JOptionPane.showMessageDialog(null, "No slot seen: so, cannot see CD, or move, or backup!");
        System.exit(0);
    }

    /**
     * Exercise 5.14
     */
    private static String getSubstring(String sequence, int position){
        return sequence.substring(position, position + 1);
    }
}

class VicRunner{
    public static void main(String[] args){

        //Exercise 5.16 - if reset() is called twice, the new set of strings replaces the old set - no actual value change
        VicSample.reset(args);
        VicSample.reset(args);

        VicSample samp = new VicSample();
        VicSample obj1 = new VicSample();
        VicSample obj2 = new VicSample();
        VicSample obj3 = new VicSample();
        VicSample obj4 = new VicSample();
        VicSample obj5 = new VicSample();
        VicSample obj6 = new VicSample();

        samp.moveOn();
        samp.takeCD();
        samp.moveOn();
        samp.takeCD();
        samp.moveOn();
        samp.takeCD();
        samp.moveOn();
        samp.takeCD();
        samp.moveOn();
        samp.putCD();
    }
}
