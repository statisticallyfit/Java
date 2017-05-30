package semester2.chapter6.section_6_1;

import java.util.Scanner;


/*Exercise 2*/

public class Gasoline {

    public double getDollarValueFromOneMark(){
        System.out.println("Input the dollar value of one German Mark");
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }

    public double getGermanPriceForLiterOfGas(){
        System.out.println("Enter the German price of one liter of gas");
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }

    public void convert(){
        System.out.println("The ratio marks/gas liters to dollars/gas gallons is: " + 1/(getDollarValueFromOneMark() * getGermanPriceForLiterOfGas() * 0.264));
    }
}

class GasolineTester {
    public static void main(String[] args) {
        new Gasoline().convert();
    }
}
