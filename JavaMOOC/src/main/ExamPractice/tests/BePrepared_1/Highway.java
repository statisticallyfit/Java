package main.ExamPractice.tests.BePrepared_1;


public class Highway {

    private int[][] hwy;

    /*public Highway(int numLanes, int numCarsPerLane){
        hwy = new int[numLanes][numCarsPerLane];
    }*/


    public Highway(int[][] highway){
        hwy = highway;
    }

    public void addCar(int lane, int x){
        hwy[lane][x] = 1;
    }


    /* part a */
    public boolean canSwitchLane(int lane, int x, int dir){
        if(dir < 0){
            if(lane == 0)
                return false;

            for( ; lane + dir >= 0; dir--)
                if(hwy[lane + dir][x] == 1)
                    return false;
        } else {

            if(lane == hwy.length - 1)
                return false;

            for( ; lane + dir < hwy.length; dir++)
                if(hwy[lane + dir][x] == 1)
                    return false;
        }
        return true;
    }
}

class TestHighway {

    public static void main(String[] args) {
        int[][] highway = new int[][]{
            {0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 0, 0}
        };

        Highway h = new Highway(highway);


        {
            if(h.canSwitchLane(0, 1, -1))
                System.err.println("Test 0, 1 up failed");
            if(!h.canSwitchLane(1, 3, -1))
                System.err.println("Test 1, 3 up failed");
            if(h.canSwitchLane(1, 6, -1))
                System.err.println("Test 1, 6 up failed");
            if(h.canSwitchLane(2, 1, -1))
                System.err.println("Test 2, 1 up failed");
            if(!h.canSwitchLane(2, 4, -1))
                System.err.println("Test 2, 4, up failed");
            if(!h.canSwitchLane(3, 2, -1))
                System.err.println("Test 3,2 up failed ");
            if(h.canSwitchLane(3, 3, -1))
                System.err.println("Test 3, 3, up failed");
        }

        {
            if(h.canSwitchLane(0, 1, 1))
                System.err.println("Test 0, 1 down failed");
            if(h.canSwitchLane(1, 3, 1))
                System.err.println("Test 1, 3 down failed");
            if(!h.canSwitchLane(1, 6, 1))
                System.err.println("Test 1, 6, down failed");
            if(!h.canSwitchLane(2, 1, 1))
                System.err.println("Test 2, 1 down failed");
            if(h.canSwitchLane(3, 2, 1))
                System.err.println("Test 3, 2, down failed");
        }
    }
}
