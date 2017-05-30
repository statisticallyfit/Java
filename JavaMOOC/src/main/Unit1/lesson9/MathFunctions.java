package main.Unit1.lesson9;


public class MathFunctions {

    /* Math round only rounds to nearest whole number */

    /* To have random numbers between 30 and 40, write:
    * 30 + (int)(Math.random() * 11)
    * since 1) multiply by amount of numbers in that range (11)
    * and   2) cast to int
    * and   3) add lowest number in that range to the total */

     public static void main(String[] args) {
        System.out.println(Math.round(Math.sqrt(26)));

         /* numbers between -20 to 20 inclusive*/
         System.out.println(-20 + (int)(Math.random() * 41));

    }
}
