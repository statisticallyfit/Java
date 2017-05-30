package semester1.chapter4.section_4_0_interlude;

import BookClasses.vics.Vic;

/**
 * Created by user1928 on 11/14/14.
 */
public class ex7 extends Vic {

    public static void main (String[] args){
        Vic.reset(args);

        Vic sequence = new Vic();

        do{
            sequence.takeCD();
            sequence = new Vic();
        }while(sequence.seesSlot());
    }
}
