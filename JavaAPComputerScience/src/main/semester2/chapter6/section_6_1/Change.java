package semester2.chapter6.section_6_1;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Scanner;



/*Assignment 6.8 */
public class Change {

    public static final int HUNDRED = 100;
    public static final int QUARTER = 25;
    public static final int DIME = 10;
    public static final int NICKEL = 5;
    private double itsTotalCents;
    private int itsQuarters;
    private int itsDimes;
    private int itsNickels;
    private int itsCents;

    public double getChange(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Price? ");
        BigDecimal priceBig = new BigDecimal(scan.next());
        System.out.println("Your offer?");
        BigDecimal paidBig = new BigDecimal(scan.next());

        return paidBig.subtract(priceBig).doubleValue();
    }

    public boolean changeIsValid(double change){
        if(change < 0.00 || change > 0.99){
            System.out.println("Can't do that!");
            return false;
        }
        return true;
    }

    public void normalizeChange(double change){
        int totalCents = (int)(change * HUNDRED);

        BigDecimal[] dollarsCents = new BigDecimal(totalCents).divideAndRemainder(new BigDecimal(HUNDRED));
        BigDecimal[] quartersCents = new BigDecimal(dollarsCents[1].intValue()).divideAndRemainder(new BigDecimal(QUARTER));
        BigDecimal[] dimeCents = new BigDecimal(quartersCents[1].intValue()).divideAndRemainder(new BigDecimal(DIME));
        BigDecimal[] nickelCents = new BigDecimal(dimeCents[1].intValue()).divideAndRemainder(new BigDecimal(NICKEL));

        itsTotalCents = change;
        itsQuarters = quartersCents[0].intValue();
        itsDimes = dimeCents[0].intValue();
        itsNickels = nickelCents[0].intValue();
        itsCents = nickelCents[1].intValue();
    }

    public void printChange(double change){
        System.out.println("Change Owed: " + itsTotalCents);
        System.out.println("Quarters: " + itsQuarters);
        System.out.println("Dimes: " + itsDimes);
        System.out.println("Nickels: " + itsNickels);
        System.out.println("Cents: " + itsCents);
    }


    public static void main(String[] args) {

        Change c = new Change();

        double change = c.getChange();

        if(c.changeIsValid(change)){
            c.normalizeChange(change);
            c.printChange(change);
        }
    }
}
