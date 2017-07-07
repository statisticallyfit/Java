package Chapter4_LoopsFiles.workshop3;

import java.text.DecimalFormat;

/**
 * NOTE: remember that "=" sign is right-associative!
 *
 That is, suppose that  w  is 1,  x  is 2,  y  is 4, and  z  is 8. If  =  is left-associative, then when

 w = x = y = z;
 is executed, the actions will occur in this order:

 w  will be assigned the value of  x  (2);
 x  will be assigned the value of  y  (4); and
 y  will be assigned the value of  z  (8).
 so that 2, 4, 8 and 8 will appear when the variable’s values are displayed.

 On the other hand, if  =  is right-associative, then when

 w = x = y = z;
 is executed, the actions will occur in this order:

 y  will be assigned the value of  z  (8);
 x  will be assigned the value of  y  (8); and
 w  will be assigned the value of  x  (8).
 so that 8, 8, 8 and 8 will be displayed.
 *
 *
 */

public class Express3{

    public static void main(String[] args)
    {
        int a, b, c, d;
        a = 1;
        b = 2;
        c = 4;
        d = 8;

        a = b = c = d;

        System.out.print("Verify Assignment Associativity of ");
        System.out.println("the expression: a = b = c = d");
        System.out.printf( "w = %d, x = %d, y = %d z = %d\n", a, b, c, d);


        //------------------------------------------------------------------
        System.out.println("\n----------------------------------------------");
        System.out.println("Testing this: \nint w = 8, x = 4, y = 2, z = 1; " +
                "\nw -= x /= y *= z += 1;");

        int w = 8, x = 4, y = 2, z = 1; w -= x /= y *= z += 1;
        System.out.println(String.format("\nw = %d, x = %d, y = %d, z = %d", w,x,y,z));
        //note so these are right-associative.

    }
}
