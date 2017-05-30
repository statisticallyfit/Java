package semester1.chapter3.section_3_3;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/24/14.
 */
public class Finder extends Vic {

    public void goToFirstEmpty() {

        while (seesSlot()) {
            if (seesCD())
                moveOn();
            else
                break; //if sees no CD
        }
    }

    public void goToFirstFilled() {

        while (seesSlot()) {
            if (!seesCD())
                moveOn();
            else
                break; //if sees no CD
        }
    }

    //seeks position of first empty slot and returns it
    public int seekFirstEmpty() {
        int firstEmpty = 1; //position of first empty slot

        while (seesSlot()) {
            if (seesCD()) {
                moveOn();
                firstEmpty++;
            } else {
                return firstEmpty;
            }
        }
        return firstEmpty;
    }


    //seeks first filled slot and takes its CD
    public int seekFirstFilledAndTakeCD() {
        int firstFilled = 1;

        while (seesSlot()) {
            if (!seesCD()) {
                moveOn();
                firstFilled++;
            } else {
                takeCD();
                return firstFilled;
                //break; //if sees CD
            }
        }
        return firstFilled;

    }


    public void byOnes() {

//        int firstEmpty = 1; //position of first empty
//        int firstFilled = 1; //position of first filled
//
//        try{
//            do{
//                firstEmpty = seekFirstEmpty();
//                //firstFilled
//
//
//            }while(true);
//        }
//        catch (){
//
//        }
//        finally{
//
//        }
    }


    public static void main(String[] args) {
        Vic.reset(args);

        Finder finder = new Finder();

        finder.seekFirstFilledAndTakeCD();
    }
}
