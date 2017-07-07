package Chapter4_LoopsFiles;

import java.util.Random;
import java.util.Scanner;

/**
 * NOTE: random.nextInt(b) generates integers from 0...(b-1).
 */
public class Random_RollDice {

    public static void main(String[] args) {
        String again;
        int die1;
        int die2;
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();

        do {
            System.out.println("Rolling the dice ...");
            die1 = rand.nextInt(6) + 1;
            die2 = rand.nextInt(6) + 1;
            System.out.println("Their values are: \n" + die1 + " " + die2);

            System.out.println("Roll them again (y = yes)? ");
            again = keyboard.nextLine();

        } while(again.equalsIgnoreCase("y"));
    }
}
