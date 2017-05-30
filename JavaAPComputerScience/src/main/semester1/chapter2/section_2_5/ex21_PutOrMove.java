package semester1.chapter2.section_2_5;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */
public class ex21_PutOrMove {

    public static void main(String[] args){
        //set args to: 000 or 100
        Vic.reset(args);

        Vic sam = new Vic();

        if(sam.seesSlot()){
            if(!sam.seesCD() && Vic.stackHasCD()){
                sam.putCD(); //if there's no CD and stack has CD, put CD in current slot
            }
            else{
                sam.moveOn(); //else move on to next slot
            }
        }
    }
}
