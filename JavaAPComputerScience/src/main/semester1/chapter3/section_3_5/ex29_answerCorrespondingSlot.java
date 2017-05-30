package semester1.chapter3.section_3_5;
import BookClasses.vics.Vic;
/**
 * Created by user1928 on 10/31/14.
 */
public class ex29_answerCorrespondingSlot extends Vic {

    public void moveToCorrespondingSlot (Vic par){

        String thisSpot = this.getPosition();

        while (this.seesSlot() && par.seesSlot()){
            if (par.seesCD() && ! this.seesCD()){
                par.takeCD();
                this.putCD();
            }
            this.moveOn();
            par.moveOn();
        }
        while(!thisSpot.equals (this.getPosition())){
            this.backUp();
            par.backUp();
        }
    }

    public static void main(String[] args){
        Vic.reset(args);

        ex29_answerCorrespondingSlot thisbee = new ex29_answerCorrespondingSlot();
        Vic vicpar = new Vic();

        thisbee.moveToCorrespondingSlot(vicpar);
    }
}
