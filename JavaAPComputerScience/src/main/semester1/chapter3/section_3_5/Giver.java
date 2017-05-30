package semester1.chapter3.section_3_5;
import BookClasses.vics.Vic;

/**
 * Created by user1928 on 10/31/14.
 */
/*
Executor gives all CSs to Looper parameter
which distribues them as much as possible.
 */
public class Giver extends Looper {

    public void giveEverythingTo(Looper target){
        this.clearSlotsToStack();
        target.fillSlots();
    }

    public static void main(String[] args){

        Vic.reset(args);

        Giver giver = new Giver();
        Looper targetGuy = new Looper();

        giver.giveEverythingTo(targetGuy);
    }
}
