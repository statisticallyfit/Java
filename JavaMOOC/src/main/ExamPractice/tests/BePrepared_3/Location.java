package main.ExamPractice.tests.BePrepared_3;


import java.util.ArrayList;

public class Location {

    private int row;
    private int col;

    public Location(int aRow, int aCol){
        row = aRow;
        col = aCol;
    }

    public String toString(){
        return col + "";
    }

    public int getCol(){
        return col;
    }
}

class SkiArea {
    private int[][] alts;

    public SkiArea(int[][] arrayOfAltitudes){
        alts = arrayOfAltitudes;
    }

    public static int indexOfMax(int [] arr){
        int maxIndex = 0;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int findSummit(){
        return indexOfMax(alts[0]);
    }

    public ArrayList<Location> findSteepestTrail(){
        int r = 0;
        int c = findSummit();
        int last = alts[0].length - 1;
        ArrayList<Location> trail = new ArrayList<Location>();
        trail.add(new Location(r, c));

        for(r = 1; r < alts.length; r++){
            if(c == 0) {
                c = (alts[r][0] < alts[r][1]) ? 0 : 1;
            } else if(c == last) {
                c = (alts[r][last - 1] < alts[r][last]) ? last - 1 : last;
            } else {
                int minOfTwoIndex = (alts[r][c - 1]  < alts[r][c]) ? c - 1 : c;
                c = (alts[r][c + 1] < alts[r][minOfTwoIndex]) ? c + 1 : minOfTwoIndex;
            }
            trail.add(new Location(r, c));
        }
        return trail;
    }

    public void printAltitudesFromTrail(ArrayList<Location> trail){
        int r = 0;
        for(Location loc : trail){
            System.out.print(alts[r][loc.getCol()] + " ");
            r++;
        }
    }
}

class TestSkiArea {

    public static void main(String[] args) {
        int[][] altitudes = new int[][]{
                {7, 9, 6, 9},
                {8, 9, 9, 8},
                {6, 5, 5, 6},
                {4, 6, 3, 5},
                {5, 5, 4, 3},
                {2, 2, 3, 1},
                {2, 1, 0, 1}
        };

        SkiArea skier = new SkiArea(altitudes);
        ArrayList<Location> trail = skier.findSteepestTrail();
        System.out.println(trail);
        skier.printAltitudesFromTrail(trail);
    }
}