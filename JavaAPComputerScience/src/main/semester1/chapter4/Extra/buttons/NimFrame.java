/*
package chapter4;

*/
/**
 * Created by user1928 on 12/13/14.
 *//*

public class NimFrame extends BabyFrame
                      extends Nim// based on Listing 4.8

{
    private java.util.Random randy = new java.util.Random();
    private int itsNumLeft;
    private int itsMaxToTake;
    private javax.swing.JLabel itsPrompt
            = new javax.swing.JLabel ("Take 1 to 00");
    private BabyTextArea itsOutput = new BabyTextArea (6, 42);

    public NimFrame (String title)
    { super (title);
        setSize (500, 250);
        add (new BabyButton_1 ("start new game"));
        add (itsPrompt);
        add (new BabyField_1 (4));
        add (itsOutput);
        setVisible (true);  // otherwise the frame will not appear
        buttonAction_1(); // start the software by starting a game
    }

    */
/** Initialize 2 variables and wait for user's first choice. *//*


    public void buttonAction_1()
    { itsNumLeft = 20 + randy.nextInt (21);
        itsMaxToTake = 3 + randy.nextInt (3);
        itsOutput.say ("We start with " + itsNumLeft);
        itsPrompt.setText ("Take 1 to " + itsMaxToTake);
    }

    */
/** This method executes when the user types a number in the
     textfield. If it is legal, the computer makes its move. *//*


    public void fieldAction_1 (BabyField_1 source)
    { int choice = 0;
        String s = source.getText();
        if (s != null && ! s.equals (""))
            choice = Integer.parseInt (s);
        if (choice >= 1 && choice <= itsMaxToTake)
        { itsNumLeft = itsNumLeft - choice;
            if (shouldContinue())
                showUpdatedStatus();
            else
                showFinalStatus();
        }
    }

    // showUpdatedStatus, showFinalStatus, and shouldContinue
    // are the same as in Listing 4.8, except "itsOutput.say("
    // replaces "JOptionPane.showMessageDialog(null,".
}


class NimMain {
    public static void main (String[ ] args){
        new NimFrame ("The Game of Nim");
    }
}
*/
