package main.Unit1.lesson4;

/**
 * Created by user1928 on 1/20/15.
 */

import java.io.IOException;
import java.util.Scanner;


/**
 * Created by user1928 on 1/20/15.
 */
/*
 * Lesson 4 - Unit 1  - Data types
 */

class TemplateDataTypes{


    public static void main (String str[]) throws IOException {


        /*int x = 9;

        System.out.println(x );
        System.out.println(x * 7);*/


        /*Integer*/
        Scanner scan = new Scanner(System.in);
        System.out.println("Input an integer!"); //communicate
        int x = scan.nextInt();

        System.out.println("Input: " + x);


        /*Double*/
        double y = scan.nextDouble();

        System.out.println("Input: " + y);
    }

}

