package semester1.chapter5.ProjectHangman;



import semester1.chapter4.section_4_3.BasicGame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user1928 on 12/19/14.
 */
public class HangmanGame extends BasicGame {

    private final static String[] SECRET_WORD_LIST =
            {"algae", "angel", "badge", "panda", "axiom", "bayou", "aspen", "faith", "field", "dough",
                    "avian", "sieve", "baton", "music", "beret", "brave", "dream", "cacao", "circa", "chirp",
                    "cello", "coral", "pearl", "flute", "frost", "daisy", "sword", "stone", "squid", "salve",
                    "grove", "horse", "sheep", "civet", "koala", "maggot", "lemur", "tiger", "sloth", "tapir",
                    "whale", "zebra", "vixen", "ruble", "kiosk", "pound", "olive", "thief", "lunar", "solar"};
    private static final int LENGTH = 5;

    private final int MAX_TRIES = 10;
    private final int MAX_GOOD_GUESSES = 5;

    private String itsPastGuesses = "";
    private String itsSecretWord = null;
    private int itsTries = 0;
    private ArrayList<String> itsHangmanBank = new ArrayList<String>();
    private ArrayList<String> itsLetters = new ArrayList<String>();
    private int itsNumOfGoodGuesses = 0;
    private Random rand = new Random();

    public void playManyGames() {
        do {
            playOneGame();
            refresh();
        } while (JOptionPane.showConfirmDialog(null, "Play again?") == JOptionPane.YES_OPTION);
    }




    public void playOneGame() {


        createSecretWord();

        while (itsTries != MAX_TRIES && itsNumOfGoodGuesses != MAX_GOOD_GUESSES) {
            compare(getInput().toLowerCase());
        }

        if ((itsTries == MAX_TRIES && itsNumOfGoodGuesses == MAX_GOOD_GUESSES) || itsNumOfGoodGuesses == MAX_GOOD_GUESSES) {
            showSuccessMessage();
        }
        else if (itsTries == MAX_TRIES) {
            showHangMessage();
        }
    }

    public void createSecretWord() {

        int index = 1 + rand.nextInt(50); //create random index
        itsSecretWord = SECRET_WORD_LIST[index];
        initialize(itsSecretWord);
    }


    public void initialize(String secretWord) {
        //add secret word itsLetters to arraylist
        itsLetters.add(0, secretWord.substring(0, 1));
        itsLetters.add(1, secretWord.substring(1, 2));
        itsLetters.add(2, secretWord.substring(2, 3));
        itsLetters.add(3, secretWord.substring(3, 4));
        itsLetters.add(4, secretWord.substring(4, 5));

        //initialize hangman with blank spaces: "_ _ _ _ _ "
        itsHangmanBank.add(0, "_ ");
        itsHangmanBank.add(1, "_ ");
        itsHangmanBank.add(2, "_ ");
        itsHangmanBank.add(3, "_ ");
        itsHangmanBank.add(4, "_ ");
    }


    public String getInput() {
        itsTries++;
        return JOptionPane.showInputDialog("Guess a letter of the secret five-letter word: ");
    }


    public void showUpdatedStatus(int cue) {
        String v0, v1, v2, v3, v4;

        if (cue == 0) {
            JOptionPane.showMessageDialog(null, "That's right!\n\n Tries left: " + (MAX_TRIES - itsTries));
        } else if (cue == -1) {
            JOptionPane.showMessageDialog(null, "Nope!\n\n Tries left: " + (MAX_TRIES - itsTries));
        }

        v0 = itsHangmanBank.get(0);
        v1 = itsHangmanBank.get(1);
        v2 = itsHangmanBank.get(2);
        v3 = itsHangmanBank.get(3);
        v4 = itsHangmanBank.get(4);

        JOptionPane.showMessageDialog(null, "This is what you guessed so far:\n\n\n " + v0 +
                "    " + v1 + "    " + v2 + "    " + v3 + "    " + v4 + "\n\nTries left: " + (MAX_TRIES - itsTries));
    }

    public void showSuccessMessage() {
        JOptionPane.showMessageDialog(null, "YAY, you guessed the word!\n\n" + "Secret word is:\n\n " + itsSecretWord + "\n\nTries left: " + (MAX_TRIES - itsTries));
    }

    public void showHangMessage() {
        JOptionPane.showMessageDialog(null, "GAME OVER!\n\n\t\t The man hangs..." + "\n\nTries left: " + (MAX_TRIES - itsTries));
    }


    public void compare(String letter) {

        int count = 0;

        if (itsPastGuesses.contains(letter)) {
            JOptionPane.showMessageDialog(null, "You already guessed letter   " + " '  " + letter + "  '");
        } else {
            itsPastGuesses += letter;

            for (int i = 0; i < LENGTH /*always is 5*/; i++) {
                if (itsLetters.get(i).equals(letter)) {
                    itsHangmanBank.set(i, letter);

                    count++;
                    itsNumOfGoodGuesses++;
                }
            }

            if (count >= 1) { //then there was at least one right letter
                showUpdatedStatus(0);
            } else {
                showUpdatedStatus(-1);
            }
        }
    }

    public void refresh() {
        itsHangmanBank.clear();
        itsLetters.clear();
        itsNumOfGoodGuesses = 0;
        itsTries = 0;
        itsSecretWord = null;
    }


    public static void main(String[] args) {
        HangmanGame hang = new HangmanGame();
        hang.playManyGames();
    }
}
