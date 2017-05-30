package semester1.chapter4.section_4_7;

import semester1.chapter4.section_4_4.Person;
import java.util.Random;

/**
 * Created by user1928 on 12/12/14.
 */

//Exercise 4.30
public class Liar extends Person {

    public Liar(String first, String last){
        super(first, last);
    }

    public String getFirstName(){
        Random rand = new Random();
        if(rand.nextInt(2) == 1){ //half the time it says his name is Darryl
            return "Darryl";
        }else{
            return super.getFirstName();
        }
    }

    public static void main(String[] args){
        Liar liar = new Liar("Evanlyn", "Wheeler");

        liar.getFirstName();
    }
}
