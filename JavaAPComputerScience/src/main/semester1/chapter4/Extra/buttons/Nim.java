package semester1.chapter4.Extra.buttons;

import semester1.chapter4.section_4_3.BasicGame;
import javax.swing.JOptionPane;

/**
 * Created by user1928 on 12/13/14.
 */
public class Nim extends BasicGame
{
    private java.util.Random randy = new java.util.Random();
    private int itsNumLeft;
    private int itsMaxToTake;


    public void askUsersFirstChoice()
    { itsNumLeft = 20 + randy.nextInt (21);
        itsMaxToTake = 3 + randy.nextInt (3);
        askUsersNextChoice();
    } //=======================

    public void askUsersNextChoice()
    { int choice = 0;
        do
        { String s = JOptionPane.showInputDialog
                (itsNumLeft + " left. Take 1 to " + itsMaxToTake);
            if (s != null && ! s.equals (""))
                choice = Integer.parseInt (s);
        }while (choice < 1 || choice > itsMaxToTake);
        itsNumLeft = itsNumLeft - choice;
    } //=======================

    public boolean shouldContinue()
    { return itsNumLeft > itsMaxToTake;
    }  //======================

    public void showFinalStatus()
    { if (itsNumLeft == 0)
        super.showFinalStatus();
    else
        JOptionPane.showMessageDialog (null, "I take "
                + itsNumLeft + " and so I win.");
    } //=======================

    public void showUpdatedStatus()
    { int move = itsNumLeft % (itsMaxToTake + 1);
        if (move == 0)
            move = 1 + randy.nextInt (itsMaxToTake);
        itsNumLeft = itsNumLeft - move;
        JOptionPane.showMessageDialog (null, "I take " + move
                + ", leaving " + itsNumLeft);
    } //=======================
}
