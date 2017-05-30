package main.ExamPractice.tests.pdf_2009.FR;


import java.util.ArrayList;

class NumberTile{
    private int left;
    private int top;
    private int right;
    private int bottom;

    public NumberTile(int l, int t, int r, int b){
        left = l;
        top = t;
        right = r;
        bottom = b;
    }

    /* Rotate tile 90 degrees clockwise */
    public void rotate(){
        int[] tileNumbers = new int[]{left, top, right, bottom};
        int saved = bottom;

        for(int i = tileNumbers.length - 1; i >= 1; i--)
            tileNumbers[i] = tileNumbers[i - 1];
        tileNumbers[0] = saved;

        left = tileNumbers[0];
        top = tileNumbers[1];
        right = tileNumbers[2];
        bottom = tileNumbers[3];
    }

    public int getLeft(){
        return left;
    }

    public int getRight(){
        return right;
    }
}

public class TileGame {

    private ArrayList<NumberTile> board;

    public TileGame(ArrayList<NumberTile> theTiles){
        board = theTiles;
    }

    public int getIndexForFit(NumberTile tile){
        if(board.size() == 0)
            return 0;

        int left = tile.getLeft();
        int right = tile.getRight();
        int lastIndex = board.size() - 1;

        if(board.get(0).getLeft() == right)
            return 0;

        for(int i = 0; i < board.size() - 1; i++){
            if(board.get(i).getRight() == left && board.get(i + 1).getLeft() == right)
                return i + 1;
        }

        if(board.get(lastIndex).getRight() == left)
            return board.size() - 1;
        return -1;
    }

    public boolean insertTile(NumberTile tile){
        int numRotations = 0;
        while(numRotations <= 3){
            if(getIndexForFit(tile) != -1){
                board.add(getIndexForFit(tile), tile);
                return true;
            }
            tile.rotate();
            numRotations++;
        }
        return false;
    }
}

class TestTileGame{

    public static void main(String[] args) {
        NumberTile t1 = new NumberTile(4, 4, 3, 7);
        NumberTile t2 = new NumberTile(3, 6, 4, 3);
        NumberTile t3 = new NumberTile(4, 1, 2, 3);
        NumberTile t4 = new NumberTile(2, 3, 3, 5);
        NumberTile t5 = new NumberTile(2, 5, 9, 2);
        NumberTile put1 = new NumberTile(2, 4, 2, 9);
        NumberTile put2 = new NumberTile(8, 4, 2, 9);
        NumberTile putFirst = new NumberTile(9, 3, 4, 5);
        NumberTile putLast = new NumberTile(9, 3, 3, 5);
        NumberTile toRotate = new NumberTile(12, 9, 10, 11);

        ArrayList<NumberTile> tiles = new ArrayList<NumberTile>();
        tiles.add(t1);
        tiles.add(t2);
        tiles.add(t3);
        tiles.add(t4);
        tiles.add(t5);

        TileGame game = new TileGame(tiles);

        /*if(game.getIndexForFit(put1) != 3)
            System.err.println("Test 1 failed");
        if(game.getIndexForFit(put2) != -1)
            System.err.println("Test 2 failed");
        if(game.getIndexForFit(putFirst) != 0)
            System.err.println("Test put at first failed");
        if(game.getIndexForFit(putLast) != 5)
            System.err.println("Test put at last failed");*/

        if(!game.insertTile(toRotate))
            System.err.println("Test 1 failed");

    }
}
