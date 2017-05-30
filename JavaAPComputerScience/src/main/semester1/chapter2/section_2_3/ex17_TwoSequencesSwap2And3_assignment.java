package semester1.chapter2.section_2_3;
import semester1.chapter2.section_2_2.SmartVic;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */
//ASSIGNMENT 2.17
public class ex17_TwoSequencesSwap2And3_assignment extends SmartVic {
//Goal: have two sequences. In first, move CD3 to CD2 space
// In second, move CD2 into CD3 space
    public static void main(String[] args){
        // set args to 1011 1101
        Vic.reset(args);

        SmartVic smartyOne = new SmartVic();
        SmartVic smartyTwo = new SmartVic();


        // Use smartyOne object to swap from slot3 to slot2
        if(smartyOne.seesSlot()){ // if not standing on END
            smartyOne.moveOn(); // at second slot

            if(smartyOne.seesSlot()){ // if second slot exists
                if(!smartyOne.seesCD()){ // is slot2 empty? It needs to be so we can put the slot3 CD in it
                    smartyOne.moveOn(); // move to third slot

                    if(smartyOne.seesSlot()){
                        if(smartyOne.seesCD()){ // if slot and CD exist at position 3
                            smartyOne.takeCD();

                            // We checked earlier that slot two is empty
                            // Move back and put slot3's CD in empty slot 2
                            smartyOne.backPut(); //move back and put it in slot two
                        }
                    }
                }
            }
        }


        // Use smartyTwo to swap from slot2 to slot3

        if(smartyTwo.seesSlot()){
            smartyTwo.moveOn();//move to slot 2

            if(smartyTwo.seesSlot()){
                if(smartyTwo.seesCD()){
                    smartyTwo.takeCD(); // take second CD
                    smartyTwo.moveOn(); // move to third position

                    if(smartyTwo.seesSlot()){ //if slot3 exists
                        if(!smartyTwo.seesCD()){// if slot3 is empty
                            smartyTwo.putCD();
                        }
                    }
                }
            }
        }
    }
}
