package main.Practice;


public class Robot {

    private int[] hall;             // left wall: pos = 0, right wall = length index
    private int pos;                // current tile number of Robot
    private boolean facingRight;    // true means facing right

    public Robot(){
        hall = new int[4];
        // generate random amounts of toys per spot
        for(int i = 0; i < hall.length; i++){
            int numToys = (int)(Math.random() * 5); // number between 0 and 4
            hall[i] = numToys;
        }
        this.pos = 0;
        this.facingRight = true;
    }

    /**
     * Returns true if Robot has wall immediately in front, else false
     */
    private boolean forwardMoveBlocked(){
        return(pos == 0 && !facingRight) ||
                (pos == hall.length - 1 && facingRight);
    }

    /**
     * Postcondition: one move has been made according to spec
     * and state of Robot is updated
     */
    private void move(){
        if(hall[pos] > 0)
            hall[pos]--;
        if(hall[pos] == 0) {
            if(!forwardMoveBlocked()){
                if(facingRight)
                    pos++;
                else
                    pos--;
            }
            else {
                facingRight = !facingRight;
            }
        }
    }

    /**
     * Postcondition: no more items are in hallway.
     * Returns number of moves made
     */
    public int clearHall(){
        int clearMoves = 0;
        while(!hallIsClear()){
            move();
            clearMoves++;
        }
        return clearMoves;
    }

    private boolean hallIsClear(){
        for(int numToys : hall){
            if(numToys != 0)
                return false;
        }
        return true;
    }

}

class RunRobot {

    public static void main(String[] args) {

        Robot r1 = new Robot();
        r1.clearHall();
        Robot r2 = new Robot();
        r2.clearHall();
    }
}
