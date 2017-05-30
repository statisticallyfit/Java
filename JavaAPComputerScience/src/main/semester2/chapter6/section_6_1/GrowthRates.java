package semester2.chapter6.section_6_1;

import semester2.chapter6.section_6_4.IO;

import javax.swing.*;


public class GrowthRates {

    /*Calculate time to double money at user-inputted interest rate*/

    public GrowthRates(){
        double rate = IO.askDouble("Annual rate? 0 if done: ");
        while(rate > 0.0){
            IO.say("It takes " + yearsToDouble(rate) + " years for \nyour money to double.");
            rate = IO.askDouble("Another rate (0 when done): ");
        }
    }

    public int yearsToDouble(double interestRate){
        double balance = 1.0;
        int count = 0;

        while(balance < 2.0){
            balance *= (1.0 + interestRate/100.0);
            count++;
        }
        return count;
    }
}

class GrowthRateTester{

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Calculating growth for various interest rates");

        new GrowthRates();

        System.exit(0);
    }

}
