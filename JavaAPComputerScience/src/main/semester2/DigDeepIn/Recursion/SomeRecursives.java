package semester2.DigDeepIn.Recursion;

import BookClasses.vics.Vic;


public class SomeRecursives extends Vic {


    public void fillSlots(int numToFill){
        if(!seesCD() && stackHasCD())
            putCD();
        moveOn();
        if(seesSlot())
            fillSlots(numToFill - 1);
        backUp();
        System.out.println("\nexisted from call with num to fill = " + numToFill);
    }

    /*public void fillSlots(){
        String spot = getPosition();

        while(seesSlot()){
            if(!seesCD() && stackHasCD())
                putCD();
            moveOn();
        }
        backUpTo(spot);
    }*/

    public void fillSlots(){
        if(!seesCD() && stackHasCD()){
            putCD();
        }
        moveOn();
        if(seesSlot()){
            fillSlots();
            System.out.println("hi there");
        }
        backUp();
    }

    public int getNumSlots(){
        if(!seesSlot()){
            return 0;
        }
        moveOn();
        int num = getNumSlots();
        System.out.println("see me rabbi");
        backUp(); //debt
        System.out.println("Existed from call with " + num);
        return 1 + num;
    }

    /*
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
     */


    public boolean seesAllFilled(){
        if(!seesSlot()){ //there are always some slots, so this can only be true if at the END
            //if you got all the way to the end with FILLED SLOTS, then all are filled
            return true;
        } else if(!seesCD()){
            return false;
        }
        moveOn();
        boolean areFilled = seesAllFilled();
        backUp();

        return areFilled;
    }

    public static void main(String[] args){
        Vic.reset(args);
        new SomeRecursives().seesAllFilled();
    }
}
