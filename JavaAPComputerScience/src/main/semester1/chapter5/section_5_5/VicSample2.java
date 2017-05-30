package semester1.chapter5.section_5_5;

import java.util.Random;

/**
 * Created by user1928 on 12/23/14.
 */


public class VicSample2{

    private final static String NONE = "0";
    private final static Random randy = new Random();
    private final static String LETTERS = " abcdefghijkl";

    private static String theStack = "";
    private static String[] theTableau = {"", "", ""};
    private static int theNumVics = 0;

    private String itsSequence = "";
    private int itsPos = 1;
    private int itsID = 0;


    public VicSample2(){
        super();

        if(theNumVics < theTableau.length){

            itsSequence = theTableau[theNumVics];

            if(itsSequence.length() == 0){

                for(int k = 3 + randy.nextInt(6); k>= 1; k--){
                    if(randy.nextInt(2) == 0){
                        itsSequence = NONE + itsSequence;
                    }else{
                        itsSequence = LETTERS.substring(k, k+1);
                    }
                }
            }
            itsSequence = " " + itsSequence;
        }
        theNumVics++;
        itsID = theNumVics;
        trace("constructed at position ");
    }

    public void trace(String action){
        System.out.println("The stack has " + theStack + " | Vic# " + itsID + ": " + action + itsPos + " | sequence = " + itsSequence);
    }


    public static void reset(String[] args){
        if(theNumVics == 0 && args.length > 0){
            theTableau = args;
        }
    }

    public boolean seesSlot(){
        return itsPos < itsSequence.length();
    }

    public boolean seesCD(){
        if(!seesSlot())
            System.exit(0);
        return !itsSequence.substring(itsPos, itsPos + 1).equals(NONE);
    }

    public static boolean stackHasCD(){
        return theStack.length() > 0;
    }

    public void putCD(){
        if(!seesCD() && stackHasCD()){
            itsSequence = itsSequence.substring(0, itsPos) + theStack.substring(0, 1) +
                    itsSequence.substring(itsPos + 1, itsSequence.length());
            theStack = theStack.substring(0, itsSequence.length() - 1);
        }
    }

    public void takeCD(){
        if(seesCD()){
            itsSequence = itsSequence.substring(0, itsPos) + NONE +
                    itsSequence.substring(itsPos + 1, itsSequence.length());
            theStack += "1";
        }
    }

    //get pos
    //say
    //move on, back up

}