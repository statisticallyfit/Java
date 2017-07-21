package Chapter6_FirstClasses.exercises;

import Chapter6_FirstClasses.Die;

import java.util.Scanner;


/**
 *
 */

class Player {
    private int cumulativePoints;

    // default constructor initializes cumulativePoints to 0.

    public void addPoints(int numToAdd){
        cumulativePoints += numToAdd;
    }

    public int getCumulativePoints(){
        return cumulativePoints;
    }
}

class HumanPlayer extends Player {

}

class ComputerPlayer extends Player {

}

public class GameTwentyOne {

    private Die die1;
    private Die die2;
    private HumanPlayer human;
    private ComputerPlayer computer;

    public GameTwentyOne(){
        this.die1 = new Die();
        this.die2 = new Die();
        this.human = new HumanPlayer();
        this.computer = new ComputerPlayer();
    }


    // Asks the user if we can roll the dice (play this round)
    public boolean canRoll(){

        char answer = 'x';
        do {
            System.out.print("\nDo you want the dice to be rolled? (y/n): ");
            Scanner scan = new Scanner(System.in);
            String tempAnswer = scan.nextLine().toLowerCase();

            if(tempAnswer.length() != 0){
                answer = tempAnswer.charAt(0);
            }
        } while(answer != 'y' && answer != 'n');

        return answer == 'y';
    }

    // Plays one round of the game - rolls dice, tallies up the points for each.
    public void playOneRound(){
        die1.roll();
        die2.roll();

        // totals are recorded for each player
        human.addPoints(die1.getDieValue());
        computer.addPoints(die2.getDieValue());

        displayCurrentScores();
    }

    public void displayCurrentScores(){
        System.out.println("Total for human: " + human.getCumulativePoints());
        System.out.println("Total for computer: " + computer.getCumulativePoints());
    }

    // Game is over if either player won more than 21 points.
    public boolean isOver(){
        return human.getCumulativePoints() >= 21 || computer.getCumulativePoints() >= 21;
    }



    public void declareWinner(){
        int humanPoints = human.getCumulativePoints();
        int compPoints = computer.getCumulativePoints();

        System.out.println("\n----------------------------------------------------------");

        if(humanPoints > compPoints){

            System.out.println("The human won!");
            System.out.println("Human Points = " + humanPoints);
            System.out.println("Computer Points = " + compPoints);
        } else if (humanPoints < compPoints){

            System.out.println("The Computer won!");
            System.out.println("Human Points = " + humanPoints);
            System.out.println("Computer Points = " + compPoints);
        } else { //tie

            System.out.println("It's a tie!");
            System.out.println("Human Points = " + humanPoints);
            System.out.println("Computer Points = " + compPoints);
        }
    }


    public static void main(String[] args) {
        //Playing the game:
        GameTwentyOne game = new GameTwentyOne();

        while(!game.isOver() && game.canRoll()){
            game.playOneRound();
        }

        game.declareWinner();
    }
}
