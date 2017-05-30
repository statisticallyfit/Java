package main.Practice;
import java.util.ArrayList;
import java.util.Scanner;


/** =========================== BOARD STUFF ========================= */
/** ================================================================= */

class Game {

    private Board board;
    private Player person;
    private Player computer;

    public Game(){
        board = new Board();
        person = new Person();
        //computer = new Computer();
    }

    public Board getBoard() { return board; }
    public Player getPerson() { return person; }
    public Player getComputer() { return computer; }

    /**
     * Returns array of sign streak objects, telling where each streak
     * begins and ends, for that particular symbol (sign)
     * One sign does not count as streak
     * Streak is two or more signs in a row/vertical/main/minor diagonal
     */
    public SignStreak[] getStreaks(String playerSign) {

        int dim = board.getDimension();
        SignStreak[] allStreaks = new SignStreak[dim];
        int start = 0;
        int end = 0;
        int index = 0;
        boolean skip = false;

        // testing horizontal streaks
        for (int row = 0; row < dim; row++, index++)
        {
            for (int i = 0; i < dim - 1; i++)
            {
                Location sLoc = board.getLocation(row, i);
                if (!sLoc.isEmpty() && sLoc.getSign().equals(playerSign))
                {
                    start = i;
                    end = i;
                    for (int j = i + 1; j < dim; j++)
                    {
                        Location eLoc = board.getLocation(row, j);
                        if (!eLoc.isEmpty()
                                && eLoc.getSign().equals(playerSign)
                                && eLoc.getSign().equals(sLoc.getSign()))
                        {
                            end = j;
                        } else {
                            j = dim; // to skip this row
                            skip = true;
                        }
                    }
                }
                if (skip)
                    break;
            }
            if (start != end){
                Location s = new Location(new Point(row, start));
                Location e = new Location(new Point(row, end));
                SignStreak streak = new SignStreak(s, e);
                streak.setHorizontal();
                allStreaks[index] = streak;
            }
        }

        // testing vertical streaks
        // index is now EQUAL TO dim, so decrement, so can increment it first time
        index--;
        skip = false;
        for (int col = 0; col < dim; col++, index++)
        {
            for (int i = 0; i < dim - 1; i++)
            {
                Location sLoc = board.getLocation(i, col);
                if (!sLoc.isEmpty() && sLoc.getSign().equals(playerSign))
                {
                    start = i;
                    end = i;
                    for (int j = i + 1; j < dim; j++)
                    {
                        Location eLoc = board.getLocation(j, col);
                        if (!eLoc.isEmpty()
                                && eLoc.getSign().equals(playerSign)
                                && eLoc.getSign().equals(sLoc.getSign()))
                        {
                            end = j;
                        } else {
                            j = dim; // to skip this column
                            skip = true;
                        }
                    }
                }
                if (skip)
                    break;
            }
            if (start != end){
                Location s = new Location(new Point(start, col));
                Location e = new Location(new Point(end, col));
                SignStreak streak = new SignStreak(s, e);
                streak.setVertical();
                allStreaks[index] = streak;
            }
        }



        // testing major diagonal for streaks
        index--;
        skip = false;
        for (int row = 0; row < dim; row++, index++)
        {
            for (int i = 0; i < dim - 1; i++)
            {
                Location sLoc = board.getLocation(row, i);
                if (!sLoc.isEmpty() && sLoc.getSign().equals(playerSign))
                {
                    start = i;
                    end = i;
                    for (int j = i + 1; j < dim; j++)
                    {
                        Location eLoc = board.getLocation(row, j);
                        if (!eLoc.isEmpty()
                                && eLoc.getSign().equals(playerSign)
                                && eLoc.getSign().equals(sLoc.getSign()))
                        {
                            end = j;
                        } else {
                            j = dim; // to skip this row
                            skip = true;
                        }
                    }
                }
                if (skip)
                    break;
            }
            if (start != end){
                Location s = new Location(new Point(row, start));
                Location e = new Location(new Point(row, end));
                SignStreak streak = new SignStreak(s, e);
                streak.setHorizontal();
                allStreaks[index] = streak;
            }
        }

        return allStreaks;
    }
}


/** =========================== class Point ========================= */
class Point {

    private int x;
    private int y;

    public Point(int xCoord, int yCoord) {
        this.x = xCoord;
        this.y = yCoord;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int xCoord) { x = xCoord; }
    public void setY(int yCoord) { y = yCoord; }
}

