package semester1.chapter2.section_2_5;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */
public class ex22_MoveToNext extends Vic{

    /*public void shiftForward(){

        if(seesSlot()){
            moveOn(); // to second slot
            if(seesSlot()){
                if(seesCD()){
                    takeCD(); // take CD in second slot
                    backUp(); // to first
                    if(!seesCD()){
                        putCD(); //put it in first
                    }
                    else{
                        Vic.say("Can't overlay CDs");
                    }
                }
                else{
                    Vic.say("Don't see a CD to take");
                }
            }
        }
    }
    */

    public void shiftForward(){

        if(!seesCD()){
            moveOn(); // to second slot
            if(seesSlot() && seesCD()){
                takeCD();
                backUp(); //to first slot
                putCD();
                moveOn(); // must end up at next slot at program's end
            }
            else{
                Vic.say("Sorry, either no slot or no CD found");
            }

        }
        else{
            Vic.say("Can't complete job. There's a CD in first slot");
            moveOn(); // we must end up at next slot
        }
    }

    public static void main(String[] args){
        //set args to: 01 or 00, 11, or 10

        Vic.reset(args);

        ex22_MoveToNext sam = new ex22_MoveToNext();

        sam.shiftForward();

    }
}
