package Chapter3_DecisionStructures.workshop2;

import java.util.Scanner;

/**
 * calculates total price which includes sales tax
 */

public class SalesTax {
    public static void main(String[] args) {
        final double TAX_RATE = 0.055;
        double price, tax, total;
        String item;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Item description: ");
        item = keyboard.nextLine();
        System.out.print("Item price: $");
        price = keyboard.nextDouble();

        //calculations
        tax = price * TAX_RATE;
        total = price + tax;

        //display
        System.out.println();
        System.out.println(String.format("%s        $%.2f", item, price));
        System.out.println(String.format("Tax         $%.2f", tax));
        System.out.println(String.format("Total       $%.2f", total));
    }
}
