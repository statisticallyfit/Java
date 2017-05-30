package semester1.chapter4.section_4_3;

/**
 * Created by user1928 on 11/25/14.
 */



import javax.swing.JOptionPane;


public class a5_BasicGameThreeGuesses extends Object {

    private String guessWord = null;
    private String secretWord = null;
    String[] secretWordsList = {"duck", "goose", "goose"};


    public void playManyGames() {
        do {
            playOneGame();
        } while (JOptionPane.showConfirmDialog(null, "GAME OVER! \nAgain?") == JOptionPane.YES_OPTION);
    }

    public void playOneGame() {
        for(int i = 0; i < secretWordsList.length; i++){
            secretWord = secretWordsList[i];

            String choice = askUsersChoice();
            while(choice.equals(secretWord)){
                showUserIsRight();
                if(JOptionPane.showConfirmDialog(null, "Again?") == JOptionPane.YES_OPTION){
                    //makeData the i and secret word
                    i = 0;
                    secretWord = secretWordsList[i];
                    choice = askUsersChoice();
                }

            }
            if(!choice.equals(secretWord)){
                showUserIsWrong();
            }
        }
    }

    public String askUsersChoice() {
        guessWord = JOptionPane.showInputDialog
                ("Guess the secret word:");
        return guessWord;
    }

    public void showUserIsWrong() {
        JOptionPane.showMessageDialog(null,
                "Wrong!  Hint:  It quacks.");
    }

    public void showUserIsRight() {
        JOptionPane.showMessageDialog(null,
                "Correct!  \nCongratulations.");
    }


    public static void main(String[] args) {

        a5_BasicGameThreeGuesses game = new a5_BasicGameThreeGuesses();
        game.playManyGames();

    }
}

