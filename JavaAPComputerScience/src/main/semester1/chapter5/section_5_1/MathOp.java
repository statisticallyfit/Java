package semester1.chapter5.section_5_1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by user1928 on 12/15/14.
 */


/*
 * This is a UTILITIES CLASS
 */

public class MathOp{


    private MathOp(){
        super();
    }
    /** Return 2 ^ expo **/
    public static int powerOfTwo(int expo){
        int power = 1;

        //exercise 5.2
        if(expo > 30){
            expo = 30;
        }

        for( ; expo > 0; expo--){
            power *= 2;
        }
        return power;
    }
    /**Return sum divided by count rounded to nearest int**/
    public static int average(int sum, int count){
        //exercise 5.1
        if(count == 0){
            return 0;
        }

        if(sum >=0){
            return (sum + count/2)/count;
        }else{
            return (sum - count/2)/count;
        }
    }

    //Exercise 5.3
    public static int power(int base, int expo){
        int result = 1;

        //return -1 if power cannot be computed with int values (case1: result gets bigger than int can hold)
        if(expo > 30){
            return -1;
        }
        //return 0 if either are negative
        else if(base < 0 || expo < 0){
            return 0;
        }
        else if(expo == 0){
            return result;
        }
        else{
            for( ; /*expo <= (2147483647) && -- this is always true*/ expo > 0 ; expo--){
                result *= base;
            }
            return result;
        }
    }

    /*
     * Assignment 5.4
     */
    public static int gcd(int one, int two){

        ArrayList<Integer> trackList = new ArrayList<Integer>();

        //checking for input anomalies
        if(one == 0 || two == 0){
            return 0; //quit program with exit code 0
        }
        if(two < 0){
            two *= -1; //then continue program
        }
        if(one < 0){
            one *= -1; //then continue program
        }


        if(two > one) {
            trackList.add(two);
            trackList.add(one);


            for(int i = 0; /** no condition here */; i++){
                BigDecimal[] qr = new BigDecimal(trackList.get(i)).divideAndRemainder(new BigDecimal(trackList.get(i+1)));
                trackList.add(qr[1].intValue()); //add the remainder

                if(qr[1].intValue() == 0){
                    return trackList.get(i+1);
                }
            }
        }

        //else if(one > two){

        trackList.add(one);
        trackList.add(two);

        for(int i = 0; /** no condition here */; i++){
            BigDecimal[] qr = new BigDecimal(trackList.get(i)).divideAndRemainder(new BigDecimal(trackList.get(i+1)));
            trackList.add(qr[1].intValue()); //add the remainder

            if(qr[1].intValue() == 0){
                return trackList.get(i+1);
            }
        }

    }

    /**
     * Assignment 5.6: Factorial program
     */

    public static int factorial(int n){

        /*
        These statements below would go into the main method so command line arguments may be entered

        int n = Integer.parseInt(args[0]); //input argument from command line. For example, to get 8! input 8 as n
        factorial(n); //call method

         */
        int multiplier = 1;
        int result = 1;


        //how to deal with negative values for (n)
        if(n < 0){
            n *= -1; //make n positive if it is negative
        }


        for( ; multiplier <= n; multiplier++){
            result *= multiplier;
        }

        System.out.println(result);
        return result;
    }



    //Exercise 5.8
    public static int range(int one, int two){

        Random random = new Random();
        int randIntWithinBounds = 0;

        if(one < two){
            randIntWithinBounds = one + random.nextInt(two - one + 1); //arg = number of numbers in range
        } else{
            randIntWithinBounds = two + random.nextInt(one - two + 1);
        }
        return randIntWithinBounds;
    }

    public static int getOne(){
        int one;

        Scanner inputLower = new Scanner(System.in);
        //String lowerStr = inputLower.next();
        one = inputLower.nextInt();

        return one;
    }

    public static int getTwo(){
        int two;

        Scanner inputUpper = new Scanner(System.in);
        //String upperStr = inputUpper.next();
        two = inputUpper.nextInt();

        return two;
    }




    public static void checkCorrectness(){

        {
            if(!(range(40, 56) <=56 && range(40, 56) >= 40)){
                System.err.println("Error with range 40, 56");
            }

            if(!(range(1, 100) <=100 && range(1, 100) >= 1)){
                System.err.println("Error with range 1, 100");
            }

            /*if(!(range(40, 56) <=56 && range(40, 56) >= 40)){
                System.err.println("Error with range 40, 56");
            }*/
        }

    }

    /** Another way to do Assignment 5.4*/

    //private static int itsCount = 0;

    public static long GCD(long a, long b) {

        //itsCount++;

        if (b==0){
            return a;
        }
        else{
            return GCD(b, a % b);
        }
    }
    public static void main(String[] args) {
        System.out.println(gcd(135, 8));
        System.out.println(GCD(135, 8));
    }
}


