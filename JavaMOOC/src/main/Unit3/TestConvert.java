package main.Unit3;

import java.util.Scanner;

/**
 * Activity1011_OctalToDecimal
 */

class Hexadecimal {
    private static final int HEX_BASE = 16;
    private String hexNum;

    public Hexadecimal(String hNum){
        hexNum = hNum;
    }

    public String getHexadecimal(){
        return hexNum;
    }

    public int getBase(){
        return HEX_BASE;
    }
}

class Octal {

    private static final int OCTAL_BASE = 8;
    private int octalNum;

    public Octal(int octNum){
        octalNum = octNum;
    }

    public int getOctal(){
        return octalNum;
    }

    public int getBase(){
        return OCTAL_BASE;
    }

    public boolean isValid(){
        int numDigits = 0;
        int digit = 0;
        do {
            digit = octalNum % 10;
            if(digit >= 8)
                return false;
            octalNum /= 10;
            numDigits++;
        } while(octalNum > 0);

        return numDigits <= 8;
    }

    public int convertToDecimal(){
        Octal o = new Octal(octalNum);
        if(!o.isValid()){
            System.out.println("ERROR: Incorrect Octal Format");
            return -1;
        }

        int[] digits = Tools.intToArray(octalNum);
        int decimalNum = 0;

        for(int i = 0; i < digits.length; i++){
            decimalNum += (int) (Math.pow(o.getBase(), i) * digits[i]);
        }
        return decimalNum;
    }
}

class Tools {
    public static int[] intToArray(int num){
        int[] digits = new int[(num + "").length()];

        for(int i = 0; i < digits.length; i++){
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }
}

public class TestConvert {

    public static void main(String[] args) {
        System.out.println("Enter a number in base 8 ");

        Scanner scan = new Scanner(System.in);
        Octal oct = new Octal(scan.nextInt());

        int decimal = oct.convertToDecimal();

        System.out.println(decimal);
    }
}
