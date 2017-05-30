package main.Unit1.lesson4;

import java.util.Scanner;

/**
 * Created by user1928 on 1/20/15.
 */




public class Activity4 {


    public static void main(String[] args) {
        codeQuestionTwo();
    }

    public static void codeQuestionTwo(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Hi there. What is your name?");
        String name = scan.nextLine();

        System.out.println("Hi " + name + ". How old are you?");
        int age = scan.nextInt();
        System.out.println(name + ", you will be 100 in " + (100 - age) + " years." );
    }

    public static void codeQuestionOne(){
        Scanner scan = new Scanner(System.in);
        System.out.println("First: ");
        double first = scan.nextDouble();
        System.out.println("Second: ");
        double second = scan.nextDouble();

        System.out.println(second + " " + first);
    }


    public static void questionEleven(){
        int y = 2147483647;
        y++;
        System.out.println(y);
        y += 2;
        System.out.println(y);
        y += 3;
        System.out.println(y);
        y += 4;
        System.out.println(y);
        y += 5;
        System.out.println(y);
        y += 6;
        System.out.println(y);
        y += 7;
        System.out.println(y);
        y += 8;
        System.out.println(y);
        y += 9;
        System.out.println(y);
        y += 10;
        System.out.println(y);

        /*Overflow Output:
        *
        *   -2147483648
            -2147483646
            -2147483643
            -2147483639
            -2147483634
            -2147483628
            -2147483621
            -2147483613
            -2147483604
            -2147483594
        * */
    }
}
