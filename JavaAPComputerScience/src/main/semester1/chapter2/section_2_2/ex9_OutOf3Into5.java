package semester1.chapter2.section_2_2;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */
public class ex9_OutOf3Into5 {

    public static void main(String[]args){
        //set args to 111101

        Vic.reset(args);

        SmartVic smarty = new SmartVic();

        smarty.moveOn(); //move to second slot
        smarty.moveTake(); //move to third slot and take CD
        smarty.moveOn(); //move to fourth slot
        smarty.movePut(); //move to fifth and put CD
    }
}
