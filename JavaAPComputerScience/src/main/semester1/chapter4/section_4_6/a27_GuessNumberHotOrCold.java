package semester1.chapter4.section_4_6;

import semester1.chapter4.section_4_3.BasicGame;

import javax.swing.*;
import java.util.Random;

/**
 * Created by user1928 on 12/12/14.
 */
public class a27_GuessNumberHotOrCold extends BasicGame{

    private Random rand;
    private int itsSecretNumber;
    private int itsGuessNumber;

    public a27_GuessNumberHotOrCold(){
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

            if ((itsGuessNumber - itsSecretNumber) <= 2) {
                JOptionPane.showMessageDialog(null, "Hot... within 2 of the right answer");

            }else if((itsGuessNumber - itsSecretNumber) <= 6) {
                JOptionPane.showMessageDialog(null, "Warm...within 6 of the right answer");

            }else{
                JOptionPane.showMessageDialog(null, "Too high");
            }


        }else if(itsGuessNumber < itsSecretNumber){

            if ((itsSecretNumber - itsGuessNumber) <= 2) {
                JOptionPane.showMessageDialog(null, "Hot... within 2 of the right answer");

            }else if((itsSecretNumber - itsGuessNumber) <= 6){
                JOptionPane.showMessageDialog(null, "Warm...within 6 of the right answer");

            }else{
                JOptionPane.showMessageDialog(null, "Too low");
            }
        }
    }
}
