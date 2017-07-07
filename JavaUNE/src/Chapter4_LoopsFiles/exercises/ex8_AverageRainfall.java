package Chapter4_LoopsFiles.exercises;

import java.util.Scanner;

/**
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

public class ex8_AverageRainfall {

    /**
     * Asks the user for number of years. Cannot be less than 1.
     * @return the number of years
     */
    public static int getYears(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of years: ");
        int numYears = scanner.nextInt();

        while(numYears < 1){
            System.out.print("Invalid. Enter 1 or greater: ");
            numYears = scanner.nextInt();
        }

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

        System.out.println("Enter the rainfall, in centimeters, for each month.");
        System.out.print("Year " + year + " month " + month + ": ");

        Scanner scanner = new Scanner(System.in);
        double rainfall = scanner.nextDouble();

        while(rainfall < 0){
            System.out.print("Invalid. Enter 0 or greater: ");
            rainfall = scanner.nextDouble();
        }

        return rainfall;
    }



    public static void main(String[] args) {

        final int MONTHS = 12;
        int numYears = getYears();

        for(int y = 0; y < numYears; y++){
            for(int m = 0; m < MONTHS; m++){
                System.out.println("Please enter the inches of rainfall: ");
            }
        }

    }
}
