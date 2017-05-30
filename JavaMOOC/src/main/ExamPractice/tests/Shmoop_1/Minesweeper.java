package main.ExamPractice.tests.Shmoop_1;


public class Minesweeper {

    private boolean[][] mines;
    private int[][] grid;

    public Minesweeper(boolean[][] givenMines){
        mines = givenMines;
        grid = new int[mines.length][mines[0].length];
    }

    public void updateGrid() {
        int adjacentMines = 0;

        for (int row = 1; row < mines.length - 1; row++) {
            for (int col = 1; col < mines[0].length - 1; col++) {

                if (mines[row][col])
                    grid[row][col] = 9;
                else {
                    for (int i = -1; i <= 1; i++)
                        for (int j =- 1; j <= 1; j++)
                            if(mines[row + i][col + j])
                                adjacentMines++;
                    grid[row][col] = adjacentMines;
                    adjacentMines = 0;
                }
            }
        }
    }

    public String toString(){
        String s = "Mines:\n";

        for(boolean[] rowArray : mines){
            s += "\n";
            for(boolean colValue : rowArray){
                if(colValue)
                    s += "T ";
                else
                    s += "f ";
            }
        }

        s += "\n\nGrid:\n";
        for(int[] rowArray : grid){
            s += "\n";
            for(int colValue : rowArray){
                s += colValue + " ";
            }
        }
        return s;
    }
}

class TestMinesweeper{

    public static void main(String[] args) {

        boolean T = true;
        boolean F = false;
        boolean[][] mines = new boolean[][] {
                {F, F, F, F, F},
                {F, T, F, F, F},
                {F, F, F, F, F},
                {F, F, T, F, F},
                {F, F, F, F, F}
        };

        Minesweeper sweep = new Minesweeper(mines);

        sweep.updateGrid();
        System.out.println(sweep);
    }
}
