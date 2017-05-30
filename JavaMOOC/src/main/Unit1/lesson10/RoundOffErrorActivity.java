package main.Unit1.lesson10;


import java.util.Scanner;

public class RoundOffErrorActivity {

    public static void main(String[] args) {
        System.out.println("Please enter two decimal values");

        Scanner scan = new Scanner(System.in);
        double first = scan.nextDouble();
        double second = scan.nextDouble();

        System.out.println((first * 1000 - second * 1000)/1000);
    }
}
