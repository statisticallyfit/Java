package main.bookAP.Chapter2_ClassesAndObjects;

import java.util.Scanner;

/**
 * Created by user1928 on 4/2/2015.
 */
public class Temperature {

    private String scale; //valid values are "F" or "C"
    private double degrees;

    public Temperature(double tempDegrees, String tempScale){
        scale = tempScale;
        degrees = tempDegrees;
    }

    public String toString(){
        return degrees + " degrees " + scale;
    }

    //...
    public static boolean isValidTemp(double tempDegrees, String tempScale){
        if(tempScale.equals("F") && tempDegrees >= 32 && tempDegrees <= 212){
            return true;
        } else if(tempScale.equals("C") && tempDegrees >= 0 && tempDegrees <= 100) {
            return true;
        } else {
            return false;
        }
    }
}
class TemperatureRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter temperature scale: ");
        String tempScale = scan.next();
        System.out.println("Enter number of degrees: ");
        double tempDegrees = scan.nextDouble();

        /* Code to construct valid temperature */
        if(Temperature.isValidTemp(tempDegrees, tempScale)) { //can use this method even without
            // making object since this is a static method
            Temperature t = new Temperature(tempDegrees, tempScale);
            System.out.println(t.toString());
        } else {
            System.out.println("Not valid");
        }
    }
}