/** =========================== class Location ========================= */
class Location {

    private Point point;
    private String sign;
    private boolean empty;

    public Location(Point aPoint){
        this.point = aPoint;
        this.empty = true;
    }

    public void fill(String aSign) {
        sign = aSign;
        empty = false;
    }
    public boolean isEmpty() { return empty;}
    public void setPoint(Point aPoint) {point = aPoint; }
    public void setSign(String s) { sign = s; }
    public String getSign() { return sign; }
    public Point getPoint() { return point; }
}

/** =========================== class SignStreak ========================= */
class SignStreak {

    private Location start;
    private Location end;
    boolean diagonal;
    boolean vertical;
    boolean horizontal;

    public SignStreak(){
        this.start = new Location(new Point(0, 0));
        this.end = new Location(new Point(0, 0));
        this.diagonal = false;
        this.vertical = false;
        this.horizontal = false;
    }

    public SignStreak(Location s, Location e){
        this.start = s;
        this.end = e;
        this.diagonal = false;
        this.vertical = false;
        this.horizontal = false;
    }

    public void setStart(Location s) { start = s;}
    public void setEnd(Location e) { end = e;}
    public Location getStart() { return start; }
    public Location getEnd() { return end; }

    public void setDiagonal() { diagonal = true; }
    public void setVertical() { vertical = true; }
    public void setHorizontal() { horizontal = true; }

    public boolean isDiagonal() {
        // if not H and not V and IS STREAK, then must be DIAG
        //return(!this.isHorizontal() && !this.isVertical());
        return diagonal;
    }

    public boolean isVertical() {
        //return(this.getStart().getPoint().getY() == this.getEnd().getPoint().getY());
        return vertical;
    }

    public boolean isHorizontal() {
        //return(this.getStart().getPoint().getX() == this.getEnd().getPoint().getX());
        return horizontal;
    }

}

/** =========================== class Board ========================= */
class Board {

    private int DIMENSION = 7;
    private ArrayList<ArrayList<Location>> boardArray;

    public Board() {
        boardArray = new ArrayList<ArrayList<Location>>();
        ArrayList<Location> tempRow;

        for (int r = 0; r < DIMENSION; r++)
        {
            tempRow = new ArrayList<Location>();
            for (int c = 0; c < DIMENSION; c++)
            {
                Location loc = new Location(new Point(r, c));
                tempRow.add(loc);
            }
            boardArray.add(tempRow);
        }
    }

    public int getDimension() { return DIMENSION; }
    public ArrayList<ArrayList<Location>> getBoard() {return boardArray;}
    public Location getLocation(int r, int c) { return boardArray.get(r).get(c); }

    public void update(Location loc, String sign){
        // setSign and fill() methods then put location in spot
        Point p = loc.getPoint();
        int x = p.getX();
        int y = p.getY();

        boardArray.get(x).get(y).fill(sign); // now non-empty
    }

    public void show() {
        for (int r = 0; r < DIMENSION; r++)
        {
            // Print the line at top +--+--+
            for (int i = 0; i < DIMENSION; i++) {
                System.out.println("+---");
            }
            // Print the | X | part
            for (int c = 0; c < DIMENSION; c++)
            {
                Location loc = boardArray.get(r).get(c);
                System.out.println("| " + loc.getSign() + " ");
                if (c + 1 == 7)
                    System.out.println("|"); //print last bar
            }
        }
        // the bottom +---+--- part
        for (int i = 0; i < DIMENSION; i++)
        {
            System.out.println("+---");
        }
    }
}





/** =========================== PLAYER STUFF ======================== */
/** ================================================================= */

/*abstract */class Player {

    private String sign;

    public Player(String playerSign){
        this.sign = playerSign;
    }

    public String getSign() { return sign; }
}


class Person extends Player {

    public Person(){
        super("X"); // person has sign "X"
    }

    public Location ask() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter x-coordinate of location: ");
        int x = scan.nextInt();
        System.out.print("Enter y-coordinate of location: ");
        int y = scan.nextInt();

        return new Location(new Point(x, y));

    }
}

class Computer extends Player {

    public Computer() {
        super("O");
    }


}





public class TicTacToe {

    public static void main(String[] args) {

        System.out.println(" X");
        System.out.println(" O");
        System.out.println("+---+");
        System.out.println("| X |");
        System.out.println("+---+");
    }
}
