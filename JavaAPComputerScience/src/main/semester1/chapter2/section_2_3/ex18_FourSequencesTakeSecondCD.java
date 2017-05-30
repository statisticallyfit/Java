package semester1.chapter2.section_2_3;
import semester1.chapter2.section_2_2.SmartVic;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */

// ASSIGNMENT 18
public class ex18_FourSequencesTakeSecondCD {
//Goal: Have four sequences. Take second CD from each
    public static void main(String[] args){
        // set args to 111 111 111 111

        Vic.reset(args);

        SmartVic one = new SmartVic();
        SmartVic two = new SmartVic();
        SmartVic three = new SmartVic();
        SmartVic four = new SmartVic();

        if(one.seesSlot()){
            one.moveOn(); // to second space
            if(one.seesSlot()){
                if(one.seesCD()){
                    one.takeCD(); // take second CD if it's there
                }
            }
        }

        if(two.seesSlot()){
            two.moveOn(); // to second space
            if(two.seesSlot()){
                if(two.seesCD()){
                    two.takeCD(); // take second CD if it's there
                }
            }
        }

        if(three.seesSlot()){
            three.moveOn(); // to second space
            if(three.seesSlot()){
                if(three.seesCD()){
                    three.takeCD(); // take second CD if it's there
                }
            }
        }

        if(four.seesSlot()){
            four.moveOn(); // to second space
            if(four.seesSlot()){
                if(four.seesCD()){
                    four.takeCD(); // take second CD if it's there
                }
            }
        }
    }
}
