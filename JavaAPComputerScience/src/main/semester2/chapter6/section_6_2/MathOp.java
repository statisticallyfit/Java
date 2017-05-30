package semester2.chapter6.section_6_2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MathOp {

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


    /**Return sum divided by count rounded to nearest int -- inaccurate int rounding, for example, 6.7 becomes 6**/
    public static int average(int sum, int howMany){
        //exercise 5.1
        if(howMany == 0){
            return 0;
        }
        //this is the same effect as roundOff() method
        return sum >= 0 ? (sum + howMany/2)/howMany : (sum - howMany/2)/howMany;
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
        one = inputLower.nextInt();
        return one;
    }
    public static int getTwo(){
        int two;
        Scanner inputUpper = new Scanner(System.in);
        two = inputUpper.nextInt();
        return two;
    }



    /*Rounding methods*/

    public static int roundToNearestWholeNum(double par){
        return par >= 0 ? (int) (par + 0.5) : (int) (par - 0.5);
    }

    public static double roundToNearestHundredth(double par){
        return par >= 0 ? (1.0 * (int) (par * 100 + 0.5)) / 100
                        : (1.0 * (int) (par * 100 - 0.5)) / 100;
    }
}
