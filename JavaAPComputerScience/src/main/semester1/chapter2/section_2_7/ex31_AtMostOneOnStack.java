package semester1.chapter2.section_2_7;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/17/14.
 */
public class ex31_AtMostOneOnStack extends Vic {

    public boolean atMostOneOnStack(){

        boolean result;

        if(!stackHasCD()){
            result = false; //case 1: no CD at all
        }else{ //case 2: there is at least 1 CD
            putCD(); //get rid of it
            result = !stackHasCD(); //if there's another CD, result is false so method is false
            takeCD(); //restore state
        }
        return result;
    }



    public static void main(String[] args){

        Vic.reset(args);

        ex31_AtMostOneOnStack boolly = new ex31_AtMostOneOnStack();


        boolly.atMostOneOnStack();
    }
}
