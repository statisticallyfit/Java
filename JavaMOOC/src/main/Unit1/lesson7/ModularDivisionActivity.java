package main.Unit1.lesson7;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModularDivisionActivity {


    public void individualDigits(){
        int sum = 0;
        String constant = "1";
        String s = "";
        BigDecimal[] digitsRem;
        List<Integer> list = new ArrayList<Integer>();

        System.out.println("Please enter a three digit number: ");
        Scanner scan = new Scanner(System.in);
        double digits = scan.nextDouble();
        System.out.println("\nHere are the digits: ");

        int numZeroes = Integer.toString((int)digits).length() - 1;
        for(int i = 0; i < numZeroes; i++){
            constant += "0";
        }

        double c = Double.parseDouble(constant);

        do {
            digitsRem = new BigDecimal(digits).divideAndRemainder(new BigDecimal(c));
            list.add(digitsRem[0].intValue());
            System.out.println(digitsRem[0]);
            digits = digitsRem[1].intValue();
            c /= 10;
        } while(digitsRem[1].intValue() != 0);

        System.out.println();

        //sum them
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }

        for(int i = 0; i < list.size() - 1; i++){
            s += list.get(i) + " " + "+" + " ";
        }

        System.out.println(s + list.get(list.size() - 1) + " = " + sum);
    }


    public static void main(String[] args) {

        ModularDivisionActivity mod = new ModularDivisionActivity();
        mod.individualDigits();
    }
}
