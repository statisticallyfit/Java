package semester1.chapter2.section_2_8;

import BookClasses.vics.Vic;

/**
 * Created by user1928 on 12/23/14.
 */
public class TestElseTrap extends Vic {

    public void sayWhenSlotIsEmpty(){
        if(seesSlot()){
            if(seesCD()){
                takeCD();
            }
            else{
                say("No CD!");
            }
        }
    }

    public void sayWhenNoSlot(){
        if(seesSlot()){
            if(seesCD()){
                takeCD();
            }
        }
        else{
            say("No slot!");
        }
    }

    public static void main(String[] args) {
        Vic.reset(args);

        TestElseTrap tester = new TestElseTrap();

        //tester.sayWhenSlotIsEmpty();
        tester.sayWhenNoSlot();
    }
}
