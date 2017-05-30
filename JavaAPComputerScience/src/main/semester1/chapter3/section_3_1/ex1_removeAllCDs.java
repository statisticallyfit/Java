package semester1.chapter3.section_3_1;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/24/14.
 */
public class ex1_removeAllCDs extends  Vic {

    public void removeAllCDs(){

        while(seesSlot()){
//            if(seesCD())
//                takeCD();
//            moveOn();
            takeCD();
            moveOn();
        }
    }

    public static void main(String[] args){
        Vic.reset(args);

        ex1_removeAllCDs busybee = new ex1_removeAllCDs();

        busybee.removeAllCDs();
    }
}
