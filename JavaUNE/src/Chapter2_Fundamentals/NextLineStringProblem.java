package Chapter2_Fundamentals;

import java.util.Scanner;

/**
 *
 */
public class NextLineStringProblem {


    public static void main(String[] args) {

        String name;
        int age;
        double income;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("What is your age? ");
        age = keyboard.nextInt();

        System.out.print("What is your annual income? ");
        income = keyboard.nextInt();

        // consume the newline left in the keyboard buffer after nextInt()
        // because while nextInt, nextDouble are designed to skip newlines
        // and continue reading, the nextLine() method is not.
        // Must consume it fo flush buffer then read good input.
        String flushed = keyboard.nextLine();
        System.out.println("flushed = " + flushed);

        System.out.print("What is your name? ");
        name = keyboard.nextLine();

        System.out.println("Hello, " + name + ". Your age is " + age + " and your " +
                "income is $" + income);
    }
}
