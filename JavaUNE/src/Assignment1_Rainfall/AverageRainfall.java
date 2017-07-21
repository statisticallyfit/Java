package Assignment1_Rainfall;

import java.util.Scanner;

/**
 * Author: Ana-Maria Vintila
 * Date: 7/21/2017
 * Title: Average Rainfall Calculator
 * Subject: COSC120
 *
 *
 * PROGRAM DESCRIPTION:
 * Collects data and calculates average rainfall over a period of years.
 * 1) Enter number of years
 * 2) iterate once for each year, then once for each month
 * 3) ask for inches of rainfall for that month.
 * 4) After all iterations, program displays number of months, total inches
 * of rainfall, and average rainfall per month for the entire period (in years).
 *
 *
 * Input validation:
 * .. does not accept number < 1 for number of years.
 * .. does not accept negative numbers for monthly rainfall.
 *
 *
 */

public class AverageRainfall {

    /**
     * Asks the user for number of years.
     * @return the number of years
     */
    public static int getYears(){

        //Create a scanner object to enter the number of years.
        Scanner scanner = new Scanner(System.in);

        // We do not check whether years is < 1 here, but later.
        System.out.print("Enter the number of years: ");
        int numYears = scanner.nextInt();

        return numYears;
    }

    /**
     * Asks user to enter inches of rainfall for any particular month.
     * Cannot accept negative integers.
     *
     * @param year = the year number
     * @param month = the month number
     *
     * @return the inches of rainfall for any month and any year.
     */
    public static double getRainfallAmount(int year, int month){

        // Prompt the user.
        System.out.print(String.format("Year %s month %s: ", year, month));

        // Create scanner object with 'new' keyword to accept input.
        Scanner scanner = new Scanner(System.in);
        double rainfall = scanner.nextDouble(); // get only a double type

        // Check for negative doubles - do not accept them, prompt user to keep entering until
        // they enter a non-negative double.
        while(rainfall < 0){
            System.out.print("Invalid. Enter 0 or greater: ");
            rainfall = scanner.nextDouble();
        }

        return rainfall;
    }



    public static void main(String[] args) {

        final int MONTHS_PER_YEAR = 12;     // the number of months in a year (always 12)
        int numYears;                       // number of years the user first inputs
        double validRainfall;               // the amount of rainfall that is checked for validity. (cm)
        double totalRainfall = 0;           // cumulative rainfall (cm)
        int monthCount;                     // total number of months in all the years.
        double averageRainfall;             // the totalRainfall divided by monthCount.

        // Get user input of years and check if numYears is less than 1, to avoid
        // mixing console logic with function logic in the getYears() method.
        numYears = getYears();
        if(numYears < 1){
            System.out.println("The number of years is less than 1. Program will exit...");
            System.exit(1);
        }

        // Now numYears is >= 1 so we can continue:

        // Now we can compute number of months in all the years.
        monthCount = numYears * MONTHS_PER_YEAR;

        // Input the rainfall data.
        System.out.println("Enter the rainfall, in centimeters, for each month.");

        // Loop through all the years and each of the 12 months per year.
        for(int y = 0; y < numYears; y++){
            for(int m = 0; m < MONTHS_PER_YEAR; m++){

                // accept only valid rainfall input (i.e. rainfall amount cannot be negative!). Assume centimeter units.
                validRainfall = getRainfallAmount(y+1, m+1);
                // add the now-valid rainfall to the total rainfall (in centimeters).
                totalRainfall += validRainfall;
            }
        }

        // Compute average. Integer truncation doesn't occur since totalRainfall is the double type.
        averageRainfall = totalRainfall / monthCount;

        // Display the results.
        System.out.println("\nNumber of months: " + monthCount);
        System.out.println("Total rainfall (cm): " + totalRainfall);
        System.out.println("Average monthly rainfall (cm): " + averageRainfall);

        System.exit(0);
    }
}
