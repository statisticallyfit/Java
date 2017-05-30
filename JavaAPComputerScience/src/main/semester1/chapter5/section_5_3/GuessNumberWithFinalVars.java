package semester1.chapter5.section_5_3;

/**
 * Created by user1928 on 12/16/14.
 */
import semester1.chapter4.section_4_3.BasicGame;

import javax.swing.JOptionPane;
import java.util.Random;

public class GuessNumberWithFinalVars extends BasicGame {
    private java.util.Random randy;
    private int itsSecretNumber;
    private int itsUsersNumber;
    //Assignment 5.12: LOWER and UPPER are final, therefore constants.
    private static final int LOWER = 1;
    private static final int UPPER = 100;


    public GuessNumberWithFinalVars()
    { super();
        randy = new Random();
    } //=======================

    public void askUsersFirstChoice()
    { itsSecretNumber = LOWER + randy.nextInt (UPPER);
        askUsersNextChoice();
    } //=======================

    public void askUsersNextChoice()
    { String s = JOptionPane.showInputDialog
            ("Guess my number from 1 to 100:");
        if (s != null && ! s.equals (""))
            itsUsersNumber = Integer.parseInt (s);
        else
            itsUsersNumber = -1;  // just to have a value there
    }  //======================

    public boolean shouldContinue()
    { return itsUsersNumber != itsSecretNumber;
    }  //======================

    public void showUpdatedStatus()
    { if (itsUsersNumber > itsSecretNumber)
        JOptionPane.showMessageDialog (null, "Too high");
    else
        JOptionPane.showMessageDialog (null, "Too low");
    } //=======================

    // inherited from BasicGame:
    //    playManyGames
    //    playOneGame
    //    showFinalStatus

    public static void main(String[] args){
        GuessNumberWithFinalVars guesser = new GuessNumberWithFinalVars();

        guesser.playManyGames();
    }
}