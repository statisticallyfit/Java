package semester1.chapter4.section_4_0_interlude;

import BookClasses.vics.Vic;

/**
 * Created by user1928 on 11/14/14.
 */
public class ex3 extends Vic {
    public int getNumSlots()
    { String spot = getPosition();
        int count = 0;
        while (seesSlot())
        { count++;
            moveOn();
        }
        while ( ! spot.equals (getPosition()))
            backUp();
        return count;
    }

    public int getNumCDs(){

        String spot = getPosition();
        int count = 0;

        while(seesSlot()){
            if(seesCD())
                count++;
            moveOn();
        }

        while ( ! spot.equals (getPosition()))
            backUp();

        return count;
    }

    public static void main(String[] args){
        Vic.reset(args);

        ex3 num = new ex3();

        num.getNumCDs();
    }
}
