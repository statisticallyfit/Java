package semester1.chapter2.section_2_6;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */
public class ex26_CD extends Vic{

//    public boolean canPutCD(){
//        if(seesCD()){
//            say("Occupied slot");
//            return false;
//        }
//        else{
//            say("Free slot available");
//            return true;
//        }
//    }

    public boolean canPutCD(){
        if(seesSlot() && !seesCD() && stackHasCD()){
            say("Can put CD");
            return true;
        }
        else{
            say("Cannot put CD");
            return false;
        }
    }

    public static void main(String[] args){
        Vic.reset(args);

        ex26_CD sue = new ex26_CD();

        sue.canPutCD();
    }
}
