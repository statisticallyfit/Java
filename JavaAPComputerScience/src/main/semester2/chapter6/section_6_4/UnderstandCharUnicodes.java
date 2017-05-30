package semester2.chapter6.section_6_4;


public class UnderstandCharUnicodes {

    public static void main(String[] args) {
        char x = 'A';
        System.out.println(x);
        x = (char) (x + 1);
        System.out.println(x);
        System.out.println("Subtraction: " + (x - 'C')); //basically subtracting 66 - 67 = -1

        char y = 'B';
        System.out.println(y + 1);
        System.out.println((char)(y + 1));

        char z = (char)0;
        System.out.println(z);

        int a = 'A';
        System.out.println("implicit char to int promotion: " + a);
    }
}
