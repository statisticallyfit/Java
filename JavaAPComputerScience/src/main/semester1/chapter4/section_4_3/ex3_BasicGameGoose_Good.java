package semester1.chapter4.section_4_3;

import javax.swing.JOptionPane;

/**
 * Created by user1928 on 11/21/14.
 */


public class ex3_BasicGameGoose_Good extends Object {

    private String guessWord = null;
    private String secretWord = null;
    String[] secretWordsList = {"duck", "goose", "goose"/*, "goose", "goose", "goose", "goose", "goose", "goose", "goose", "goose"*/};
    boolean continueGame = false;



    public void playManyGames() {
        do {
            playOneGame();
        } while (JOptionPane.showConfirmDialog(null, "Again?") == JOptionPane.YES_OPTION);
    }

    public void playOneGame() {
        for(int i = 0; i < secretWordsList.length; i++){
            secretWord = secretWordsList[i];

            askUsersChoice();
            if(shouldContinue()){
                showUserIsIncorrect();
            }
            else{
                showFinalStatus();
            }
        }
    }


    public void askUsersChoice() {
        guessWord = JOptionPane.showInputDialog
                ("Guess the secret word:");
    }

    public void showUserIsIncorrect() {
        JOptionPane.showMessageDialog(null,
                "That was wrong.  Hint:  It quacks.");
    }

    public boolean shouldContinue() {

        if(secretWord.equals(guessWord)){
            continueGame = false;
        }else{
            continueGame = true;
        }
        return continueGame;
    }

    public void showFinalStatus() {
        JOptionPane.showMessageDialog(null,
                "That was right.  \nCongratulations.");
    }


    public static void main(String[] args) {

        ex3_BasicGameGoose_Good game = new ex3_BasicGameGoose_Good();
        game.playManyGames();

    }
}

