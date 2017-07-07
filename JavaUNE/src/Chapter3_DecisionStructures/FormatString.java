package Chapter3_DecisionStructures;

/**
 *
 */
public class FormatString {

    public static void main(String[] args) {

        //note formula: %[flags][width][.precision]conversionCharacter

        System.out.println("-------- Normal statements: "); //------------------------------------
        System.out.printf("Orangeish bananas");
        System.out.printf("Green apples are crispy\n");


        System.out.println("\n-------- Floating point format specifiers: "); //---------------------
        System.out.printf("The temperatures are %f and %f degrees\n", 72.5, 83.7); // %d works for double
        System.out.printf("The temperatures are %f and %f degrees\n", 72.5F, 83.7F); // %d works for float

        // note: precision
        System.out.printf("The temperature is %.2f degrees\n", 78.428234);
        System.out.printf("%.1f %.2f %.3f\n", 123.45678, 123.45678, 123.45678);

        //note: width
        // right justify: makes width so that the number plus space i front 20 spaces
        System.out.printf("The number is:%20f\n", 12345.6789);
        // too small width so gets enlarged
        System.out.printf("The number is:%2f\n", 12345.6789);

        //note: precision  and width
        System.out.printf("The Number is:%12.2f\n", 12345.6789);
        double num1 = 127.899;
        double num2 = 3465.148;
        double num3 = 3.776;
        double num4 = 264.821;
        double num5 = 88.081;
        double num6 = 1799.999;
        System.out.printf("%8.2f\n", num1);
        System.out.printf("%8.2f\n", num2);
        System.out.printf("%8.2f\n", num3);
        System.out.printf("%8.2f\n", num4);
        System.out.printf("%8.2f\n", num5);
        System.out.printf("%8.2f\n", num6);

        // note: flags
        //flag comma separator
        System.out.printf("The price is $%,f\n", 1234567.89);
        System.out.printf("The price is $%,.2f\n", 1234567.89);
        System.out.printf("The price is $%,20.2f\n", 1234567.89);
        // flag leading zeroes
        System.out.printf("The leading zero number is:%08.1f\n", 123.456);
        // flag left justifying
        System.out.printf("%-8d%-8d\n", 123, 12);
        System.out.printf("%-8d%-8d\n", 45678, 456);
        System.out.printf("%-6d%-8d\n", 1234567, 1234); //  first has not been overwritten

        System.out.printf("\nCLOCK flag zero and width: %02d:%02d:%02d\n", 4, 53, 9);


        System.out.println("\n-------- Integer format specifiers: "); //---------------
        System.out.printf("Sheila worked %d hours this week and %d hours last week\n", 40, 75);


        System.out.println("\n-------- String format specifiers: "); //---------------
        //note: width amount: right justify
        String output = String.format("%10s%10s\n", "George", "Franklin");
        System.out.print(output);
        System.out.printf("%10s%10s\n", "Jay", "Ozzy");
        System.out.printf("%10s%10s\n", "Carmine", "Dee");
        //note: flags: left justify
        System.out.printf("The names are:%-10s%-10s\n", "George", "Franklin"); //note: not overwritten.
        System.out.printf("%-10s%-10s\n", "George", "Franklin");
        System.out.printf("%-10s%-10s\n", "Jay", "Ozzy");
        System.out.printf("%-10s%-10s\n", "Carmine", "Dee");

        //NOTE: String.format() works exactly like printf except it returns, not prints


    }
}
