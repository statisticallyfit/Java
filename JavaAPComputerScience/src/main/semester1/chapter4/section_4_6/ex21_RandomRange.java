package semester1.chapter4.section_4_6;
import java.util.Random;
/**
 * Created by user1928 on 12/12/14.
 */
public class ex21_RandomRange {
    Random random = new Random();


    public int betweenNegativeFiveAndPositiveFive(){

        return random.nextInt(11) - 5;
    }

    public int betweenThirtyAndFifty(){
        return random.nextInt(21) + 30;
    }

    public static void main(String[] args){
        ex21_RandomRange randomCall = new ex21_RandomRange();

        System.out.println(randomCall.betweenNegativeFiveAndPositiveFive());
        System.out.println(randomCall.betweenThirtyAndFifty());
    }
}
