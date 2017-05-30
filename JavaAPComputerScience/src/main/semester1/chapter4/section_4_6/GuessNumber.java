package semester1.chapter4.section_4_6;
import semester1.chapter4.section_4_3.BasicGame;

import javax.swing.JOptionPane;
import java.util.Random;
/**
 * Created by user1928 on 12/12/14.
 */
public class GuessNumber extends BasicGame{

    private Random rand;
    private int itsSecretNumber;
    private int itsGuessNumber;

    public GuessNumber(){
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
            JOptionPane.showMessageDialog(null, "Too high");
        }else{
            JOptionPane.showMessageDialog(null, "Too low");
        }
    }

    public static void main(String[] args){
        GuessNumber bg = new GuessNumber();
        bg.playManyGames();
    }

    /*Inherited from BasicGame:
    * playManyGames
    * playOneGame
    * showFinalStatus
     */
}
