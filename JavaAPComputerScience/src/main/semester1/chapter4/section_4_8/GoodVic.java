package semester1.chapter4.section_4_8;

import BookClasses.vics.Vic;
/**
 * Created by user1928 on 12/23/14.
 */


/**
 * QUESTION: why initialize in the constructor versus in declaration? Later on, author says to
 * initialize in declaration to make program more readable!!
 */
public class GoodVic extends Vic {

    private boolean itsFirstWasEmpty = seesSlot() && !seesCD();

    public GoodVic(){
        super();
        //itsFirstWasEmpty = seesSlot() && !seesCD();
    }

    public boolean firstWasEmpty(){
        return itsFirstWasEmpty;
    }

    public static void main(String[] args) {
        Vic.reset(args);

        GoodVic goodVic = new GoodVic();

        goodVic.firstWasEmpty();
    }
}
