package Chapter6_FirstClasses.exercises;

import Chapter6_FirstClasses.Die;

import java.util.Scanner;

/**
 This program demonstrates a solution to the
 A Game of Twenty One programming challenge.
 */

public class GameTwentyOne_Answer {

    public static void main(String[] args) {
        int computer = 0; // To hold the computer's points.
        int user = 0;     // To hold the user's points.

        // Play the game while the user's points are
        // under the limit, and the user agrees to
        // roll the dice.
        while(underLimit(user) && rollDice()) {
            // Let the computer decide if it should
            // roll the dice again without going over
            // the limit.
            if (underLimit(computer + getDiceValue()))
                computer += getDiceValue();

            // Roll the user's dice and display the
            // total number of accumulated points.
            user += getDiceValue();
            System.out.println("Points: " + user);
            System.out.println("Computer points: " + computer);
        }

        if (user == 0 && computer == 0)
            System.out.println("Goodbye!");
        else
        {
            displayResults(computer, user);
        }
    }

    /**
     The getDiceValue method simulates the rolling
     of a pair of dice.
     @return The sum of the value of the dice.
     */

    public static int getDiceValue()
    {
        // Create the dice objects.
        Die die1 = new Die();
        Die die2 = new Die();

        // Roll the dice.
        die1.roll();
        die2.roll();

        // Return the sum of the value of the dice.
        return die1.getDieValue() + die2.getDieValue();
    }

    /**
     The rollDice method asks the user to roll
     the dice, accepting keyboard input as the
     answer.
     @return true if the user wants to roll the
     dice, or false otherwise.
     */

    public static boolean rollDice()
    {
        String input;        // To hold a line of input
        char letter;         // To hold a single character

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Ask the user to roll the dice.
        do
        {
            System.out.print("Roll the dice? (y/n) : ");
            input = keyboard.nextLine();  // Get a line of input.
            letter = input.charAt(0);     // Get the first character.

            // Validate the input.
        }while(!isValid(letter));

        boolean answer = true;  // To hold the user's decision

        // Determine if the user answered yes or no.
        switch (letter)
        {
            case 'y':
            case 'Y':
                break;
            default:
                answer = false;
        }

        // Return the user's answer as true or false.
        return answer;
    }

    /**
     The underLimit method determines if the
     points are under the limit of 21.
     @return true if points are less than 21,
     or false otherwise.
     */

    public static boolean underLimit(int value)
    {
        boolean status = true;

        if (value > 21)
            status = false;

        return status;
    }

    /**
     The isValid method validates the user input.
     @return true if the input is valid, or
     false otherwise.
     */

    public static boolean isValid(char letter)
    {
        boolean status = true;

        switch (letter)
        {
            case 'y':
            case 'Y':
            case 'n':
            case 'N':
                break;
            default:
                status = false;
        }

        return status;
    }

    /**
     The displayResults method determines the results
     of the game and displays them.
     */

    public static void displayResults(int computer, int user)
    {
        // Display the computer and user's points.
        System.out.println("\nGame Over\n");
        System.out.println("User's Points: " + user);
        System.out.println("Computer's Points: " + computer);

        // Determine and display the results.
        if(underLimit(user) && user > computer)
            System.out.println("The user wins!");
        else if(underLimit(user) && !underLimit(computer))
            System.out.println("The user wins!");
        else if(user == 21 && computer != 21)
            System.out.println("The user wins!");
        else if(user == computer)
            System.out.println("This game has ended in a tie!");
        else if (!underLimit(user) && !underLimit(computer))
            System.out.println("This game has ended without a winner.");
        else
            System.out.println("The computer wins!");
    }
}