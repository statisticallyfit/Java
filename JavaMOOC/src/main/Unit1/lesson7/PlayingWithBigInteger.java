package main.Unit1.lesson7;

import java.math.BigDecimal;

public class PlayingWithBigInteger {

    public static void main(String[] args) {
        /*BigDecimal c = new BigDecimal(10000);
        BigDecimal digits = new BigDecimal(12345);*/

        double digits = 12345;
        double c = 10000;
        BigDecimal leftoverDec;

        //double cut = digits / c; //digits.divide(c).doubleValue();
        leftoverDec = new BigDecimal(digits / c - (int) (digits / c));
        digits = c * leftoverDec.doubleValue();
        System.out.println(digits);
    }
}
