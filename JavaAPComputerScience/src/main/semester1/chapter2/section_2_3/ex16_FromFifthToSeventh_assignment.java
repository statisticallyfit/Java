package semester1.chapter2.section_2_3;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 9/26/14.
 */

//ASSIGNMENT 2.16
public class ex16_FromFifthToSeventh_assignment {
//Goal: take CD from fifth slot and put it in seventh slot

    public static void main(String[] args){
        Vic.reset(args);

        Vic sam = new Vic();

        sam.moveOn(); //move to second

        if(sam.seesSlot()){
            sam.moveOn(); // at third

            if(sam.seesSlot()){
                sam.moveOn(); // at fourth

                if(sam.seesSlot()){
                    sam.moveOn(); // to fifth

                    if(sam.seesSlot()){ // check that you aren't at END sign
                        if(sam.seesCD()){
                            sam.takeCD(); //at fifth
                            sam.moveOn(); // to sixth

                            if(sam.seesSlot()){
                                sam.moveOn(); // to seventh
                                if(!sam.seesCD()){ //if sam doesn't see a CD
                                    sam.putCD();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


