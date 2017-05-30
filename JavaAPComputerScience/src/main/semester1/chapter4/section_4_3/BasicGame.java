package semester1.chapter4.section_4_3;

import javax.swing.JOptionPane;

/**
 * Created by user1928 on 11/21/14.
 */


public class BasicGame extends Object {

    private String itsSecretWord = "duck";
    private String itsUsersWord = "none";


    public void playManyGames(){
        playOneGame();
        while (JOptionPane.showConfirmDialog (null, "again?")
                == JOptionPane.YES_OPTION)
            playOneGame();
    }

    public void playOneGame(){
        askUsersFirstChoice();
        while (shouldContinue()){
            showUpdatedStatus();
            askUsersNextChoice();
        }
        showFinalStatus();
    }

    public void askUsersFirstChoice(){
        itsUsersWord = JOptionPane.showInputDialog
            ("Guess the secret word:");
    }

    public boolean shouldContinue(){
        return ! itsSecretWord.equals (itsUsersWord);
    }

    public void showUpdatedStatus(){
        JOptionPane.showMessageDialog (null,
            "That was wrong.  Hint:  It quacks.");
    }

    public void askUsersNextChoice(){
        askUsersFirstChoice(); // no need to write the coding again
    }

    public void showFinalStatus(){
        JOptionPane.showMessageDialog (null,
            "That was right.  \nCongratulations.");
    }


    public static void main(String[] args){

        BasicGame bg = new BasicGame();
        bg.playManyGames();
    }
}
