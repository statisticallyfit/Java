package semester1.chapter2.section_2_2;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */
public class SmartVic extends Vic {

    //***
    public void moveTake(){
        moveOn();
        takeCD();
    }

    //***
    public void backPut() {
        backUp();
        putCD();
    }


    // *** ASSIGNMENT 2.10
    public void backTake() {
        backUp();
        takeCD();
    }


    public void movePut() {
        moveOn();
        putCD();
    }



    // exercise 2.16
    public void swapTwo() {

        if(seesCD()){ // at least one slot
            takeCD();

            //Next move to next slot and take cd
            moveOn();
            if(seesSlot()){
                if(seesCD()){
                    takeCD();
                    //Next move back and put it
                    backPut();
                    //Next move up one and put first CD there
                    movePut();
                }
            }
        }
    }
}
