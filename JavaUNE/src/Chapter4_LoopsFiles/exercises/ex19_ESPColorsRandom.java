package Chapter4_LoopsFiles.exercises;

import java.util.Random;
import java.util.Scanner;

/**
 * Stores colors: Red, Green, Blue, Orange, Yellow.
 * Generates a random number:
 * 0 - Red
 * 1 - Green
 * 2 - Blue
 * 3 - Orange
 * 4 - Yellow
 * Asks the user to enter color as a guess, then displays actual computer choice.
 * Repeat 10 times then compute num times the user correctly guessed
 * the selected color.
 *
 *
 */

public class ex19_ESPColorsRandom {

    public static void main(String[] args) {
        Random rand = new Random();
        int colorNum;
        String colorGuess;
        String color = "";
        Scanner scanner = new Scanner(System.in);
        int ITERATIONS = 10;
        int numCorrectGuesses = 0;


        for(int count = 0; count < ITERATIONS; count++)
        {
            colorNum = rand.nextInt(5); // number from 0 to 4.

            switch(colorNum){
                case 0:
                    color = "Red";
                    break;
                case 1:
                    color = "Green";
                    break;
                case 2:
                    color = "Blue";
                    break;
                case 3:
                    color = "Orange";
                    break;
                case 4:
                    color = "Yellow";
                    break;
            }

            System.out.print("\nEnter your color guess: ");
            colorGuess = scanner.nextLine();

            // Display results
            System.out.println("\nGuess: " + colorGuess);
            System.out.println("Actual: " + color);

            if(colorGuess.equals(color)){
                numCorrectGuesses++;
            }
        }

        System.out.println("\n-------------------------------------------------");
        System.out.println(String.format("Correct %d / %d", numCorrectGuesses, ITERATIONS));
    }
}
