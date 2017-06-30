package Chapter3_DecisionStructures.exercises;

import java.util.Scanner;

/**
 *
 */
public class SoftwareSales {

    final static double UNIT_PRICE = 99.0;

    public double calcDiscount(int quantity){
        double discPercent = 0;

        if(quantity >= 10 && quantity < 20){
            discPercent = 0.20;
        } else if(quantity >= 20 && quantity < 50){
            discPercent = 0.30;
        } else if(quantity >= 50 && quantity < 100){
            discPercent = 0.40;
        } else if(quantity >= 100){
            discPercent = 0.50;
        }

        return (quantity * UNIT_PRICE) * discPercent;
    }

    public int getQuantity(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Input the number of packages to buy: ");
        return keyboard.nextInt();
    }


    public static void main(String[] args) {
        SoftwareSales obj = new SoftwareSales();

        int quant = obj.getQuantity();
        double disc = obj.calcDiscount(quant);
        double totalCost = quant * UNIT_PRICE - disc;

        System.out.printf("The discount for %d packages is $%.2f\n", quant, disc);
        System.out.printf("The total cost (taking into account discount) is $%.2f\n", totalCost);
    }
}
