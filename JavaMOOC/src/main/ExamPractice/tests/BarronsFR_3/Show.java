package main.ExamPractice.tests.BarronsFR_3;



public class Show {

    private int[][] seats;
   /* private final int SEATS_PER_ROW = seats[0].length;
    private final int NUM_ROWS = seats.length;*/


    public Show(int[][] theSeats){
        seats = new int[theSeats.length][theSeats[0].length];

        for(int r = 0; r < theSeats.length; r++){
            for(int c = 0; c < theSeats[0].length; c++){
                seats[r][c] = theSeats[r][c];
            }
        }
    }

    /* part a*/
    public boolean isAisleSeat(int row, int seatNumber){
        return seatNumber == 0 || seatNumber == seats[0].length - 1;
    }

    /* part c*/
    public int findAdjacent(int row, int seatsNeeded){
        /*
        //my code
        int seatsFound = 1;

        for(int pos = 0; pos < seats[0].length - 1; pos++){
            if(seats[row][pos] == 0 && seats[row][pos + 1] == 0){
                seatsFound++;
                if(seatsFound == seatsNeeded)
                    return pos + 1 - seatsFound + 1;
            }
        }
        return - 1;*/

        //test answer code
        int currIndex  = 0;
        int seatsFound = 0;
        int lowIndex = 0;

        while(currIndex < seats[0].length){
            while(currIndex < seats[0].length && seats[row][currIndex] == 0){
                seatsFound++;
                currIndex++;
                if(seatsFound == seatsNeeded)
                    return lowIndex;
            }
            seatsFound = 0;
            currIndex++;
            lowIndex = currIndex;
        }
        return -1;
    }
}

class TestShow{
    public static void main(String[] args) {
        int[][] showSeats = new int[][]{
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1},
                {1, 0, 0, 1, 0, 0}
        };

        Show show = new Show(showSeats);

        {
            if(show.findAdjacent(0, 3) != 3)
                System.err.println("Test 0, 3 failed");
            if(show.findAdjacent(1, 3) != 0)
                System.err.println("Test 1, 3 failed");
            if(show.findAdjacent(2, 2) != 1)
                System.err.println("Test 2, 2 failed");
            if(show.findAdjacent(1, 5) != -1)
                System.err.println("Test 1, 5 failed");
        }

    }
}