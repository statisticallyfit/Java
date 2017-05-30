package semester1.chapter3.section_3_5;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/31/14.
 */
public class ex36_ShorterSequence extends Vic {

    public Vic shorterOne(Vic par){


        while(this.seesSlot() && par.seesSlot()){
            this.moveOn();
            par.moveOn();
        }

        if(!this.seesSlot() && par.seesSlot()){
            System.out.println("result is: " + this);
            return this;
        }
        else if(this.seesSlot() && !par.seesSlot()){
            System.out.println("result is: " + par);
            return par;
        }

        return null; // since both have same slot number
    }

    public static void main(String[] args){
        Vic.reset(args);

        ex36_ShorterSequence shorty = new ex36_ShorterSequence();
        Vic vicPar = new Vic();

        shorty.shorterOne(vicPar);
    }
}
