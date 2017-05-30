package semester1.chapter4.section_4_6;

import semester1.chapter4.section_4_3.BasicGame;

import javax.swing.*;
import java.util.Random;

/**
 * Created by user1928 on 12/12/14.
 */
public class ex24_GuessNumberRange1Or2 extends BasicGame{

    private Random rand;
    private int itsSecretNumber;
    private int itsGuessNumber;

    public ex24_GuessNumberRange1Or2(){
        super();
        rand = new Random();
    }

    public void askUsersFirstChoice(){
        //itsSecretNumber = 1 + rand.nextInt(100);
        itsSecretNumber = 52;
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
        // if guess is two off from secret number, continue game
        //return (itsGuessNumber > itsSecretNumber - 2) || (itsGuessNumber < itsSecretNumber + 2);
        return ((itsGuessNumber - itsSecretNumber) == 2) || ((itsGuessNumber - itsSecretNumber) == -2);
    }

    public void showUpdatedStatus(){
        if(((itsGuessNumber - itsSecretNumber) == 2)|| ((itsGuessNumber - itsSecretNumber) == -2)) {
            JOptionPane.showMessageDialog(null, "Guessed 2 higher than secret value; close enough, you win");

        }else if(itsGuessNumber < itsSecretNumber + 2){
            JOptionPane.showMessageDialog(null, "Guessed 2 lower than secret value; close enough, you win");

        }else if(itsGuessNumber > itsSecretNumber){
            JOptionPane.showMessageDialog(null, "Too high");
        }else{
            JOptionPane.showMessageDialog(null, "Too low");
        }
    }

    public void showFinalStatus(){
        if(itsGuessNumber != itsSecretNumber){
            JOptionPane.showMessageDialog(null, "close enough, you win");
        }else{
            JOptionPane.showMessageDialog(null, "That was right. \nCongratulations!");
        }
    }

    public static void main(String[] args){
        ex24_GuessNumberRange1Or2 guessNumber = new ex24_GuessNumberRange1Or2();
        guessNumber.playManyGames();
    }

}


