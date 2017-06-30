package Chapter3_DecisionStructures;

import java.util.Scanner;

/**
 *
 */
public class PetFood_SwitchFallThrough {

    public static void main(String[] args) {

        //note: switch can fall through. Sometimes this is what you want
        // means both types of case statements are allowed.

        String input;
        char foodGrade;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Our pet food is available in three grades: ");
        System.out.println("A, B, C. Which do you want pricing for? ");
        input = keyboard.nextLine();
        foodGrade = input.charAt(0);

        //display pricing for selected food grade.
        switch (foodGrade){ //note: test expression is char type. Allowed: char, byte, int, short, string.
            case 'a':
            case 'A':
                System.out.println("30 cents per lb."); // note: both 'a' and 'A' are allowed as inputs.
                break;
            case 'b':
            case 'B':
                System.out.println("20 cents per lb.");
                break;
            case 'c':
            case 'C':
                System.out.println("15 cents per lb.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
