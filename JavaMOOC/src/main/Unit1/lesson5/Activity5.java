package main.Unit1.lesson5;

import java.util.Scanner;


public class Activity5 {

    public static void main(String[] args){
        question4();
    }

    public static void question1(){
        Scanner scan = new Scanner(System.in);

        double first = scan.nextDouble();
        double second = scan.nextDouble();

        System.out.println("First minus second: " + (first - second));
    }

    public static void question2(){
        Scanner scan = new Scanner(System.in);

        int one = scan.nextInt();
        int two = scan.nextInt();
        int three = scan.nextInt();
        int four = scan.nextInt();

        System.out.println("Sum: " + (one + two + three + four));
    }

    public static void question3(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a radius: ");

        double radius = scan.nextDouble();

        /*find circumference*/
        System.out.println(circumference(radius));
        /*area*/
        System.out.println(areaOfCircle(radius));
    }

    /*q3*/
    public static double circumference(double radius){
        return 2.0 * Math.PI * radius;
    }
    public static double areaOfCircle(double radius){
        return Math.PI * Math.pow(radius, 2);
    }

    public static void question4(){
        System.out.println("Enter a price: ");
        Scanner scan = new Scanner(System.in);

        double price = scan.nextDouble();

        System.out.println("Change from $20: " + "$" + (20 - price));
    }
}
