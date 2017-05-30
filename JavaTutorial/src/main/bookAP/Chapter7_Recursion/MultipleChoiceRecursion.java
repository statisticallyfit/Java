package main.bookAP.Chapter7_Recursion;

/* From AP Barrons page 311 */

import java.util.Scanner;
import java.util.Stack;

public class MultipleChoiceRecursion {

    /* Question 9
     * @param x an array of n integers
     * @param n a positive integer
     */
    public static int recur(int[] x, int n){
        int t;
        if(n == 1) {
            return x[0];
        } else {
            t = recur(x, n - 1);

            System.out.println("t = " + t);
            System.out.println("x[n - 1] = " + x[n - 1]); //tracing output
            if(x[n - 1] > t) {
                return x[n - 1];
            }
            else {
                System.out.println("\nFinal t: = " + t);
                return t;
            }
        }
    }

    /* Question 10
     */
    public static void printString(String s){
        if(s.length() > 0){
            printString(s.substring(1));
            System.out.print(s.substring(0, 1));
        }
    }

     /* Question 12 */
    public static void doSomething(int n) {
        if(n > 0) {
            doSomething(n - 1);
            System.out.print(n);
            doSomething(n - 1);
        }
    }

    /* Question 13 */

    public static void writeEven(){
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        if(num != -999){
            writeEven();
            if(num % 2 == 0){
                System.out.println(num + " ");
            }
        }
    }

    public static void writeEvenNumbersUsingStack(){
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();

        int num = scan.nextInt();

        while(num != -999){
            stack.push(num);
            num = scan.nextInt();
        }

        int numAtTop = stack.pop();

        while(!stack.empty()){
            if(numAtTop % 2 == 0){
                System.out.print(numAtTop + " ");
            }
            numAtTop = stack.pop();
        }
    }


    /* Question 19 and 20 */

    public static void writeThreeDigits(int n){
        System.out.print(n / 100);
        System.out.print((n / 10) % 10);
        System.out.print(n % 10);
    }

    public static void writeWithCommas(int n){
        if(n < 1000){
            System.out.print(n);
        } else {
            writeThreeDigits(n % 1000);
            System.out.print(",");
            writeWithCommas(n / 1000);
        }
    }


    /**
     * From MOOC
     */
    public static void mystery(int n)
    {
        if (n > 0)
        {
            n--;
            mystery(n);
        }
        System.out.print(n + " ");
    }

    public static void mysteryWithStack(int n){
        Stack<Integer> stack = new Stack<Integer>();

        while(n > 0){
            n--;
            stack.push(n);
        }
        System.out.print(n + " ");

        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }


    /**
     * From MOOC
     * @param n
     */

    public static void recurOne(int n)
    {
        if (n > 0)
            recurOne(n - 2);
        System.out.print(n + " ");
    }

    public static void recurOneWithStack(int n){
        Stack<Integer> stack = new Stack<Integer>();

        while(n > 0){
            stack.push(n);
            n -= 2;
        }
        System.out.print(n + " ");

        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }


    /**
     * From MOOC
     * @param n
     */

    public static void recurTwo(int n)
    {
        if (n > 0)
            recurTwo(n - 1);
        for (int i = 0; i < n; i++)
            System.out.print("*");
        System.out.println();
    }

    public static void recurTwoWithStack(int n){
        Stack<Integer> stack = new Stack<Integer>();

        while(n > 0){
            stack.push(n);
            n--;
        }


        do {
            int nLimit = stack.pop();

            for(int i = 0; i < nLimit; i++)
                System.out.print("*");
            System.out.println();

        } while(!stack.empty());
    }


    /**
     * From MOOC
     * @param n
     */
    public static void recurThree(int n)
    {
        if (n > 0)
            recurThree(n - 10);
        System.out.print(n + " ");
    }

    public static void recurThreeWithStack(int n){
        Stack<Integer> stack = new Stack<Integer>();

        while(n > 0){
            stack.push(n);
            n -= 10;
        }

        System.out.print(n + " ");

        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }


    /**
     * From Activity: recursive method with returns
     * @param n
     */
    public static double mystere(int n) {
        if (n > 0)
            mystere(n - 1);
        return n;
    }

    /**
     * From activity
     * @param n
     */
    public static void misteriosa(String digits, int n) {
        System.out.println(digits);

        digits = digits.substring(n);

        if (n > 0)
            misteriosa(digits, n - 1);
    }


    /**
     *
     * @param n
     */
    public static int misterioso(int n) {
        n--;

        if (n > 0)
            misterioso(n);

        return n * 2;
    }

    public static int misteriosoWithStack(int n){
        Stack<Integer> stack = new Stack<Integer>();

        n--;

        while(n > 0){
            stack.push(n);
            n--;
        }
        int ans = 0;
        while(stack.size() >= 1){
            ans = stack.pop();
        }

        return 2 * ans;

    }


    /**
     *
     * @param n
     */

    public static void recur1(int n)
    {
        if (n > 1)
            recur1(n / 10);
        System.out.print(n % 10 + " ");
    }

    public static void recur1Loop(int n){
        Stack<Integer> stack = new Stack<Integer>();

        while(n > 1){
            stack.push(n);
            n /= 10;
        }
        System.out.print(n + " ");

        do {
            System.out.print((stack.pop() % 10) + " ");
        } while(!stack.empty());
    }


    /**
     *
     * @param n
     */
    public static void recur2(int n)
    {
        if (n > 1)
            recur2(n - 1);

        System.out.print(n+ " ");
    }

    public static void recur2Loop(int n){
        Stack<Integer> stack = new Stack<Integer>();

        while(n > 1){
            stack.push(n);
            n--;
        }
        System.out.print(n + " ");

        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {

        recur2(6);
    }
}
