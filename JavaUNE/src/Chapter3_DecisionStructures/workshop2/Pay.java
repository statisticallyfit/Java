package Chapter3_DecisionStructures.workshop2;

import java.util.Scanner;

/**
 * Calculates user's gross pay.
 */

public class Pay {
    public static void main(String[] args) {
        //create scanner to read from keyboard
        Scanner keyboard = new Scanner(System.in);

        //identifier declarations
        double hoursWorked;
        double rate; // hourly rate
        double grossPay;

        for(int i = 0; i < 6; i++){
            System.out.print("How many hours did you work? ");
            hoursWorked = keyboard.nextDouble();
            System.out.print("How much do you get paid per hour? ");
            rate = keyboard.nextDouble();

            //calculations
            if(hoursWorked <= 40){
                grossPay = hoursWorked * rate;
            } else{
                double hoursOvertime = hoursWorked - 40;
                grossPay = hoursOvertime*rate + 0.5*hoursOvertime*rate + 40*rate;
            }

            //results
            System.out.printf("You earned $%.2f\n", grossPay);
            System.out.println();
        }
    }
}