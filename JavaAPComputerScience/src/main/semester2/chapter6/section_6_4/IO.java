package semester2.chapter6.section_6_4;


import javax.swing.JOptionPane;

public class IO {

    /** Display a message to the user of Jo's Repair Shop. */

    public static void say (Object message){
        JOptionPane.showMessageDialog (null, message,
            "Jo's Repair Shop", JOptionPane.PLAIN_MESSAGE);
    }


    /** Display the prompt to the user; wait for the user to enter
     *  a string of characters; return that String (not null). */

    public static String askLine (String prompt){
        String s = JOptionPane.showInputDialog (prompt);
        return s == null ?      "" : s;
    }


    /** Display the prompt to the user; wait for the user to enter
     *  a whole number; return it, or return -1 if ill-formed.  */

    public static double askDouble (String prompt){
        String s = JOptionPane.showInputDialog(prompt);
        return new StringInfo(s).parseDouble(-1);
    }


    /** Display the prompt to the user; wait for the user to enter
     *  a whole number; return it, or return -1 if ill-formed.  */

    public static int askInt (String prompt){
        String s = JOptionPane.showInputDialog (prompt);
        return (int) new StringInfo(s).parseDouble(-1);
    }


    /**** Exercise 6.9: Keep asking for int input until non-negative one is obtained*/

    public static int askNonNeg(String prompt){
        int val = askInt(prompt); //use the askInt to check for peculiarities in input
        while(val < 0){
            val = askInt(prompt);
        }
        return val;
    }



    /*** Assignment 6.13: accepts double value and rounds it down (like (floor) greatest integer function)*/
    /*No tests failed*/
    public static int floor(double doubleVal){
        return doubleVal > 0 ? (int) doubleVal : (int) doubleVal - 1;
    }

    public static void main(String[] args) {
        if(floor(3.8) != 3) {
            System.err.println("Test 1 failed");
        }

        if(floor(3.1) != 3){
            System.err.println("Test 2 failed");
        }

        if(floor(-3.2) != -4){
            System.err.println("Test 3 failed");
        }

        if(floor(-3.8) != -4){
            System.err.println("Test 4 failed");
        }

        if(floor(-100.123129234) != -101){
            System.err.println("Test 5 failed");
        }
    }
}
