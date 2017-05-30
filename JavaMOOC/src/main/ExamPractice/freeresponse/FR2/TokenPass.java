package main.ExamPractice.freeresponse.FR2;


import com.sun.javafx.fxml.expression.Expression;

public class TokenPass {

    private int[] board;
    private int currentPlayer;

    /* part a */
    public TokenPass(int playerCount){
        board = new int[playerCount];

        for(int i = 0; i < board.length; i++)
            board[i] = (int)(Math.random() * 10) + 1;
        currentPlayer = (int)(Math.random() * playerCount);
    }

    /* part b */
    /*public void distributeCurrentPlayerTokens(int[] listOfTokens, int cPlayer){
        int numTokens = listOfTokens[cPlayer];
        listOfTokens[cPlayer] = 0;

        for(int i = cPlayer + 1; numTokens > 0; i++){
            if(i >= listOfTokens.length)
                i = 0;
            listOfTokens[i]++;
            numTokens--;
        }
    }*/

    public void distributeCurrentPlayerTokens(){
        /*int numTokens = board[currentPlayer];
        board[currentPlayer] = 0;

        for(int i = currentPlayer + 1; numTokens > 0; i++){
            if(i >= board.length)
                i = 0;
            board[i]++;
            numTokens--;
        }*/

        //canonical solution
        int nextPlayer = currentPlayer;
        int numTokens = board[currentPlayer];
        board[currentPlayer] = 0;

        while(numTokens > 0){
            nextPlayer = (nextPlayer + 1) % board.length;
            board[nextPlayer]++;
            numTokens--;
        }

    }

    public String toString(){
        String s = "Current player is at position: " + currentPlayer
                + "\n" + "Number of tokens: " + board[currentPlayer] + "\n";
        for(int i = 0; i < board.length; i++)
            s += "pos: " + i + "    numOfTokens: " + board[i] + "\n";
        return s;
    }
}

class TestTokenPass{

    public static void main(String[] args) {
        TokenPass tokPass = new TokenPass(5);
        System.out.println(tokPass);
        tokPass.distributeCurrentPlayerTokens();
        //tokPass.distributeCurrentPlayerTokens(new int[]{5, 6, 6, 4, 5}, 0);
        System.out.println(tokPass);

    }
}
