package Assignment1_Rainfall;

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

public class AverageRainfall {

    /**
     * Asks the user for number of years. Cannot be less than 1.
     * @return the number of years
     */
    public static int getYears(){

        Scanner scanner = new Scanner(System.in);

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

        System.out.print(String.format("Year %s month %s: ", year, month));

        Scanner scanner = new Scanner(System.in);
        double rainfall = scanner.nextDouble();

        while(rainfall < 0){
            System.out.print("Invalid. Enter 0 or greater: ");
            rainfall = scanner.nextDouble();
        }

        return rainfall;
    }



    public static void main(String[] args) {

        final int MONTHS_PER_YEAR = 12;
        int numYears;
        double validRainfall;
        double totalRainfall = 0;
        int monthCount;
        double averageRainfall;


        numYears = getYears();
        if(numYears < 1){
            System.out.println("The number of years is less than 1. Program will exit...");
            System.exit(1);
        }

        // Now we can compute number of months in all the years.
        monthCount = numYears * MONTHS_PER_YEAR;

        // Input the rainfall data.
        System.out.println("Enter the rainfall, in centimeters, for each month.");

        for(int y = 0; y < numYears; y++){
            for(int m = 0; m < MONTHS_PER_YEAR; m++){

                validRainfall = getRainfallAmount(y+1, m+1);
                totalRainfall += validRainfall;
            }
        }

        // Compute average.
        averageRainfall = totalRainfall / monthCount;

        System.out.println("\nNumber of months: " + monthCount);
        System.out.println("Total rainfall: " + totalRainfall + " centimeters");
        System.out.println("Average monthly rainfall: " + averageRainfall);

        System.exit(0);
    }
}
