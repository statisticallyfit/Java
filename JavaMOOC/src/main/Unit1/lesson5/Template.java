package main.Unit1.lesson5;

/**
 * Created by user1928 on 1/20/15.
 */
 /*
 * Lesson 5 - Unit 1 - Number Calculations and Order of Operations
 */

import java.io.*;

class Template{


    public static void main (String str[]) throws IOException {

        int num1 = 18;
        int num2 = 3;
        System.out.println(1.0 * num2/2); /*to print fill decimal*/

        int a = 11;
        double b = a/2; /*calculation happens before the assignment, so double-typed decimal still is cut off - fix as above*/
        System.out.println(b);


    }

}
