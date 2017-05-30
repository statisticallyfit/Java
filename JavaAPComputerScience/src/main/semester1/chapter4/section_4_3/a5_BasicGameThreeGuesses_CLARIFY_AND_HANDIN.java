package semester1.chapter4.section_4_3;

import javax.swing.JOptionPane;

/**
 * Created by user1928 on 11/21/14.
 */


public class a5_BasicGameThreeGuesses_CLARIFY_AND_HANDIN extends Object {

    private String guessWord = null;
    private String secretWord = "duck";
    int numberOfGuesses = 0;
    //String[] secretWordsList = {"duck", "duck", "duck"}; //three guesses only


    public void playManyGames(){
        do{
            numberOfGuesses = 0; //makeData
            playOneGame();
        }while(JOptionPane.showConfirmDialog(null, "Again?") == JOptionPane.YES_OPTION);
    }


    public void playOneGame() {
        while(numberOfGuesses < 3){
            askUsersChoice();
            numberOfGuesses++;

            if(shouldContinue()) {
                showUpdatedStatus();
            }else{ //if got it right
                showFinalStatus();
            }
        }

        askUnsolvableQuestion();
    }

    public void askUsersChoice() {
        guessWord = JOptionPane.showInputDialog
                ("Guess the secret word:");
    }

    public void askUnsolvableQuestion(){

        JOptionPane.showMessageDialog(null, "WARNING: 3 tries over, impossible to get it right");

        while(JOptionPane.showConfirmDialog(null, "Again?") == JOptionPane.YES_OPTION){
            askUsersChoice();
            showUpdatedStatus();
        }
    }

    public void showUpdatedStatus() {
        JOptionPane.showMessageDialog(null,
                "That was wrong.  Hint:  It quacks.");
    }

    public boolean shouldContinue() {
        return !(secretWord.equals(guessWord));
    }


    public void showFinalStatus() {
        JOptionPane.showMessageDialog(null,
                "That was right.  \nCongratulations.");
    }


    public static void main(String[] args) {

        a5_BasicGameThreeGuesses_CLARIFY_AND_HANDIN game = new a5_BasicGameThreeGuesses_CLARIFY_AND_HANDIN();
        game.playManyGames();

    }
}

