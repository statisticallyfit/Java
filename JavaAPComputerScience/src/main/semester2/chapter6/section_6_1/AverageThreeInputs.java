package semester2.chapter6.section_6_1;

import java.util.Scanner;



/*Exercise 6.1*/

public class AverageThreeInputs {

    public double getAndAverage(){

        Scanner scan = new Scanner(System.in);

        double first = scan.nextDouble();
        double second = scan.nextDouble();
        double third = Double.parseDouble(scan.next());

        return (first + second + third)/3;
    }
}

class AverageThreeInputsTester{
    public static void main(String[] args) {
        System.out.println("Input some decimal numbers to find the average");
        System.out.println("The average is: " + new AverageThreeInputs().getAndAverage());
    }
}
