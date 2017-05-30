package semester1.chapter3.section_3_2;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/24/14.
 */
public class ex6_GoToLastEmptySlot extends Vic {

    public void goToLastEmptySlot(){
        String spot = getPosition();

        while(seesSlot()){
            if(!seesCD())
                spot = getPosition(); //mark spot of empty slot
            moveOn();
        }
        while(!spot.equals(getPosition()))
            backUp();
    }

    public static void main(String[] args){
        Vic.reset(args);

        ex6_GoToLastEmptySlot busybee = new ex6_GoToLastEmptySlot();

        busybee.goToLastEmptySlot();
    }
}
