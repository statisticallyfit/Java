package semester1.chapter4.ProjectGuessThatNumber;

import semester1.chapter4.section_4_3.BasicGame;
import javax.swing.JOptionPane;

/**
 * Created by user1928 on 12/13/14.
 */
public class GuessThatNumber extends BasicGame {

    //should all be static?
    private int itsUserSuggestion = 0;
    private int itsComputersGuessNum = 0;
    private int itsUpperBoundGuess = 100;
    private int itsLowerBoundGuess = 1;
    private String itsFeedbackToLowercase = null;
    private int itsNumTimesGuessWasNinetyNine = 0;
    private int itsNumTimesGuessWasTwo = 0;
    private int itsNumTries = 0;


    public void playManyGames(){

        do{

            do{
                playOneGame();

            }while( !itsFeedbackToLowercase.equals("correct"));

            refreshTheVariables();

        }while(JOptionPane.showConfirmDialog(null, "Play again?") == JOptionPane.YES_OPTION);
    }

    public void playOneGame(){

        JOptionPane.showMessageDialog(null, "Guess a number between 1 and 100 inclusive. Remember it!");

        do{
            int guess = guessNumberAndSetBounds(itsUserSuggestion);
            itsUserSuggestion = askUserSuggestion(guess);

        }while( !itsFeedbackToLowercase.equals("correct"));
    }

    public int askUserSuggestion(int guess){

        String feedback = JOptionPane.showInputDialog("Is the guess " + guess + " too high, too low, or correct?");
        itsFeedbackToLowercase = feedback.toLowerCase();  //convert all letters to lowercase to be able to compare


        if(itsFeedbackToLowercase.equals("too high")){
            itsUserSuggestion = -1;

        }else if(itsFeedbackToLowercase.equals("too low")) {
            itsUserSuggestion = 1;

        }else if(itsFeedbackToLowercase.equals("correct")) {
            showFinalStatus();
        }

        return itsUserSuggestion;
    }


    public int guessNumberAndSetBounds(int userSuggestion){


        if(userSuggestion == -1){
            itsUpperBoundGuess = itsComputersGuessNum;

        } else if(userSuggestion == 1){
            itsLowerBoundGuess = itsComputersGuessNum;
        }//else if userSuggestion == 0, guess will be calculated as 50

        itsComputersGuessNum = (itsUpperBoundGuess + itsLowerBoundGuess)/2;
        itsNumTries++;


        // tinkering needed if the guess is at either upper or lower boundary
        if(itsComputersGuessNum == 99){
            itsNumTimesGuessWasNinetyNine++;
            if(itsNumTimesGuessWasNinetyNine == 2){
                itsComputersGuessNum = 100;
            }
        }else if(itsComputersGuessNum == 2){
            itsNumTimesGuessWasTwo++;
            if(itsNumTimesGuessWasTwo == 2){
                itsComputersGuessNum = 1;
            }
        }

        return itsComputersGuessNum;
    }


    public void showFinalStatus(){
        JOptionPane.showMessageDialog(null, "Yay, computer guessed exactly right! " +
                "\nSecret number is: " + itsComputersGuessNum +
                "\nTries used up: " + itsNumTries);
    }

    public void refreshTheVariables(){
        itsUserSuggestion = 0;
        itsComputersGuessNum = 0;
        itsUpperBoundGuess = 100;
        itsLowerBoundGuess = 1;
        itsFeedbackToLowercase = null;
        itsNumTimesGuessWasNinetyNine = 0;
        itsNumTimesGuessWasTwo = 0;
        itsNumTries = 0;
    }

    public static void main(String[] args) {
        GuessThatNumber guesser = new GuessThatNumber();
        guesser.playManyGames();
    }
}
