package semester2.chapter6.section_6_1;

import java.util.Scanner;



/*Exercise 4*/
public class ConvertDays {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double days = scan.nextDouble();
        System.out.println("Number of hours: " + 24.0 * days);
        System.out.println("Number of minutes: " + 24.0 * 60.0 * days);
        System.out.println("Number of seconds: " + 24.0 * 60.0 * 60.0 * days);
    }
}
