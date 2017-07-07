package Chapter2_Fundamentals;

import java.util.Scanner;

/**
 * RULES: the problem only occurs when:
 * going from int/double -> reading string
 * if int/double -> string then problem (without flush) but after string -> string works.
 */


public class NextLineStringProblem {

    /**
     * Testing inputting ints and doubles first, then string
     * note - see here, we require flushing the buffer.
     */
    public static void testNumThenString(){
        System.out.println("\n----------------- Num, String ------------------");

        String name;
        int age;
        double income;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("What is your age? ");
        age = keyboard.nextInt();

        System.out.print("What is your annual income? ");
        income = keyboard.nextInt();

        // consume the newline left in the keyboard buffer after nextInt()
        // (newline created when user presses ENTER)...
        // ... because while nextInt, nextDouble are designed to skip newlines
        // and continue reading, the nextLine() method is not.
        // Must consume it fo flush buffer then read good input.
        //todo - uncomment for this to work.
        //String flushed = keyboard.nextLine();
        //System.out.println("flushed = " + flushed);

        System.out.print("What is your name? ");
        name = keyboard.nextLine();

        System.out.println("Hello, " + name + ". Your age is " + age + " and your " +
                "income is $" + income);
    }

    public static void testStringThenString(){
        System.out.println("\n----------------- String, String ------------------");

        String name;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter your name:");
        name = keyboard.nextLine();
        System.out.println(name);

        System.out.print("Enter your last name: ");
        name = keyboard.nextLine();
        System.out.println(name);
    }

    public static void testNumThenStringThenString(){
        System.out.println("\n----------------- Num, String, String ------------------");

        int num;
        String name;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Give a number: ");
        num = keyboard.nextInt();
        System.out.println(num);


        System.out.print("Enter your name:");
        name = keyboard.nextLine();
        System.out.println(name);

        System.out.print("Enter your last name: ");
        name = keyboard.nextLine();
        System.out.println(name);
    }

    public static void testStringThenNum(){
        System.out.println("\n----------------- String, Num ------------------");

        String name;
        int age;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter your name:");
        name = keyboard.nextLine();
        System.out.println(name);

        System.out.print("Enter your age: ");
        age = keyboard.nextInt();
        System.out.println(age);
    }

    public static void main(String[] args) {

        testNumThenString();
        testNumThenStringThenString();
        testStringThenString();
        testStringThenNum();
    }
}
