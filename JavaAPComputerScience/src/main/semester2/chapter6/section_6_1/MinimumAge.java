package semester2.chapter6.section_6_1;

import java.util.Scanner;

/**
 * Created by user1928 on 1/31/15.
 */


/*Assignment 6.7 */

public class MinimumAge {

    public static int getMinAge(int x, int y, int z){
        return Math.min(Math.min(x, y), z);
    }

    public static void main(String[] args) {

        System.out.println("Goal: Show you the youngest age");

        System.out.println("Input three ages by pressing enter after each one: ");

        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();

        System.out.println("The youngest age is: " + getMinAge(x, y, z));
    }
}
