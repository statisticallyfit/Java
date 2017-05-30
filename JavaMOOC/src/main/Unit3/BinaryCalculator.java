package main.Unit3;


import java.util.Scanner;

public class BinaryCalculator {

    public int[] convertToBinary(int decimalNum){
        String binaryStr = "";

        for(int exp = 7; exp >= 0; exp--){
            int chartVal = (int)(Math.pow(2, exp));

            if(decimalNum < chartVal)
                binaryStr += "0";
            else{
                binaryStr += "1";
                decimalNum -= chartVal;
            }
        }

        int[] bins = new int[binaryStr.length()];

        for(int i = 0; i < bins.length; i++){
            bins[i] = Integer.parseInt(binaryStr.substring(i, i + 1));
        }



        return bins;
    }

    /*
    0 + 1 = 1
    1 + 1 = 10 (carry over the 1)
    1 + 1 + 1 = 11

    Ex: 0111 + 1110 = 10101
     */
    public int[] addBin(int[] a, int[] b){
        int[] append = new int[a.length + b.length];



        return append;
    }

    public void printBin(int[] b){
        for(int bin : b)
            System.out.print(bin + " ");
        System.out.println();
    }
}

class TestBinaryCalculator{

    public static void main(String[] args) {
        BinaryCalculator calc = new BinaryCalculator();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a base ten number between 0 and 255, inclusive. ");
        int num1 = scan.nextInt();
        System.out.println("Enter a base ten number between 0 and 255, inclusive. ");
        int num2 = scan.nextInt();
        System.out.println();

        System.out.println("First binary number: ");
        calc.printBin(calc.convertToBinary(num1));
        System.out.println("\nSecond binary number: ");
        calc.printBin(calc.convertToBinary(num2));


        System.out.println("\nAdded: ");
        //System.out.println(calc.addBin());

    }
}
