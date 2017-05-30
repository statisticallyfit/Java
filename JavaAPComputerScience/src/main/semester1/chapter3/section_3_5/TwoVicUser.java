package semester1.chapter3.section_3_5;

import BookClasses.vics.Vic;

/**
 * Created by user1928 on 10/31/14.
 */
public class TwoVicUser extends Vic {

    /*
    Tell whether executor has same number of slots as the parameter
     */

    public boolean hasAsManySlotsAs(Vic par){
        String thisSpot = this.getPosition();

        while(this.seesSlot() && par.seesSlot()){
            this.moveOn();
            par.moveOn();
        }

        boolean valueToReturn = this.seesSlot() && par.seesSlot();
        //changed from !this.seesSlot() && !par.seesSlot();

        while(!thisSpot.equals(this.getPosition())){
            this.backUp();
            par.backUp();
        }

        return valueToReturn;
    }

    public static void main(String[] args){
        Vic.reset(args);

        TwoVicUser user = new TwoVicUser();
        TwoVicUser sally = new TwoVicUser();

        user.hasAsManySlotsAs(sally);
    }

}
