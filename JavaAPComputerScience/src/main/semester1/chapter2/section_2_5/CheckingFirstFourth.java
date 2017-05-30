package semester1.chapter2.section_2_5;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/3/14.
 */

//ASSIGNMENT: 2.23
public class CheckingFirstFourth extends Vic{
    /*
    Goal: only work with second sequence
    First: take CD from slot one and slot four
    THEN: if either one was not empty, put a CD in the second slot
    If either one was empty, do not put CD in second slot
    * (messages are sent to update user about what has happened)
     */

    public void backUpAndCheckSlotTwo(){
        backUp(); // to third
        backUp(); //to second
        //If slot 2 is empty, put it, else showUpdatedStatus
        if(!seesCD()){
            putCD();
        }else{
            Vic.say("Cannot overlay CDs");
        }
    }

    public void backUpAndGiveOverlayMessage(){
        backUp(); // to third
        backUp(); //to second
        //If slot 2 is empty, put it, else showUpdatedStatus
        if(!seesCD()){
            putCD();
        }else{
            Vic.say("Cannot overlay CDs");
        }
    }




    public static void main(String[] args){
        //set args:
        //try: 0000 1001 --- yes 1, yes 4
        //try: 0000 0001 --- no 1, yes 4
        //try: 0000 1000 --- yes 1, no 4
        //try: 0000 0000 --- no 1, no 4

        Vic.reset(args);

        CheckingFirstFourth sam = new CheckingFirstFourth();
        CheckingFirstFourth sue = new CheckingFirstFourth(); //create second object so it's possible to work with second sequence


        //If CD in slot one, take it. Else move on to fourth

        if(sue.seesCD()){
            sue.takeCD(); // in first slot
            sue.moveOn();// to second
            if(sue.seesSlot()){
                sue.moveOn(); // to third
                if(sue.seesSlot()){
                    sue.moveOn(); // to fourth

                    //If CD in fourth, take it and put in second, else, don't take and put in second
                    if(sue.seesSlot() && sue.seesCD()){
                        sue.takeCD(); //take fourth CD
                        sue.backUpAndCheckSlotTwo();
                    }

                    else{// if slot 4 has no CD
                        sue.backUpAndGiveOverlayMessage();
                    }
                }
            }
        }
        else{//if no CD in first slot
            sue.moveOn(); //to second

            if(sue.seesSlot()){
                sue.moveOn();// to third

                if(sue.seesSlot()){
                    sue.moveOn(); // to fourth

                    //If CD in fourth, take it and put in second, else, don't take and put in second
                    if(sue.seesSlot() && sue.seesCD()){
                        sue.takeCD(); //take fourth CD
                        sue.backUpAndGiveOverlayMessage();
                    }
                    else{// both slot 1 and slot 4 have no CDs - do not put any CD in slot 2
                        Vic.say("Both first and fourth slots had no CDs");
                    }
                }
            }
        }
    }
}
