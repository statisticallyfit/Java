package main.Unit2.lesson20;


import java.util.Scanner;

public class FlagVariables {

    private final static int SENTINEL = -1;


    public static void main(String[] args) {
        /* testing if number entered is prime */

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an int");
        int num = scan.nextInt();

        while(num != SENTINEL){
            int x = 2;
            boolean numberWasPrime = true;

            while(x < num)
            {
                if(num % x == 0)
                {
                    numberWasPrime = false;
                }
                x++;
            }

            if(numberWasPrime)
                System.out.println(num + " is prime");
            else
                System.out.println(num + " is NOT prime");

            System.out.println("\nEnter -1 to stop");
            num = scan.nextInt();
        }
    }
}
