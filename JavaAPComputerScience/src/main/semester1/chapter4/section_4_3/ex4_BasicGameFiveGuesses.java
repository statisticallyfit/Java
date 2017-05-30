package semester1.chapter4.section_4_3;

import javax.swing.JOptionPane;

/**
 * Created by user1928 on 11/22/14.
 */


public class ex4_BasicGameFiveGuesses extends Object {

    private String guessWord = null;
    private String secretWord = null;
    String[] secretWordsList = {"duck", "goose", "goose", "goose", "goose", "goose", "goose", "goose"};
    String stringCounter = "";


    public void playManyGames() {
        do {
            playOneGame();
            stringCounter = ""; //makeData value here
        } while (JOptionPane.showConfirmDialog(null, "Again?") == JOptionPane.YES_OPTION);
    }

    public void playOneGame() {
        for(int i = 0; i < secretWordsList.length; i++){
            secretWord = secretWordsList[i];

            askUsersChoice();
            stringCounter = stringCounter + "x"; //increment number of tries

            if(stringCounter.equals("xxxxx")){
                showUserIsCorrect();
                break;

            }else if(shouldContinue()) {
                showUpdatedStatus();
            }else{
                showFinalStatus();
            }
        }
    }


    public void askUsersChoice() {
        guessWord = JOptionPane.showInputDialog
                ("Guess the secret word:");
    }

    public void showUpdatedStatus() {
        JOptionPane.showMessageDialog(null,
                "That was wrong.  Hint:  It quacks.");
    }

    public void showUserIsCorrect(){
        JOptionPane.showMessageDialog(null,
                "That was the last try: Automatically correct!");
    }

    public boolean shouldContinue() {
        return !(secretWord.equals(guessWord));
    }

    /*
    public boolean shouldContinue(){
        return !(secretWord.equals(guessWord) || stringCounter.equals("xxxxx"));
    }*/

    public void showFinalStatus() {
        JOptionPane.showMessageDialog(null,
                "That was right.  \nCongratulations.");
    }


    public static void main(String[] args) {

        ex4_BasicGameFiveGuesses game = new ex4_BasicGameFiveGuesses();
        game.playManyGames();

    }
}
