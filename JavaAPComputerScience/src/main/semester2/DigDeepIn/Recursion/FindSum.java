package semester2.DigDeepIn.Recursion;


public class FindSum {


    /** @param n is a positive integer
     *  @return 1 + 2 + 3 + 4 + ... + n
     */

    public static int sum(int n) { //method originally called "triangle"
        if(n == 1)
            return 1;
        else
            return n + sum(n - 1);
    }

    /* Driver method: tests if n is positive just once
    * to avoid stack over flow infinite recursion */

    public static int getSum(int n){
        if(n > 0)
            return sum(n);
        else
            throw new IllegalArgumentException("Error: n must be positive!");
    }
}
