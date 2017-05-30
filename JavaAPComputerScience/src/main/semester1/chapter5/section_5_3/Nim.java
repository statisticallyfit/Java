package semester1.chapter5.section_5_3;
import semester1.chapter4.section_4_3.BasicGame;

import javax.swing.JOptionPane;

/**
 * Created by user1928 on 12/16/14.
 */



public class Nim extends BasicGame {

    private java.util.Random randy = new java.util.Random();
    private int itsNumLeft;
    private int itsMaxToTake;
    //Assignment 5.13: declaring final ints and using them where applicable. Illegal to declare them in constructor
    final int NUMBER21;
    final int NUMBER3;

    public Nim (){
        super(); //calls BasicGame instance and class variables
        //Assignment 5.13: initialize final ints in constructor
        NUMBER21 = 21;
        NUMBER3 = 3;
    }


    public void askUsersFirstChoice()
    { itsNumLeft = 20 + randy.nextInt (NUMBER21);
        itsMaxToTake = NUMBER3 + randy.nextInt (NUMBER3);
        askUsersNextChoice();
    }

    public void askUsersNextChoice()
    { int choice = 0;
        do
        { String s = JOptionPane.showInputDialog
                (itsNumLeft + " left. Take 1 to " + itsMaxToTake);
            if (s != null && ! s.equals (""))
                choice = Integer.parseInt (s);
        }while (choice < 1 || choice > itsMaxToTake);
        itsNumLeft = itsNumLeft - choice;
    }

    public boolean shouldContinue()
    { return itsNumLeft > itsMaxToTake;
    }

    public void showFinalStatus()
    { if (itsNumLeft == 0)
        super.showFinalStatus();
    else
        JOptionPane.showMessageDialog (null, "I take "
                + itsNumLeft + " and so I win.");
    }

    public void showUpdatedStatus()
    { int move = itsNumLeft % (itsMaxToTake + 1);
        if (move == 0)
            move = 1 + randy.nextInt (itsMaxToTake);
        itsNumLeft = itsNumLeft - move;
        JOptionPane.showMessageDialog (null, "Computer takes " + move
                + ", leaving " + itsNumLeft);
    }

    public static void main(String[] args){
        Nim nim = new Nim();

        nim.playManyGames();
    }
}