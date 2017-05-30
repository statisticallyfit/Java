package semester1.chapter4.section_4_0_interlude;

/**
 * Created by user1928 on 11/14/14.
 */
public class PowerExample {

    public int powerGreaterThan(int given){
        int power;
        for(power = 1; given >= 1; power = 2 * power){
            given /= 2;
        }
        return power;
    }

    public static void main(String[] args){
        PowerExample ex = new PowerExample();

        ex.powerGreaterThan(20);
    }
}
