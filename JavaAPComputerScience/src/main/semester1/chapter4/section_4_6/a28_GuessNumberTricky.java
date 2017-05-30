package semester1.chapter4.section_4_6;

import semester1.chapter4.section_4_3.BasicGame;
import javax.swing.*;
import java.util.Random;

/**
 * Created by user1928 on 12/12/14.
 */
public class a28_GuessNumberTricky extends BasicGame{

    private Random rand;
    private int itsSecretNumber;
    private int itsGuessNumber;

    public a28_GuessNumberTricky(){
        super();
        rand = new Random();
    }

    public void askUsersFirstChoice(){
        itsSecretNumber = 1 + rand.nextInt(100);
        askUsersNextChoice();
    }

    public void askUsersNextChoice(){
        String guessAsString = JOptionPane.showInputDialog
                ("Guess a number from 1 to 100: ");
        // order is important here: null must come first to possibly short circuit testing of empty string
        if(guessAsString != null && !guessAsString.equals("")){
            itsGuessNumber = Integer.parseInt(guessAsString);
        }else{
            itsGuessNumber = -1; //for the sake of having a value here
        }
    }

    public boolean shouldContinue(){
        return itsGuessNumber != itsSecretNumber;
    }

    public void showUpdatedStatus(){
        if(itsGuessNumber > itsSecretNumber){
            //prepare to trick
            if(rand.nextInt(3) == 0){ // this means a 1/3 chance to trick (0, 1, 2)
                JOptionPane.showMessageDialog(null, "Too low (trick showUpdatedStatus)");
            }else{
                JOptionPane.showMessageDialog(null, "Too high");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Too low");
        }
    }
}
