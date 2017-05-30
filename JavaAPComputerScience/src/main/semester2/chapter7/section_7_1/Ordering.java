package semester2.chapter7.section_7_1;


public class Ordering {
    /** Ask the user for three Workers.  Print the one that is
     *  last in alphabetical order of names. */

    public static void main (String[ ] args) {
        System.out.println("Reading 3 workers, printing the last.");

        Buffin infile = new Buffin ("C:\\D\\tmp\\workers.txt");
        
        Worker first  = new Worker (infile.readLine());
        Worker second = new Worker (infile.readLine());
        Worker third  = new Worker (infile.readLine());

        if (third.getName() != null) {  // if insufficient input
            System.out.println("The alphabetically last is: " + CompOp.lastOne(first, second, third));
        }
        System.out.println("The lowest pay person is: " + CompOp.lowestWeeklyPay(first, second, third));
        System.exit (0);

    }
}
