package main.ExamPractice.tests.BePrepared_4;


import java.util.ArrayList;


public class Location {

    private int row;
    private int col;

    public Location(int rowLoc, int colLoc){
        row = rowLoc;
        col = colLoc;
    }

    public int getRow(){ return row; }
    public int getCol() { return col; }
}

class FloorPlan {
    private int[][] room;


    public FloorPlan(int[][] theRoom /*int numRows, int numCols*/){
        room = theRoom;
    }

    private boolean isEmptyRegion(int top, int bottom, int left, int right){
        for(int r = top; r <= bottom; r++)
            for(int c = left; c <= right; c++)
                if(room[r][c] == 1)
                    return false;
        return true;
    }

    public boolean fits(int width, int height, Location uLCorner){

        /*int botBorder = uLCorner.getRow() + height;
        int topBorder = uLCorner.getRow() - 1;
        int leftBorder = uLCorner.getCol() - 1;
        int rightBorder = uLCorner.getCol() + width;

        if(botBorder >= room.length)
            botBorder = room.length - 1;
        if(topBorder < 0)
            topBorder = 0;
        if(leftBorder < 0)
            leftBorder = 0;
        if(rightBorder >= room[0].length)
            rightBorder = room[0].length - 1;*/

        int top = uLCorner.getRow();
        int bot = top + height - 1;
        int left = uLCorner.getCol();
        int right = left + width - 1;

        if(top < 0)
            return false;
        else if(top > 0)
            top--;

        if(bot >= room.length)
            return false;
        else if(bot < room.length - 1)
            bot++;

        if(left < 0)
            return false;
        else if(left > 0)
            left--;

        if(right >= room[0].length)
            return false;
        else if(right < room[0].length - 1)
            right++;

        return isEmptyRegion(top, bot, left, right);
    }

    public ArrayList<Location> whereFits(int width, int height){
        ArrayList<Location> spots = new ArrayList<Location>();

        for(int r = 0; r <= room.length - height; r++){
            for(int c = 0; c <= room[0].length - width; c++){
                Location loc = new Location(r, c);
                if(fits(width, height, loc))
                    spots.add(loc);
            }
        }
        return spots;
    }
}

class TestFloorPlan {

    public static void main(String[] args) {
        /*int[][] room = new int[][]{
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0}
        };

        FloorPlan floor = new FloorPlan(room);

        {
            if(floor.fits(4, 2, new Location(6, -2)))
                System.err.println("Test 1 failed");
        }*/
    }
}