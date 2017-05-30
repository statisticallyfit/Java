package semester1.chapter4.section_4_3;

import javax.swing.JOptionPane;



// Incorrect answer key solution for shouldContinue() method ...


public class ex3_BasicGameGoose_School extends Object {

    private String itsSecretWord = "duck";
    private String itsUsersWord = "none";


    public void playManyGames() {
        playOneGame();
        while (JOptionPane.showConfirmDialog (null, "again?")
                == JOptionPane.YES_OPTION)
            playOneGame();
    }

    public void playOneGame(){
        askUsersFirstChoice();
        while (shouldContinue())
        { showUpdatedStatus();
            askUsersNextChoice();
        }
        showFinalStatus();
    }

    public void askUsersFirstChoice() {
        itsUsersWord = JOptionPane.showInputDialog
            ("Guess the secret word:");
    }

    public boolean shouldContinue(){
        if(itsSecretWord.equals(itsUsersWord)){
            return false;
        }//else
        itsSecretWord = "goose";
        return true; //this doesn't work
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
        ex3_BasicGameGoose_School bgs = new ex3_BasicGameGoose_School();
        bgs.playManyGames();
    }

}