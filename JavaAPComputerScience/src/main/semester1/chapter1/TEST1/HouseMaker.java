package semester1.chapter1.TEST1;
import semester1.chapter1.section_1_4.FlowerMaker;

/**
 * Created by user1928 on 9/19/14.
 */
public class HouseMaker extends FlowerMaker {
// Program goal: make a 200x200 house, 60x60 windows, and 100x50 door. Two flowers must be on either side.
// Return turtle to starting point at the end of each method.
// Starting point: southwest corner of house


    //Make the house outline
    public void makeBigSquare() {
        switchTo(MAGENTA);
        move(90, -100);
        move(-90, -100); //move to the southwest corner of the house
        paint(0, 200);
        paint(90, 200);
        paint(90, 200);
        paint(90, 200);

        // RETURN TO STARTING POSITION
        move(90, 0); //return turtle to face east
    }

    public void makeRoof() {
        switchTo(BLACK);

        //make top
        move(90, 220); //move to left top corner of roof
        paint(-90, 200); //make top roof

        // make edges
        paint(-60, 60); //make right sloping edge 60 px long
        move(0, -60); //back out of slope
        move(240, 200); //get to left slope
        paint(60, 60); //make the left sloping edge 60 px long

        // RETURN TO STARTING POSITION
        move(0, -60); //back out of slope
        move(-150, -220); //turn to face north and slide down house's left side
        move(-90, 0); //face east to return to starting position
    }

    public void makeDoor() {
        move(0, 125); //move to right base of door
        switchTo(GREEN);
        paint(90, 100); //make right side
        paint(90, 50); //make top
        paint(90, 100); //make left side

        // RETURN TO STARTING POSITION
        move(90, -75); //move back to southwest corner of house
    }

    public void makeWindows() {
        // make first window
        move(0, 185);
        move(90, 110); //move to right lower base of right window
        switchTo(BLUE);
        makeSmallSquare();

        //make second window
        move(0, -110); //move to right lower base of left window
        move(90, 0); //face north
        makeSmallSquare();

        // RETURN TO STARTING POSITION
        move(90, -110); //move to door base
        move(-90, -75); //move to southwest corner of house
    }

    public void makeSmallSquare() {
        paint(0, 60); //make right side
        paint(90, 60); //make top
        paint(90, 60);// make left side
        paint(90, 60); // make bottom
    }

}
