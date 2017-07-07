package Chapter4_LoopsFiles;

import java.util.Scanner;

/**
 * Guides technician in process of checking chemical's temperature.
 */
public class CheckTemperature_While {

    public static void main(String[] args) {

        final double MAX_TEMP = 102.5; //max temp
        double temperature; // to hold the temperature.

        Scanner keyboard = new Scanner (System.in);

        System.out.print("Enter the substance's Celsius temperature = ");
        temperature = keyboard.nextDouble();

        while (temperature > MAX_TEMP){
            System.out.println("Temperature is too high. Turn down the termostat");
            System.out.println("and wait 5 minutes. Then take the temperature again");
            System.out.print("and enter it here = ");
            temperature = keyboard.nextDouble();
        }

        //remind him to check it again in 15 minutes.
        System.out.println("Temperature is acceptable.");
        System.out.println("Check it again in 15 minutes.");
    }
}
