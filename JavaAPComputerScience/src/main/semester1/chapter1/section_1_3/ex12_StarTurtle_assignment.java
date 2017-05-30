package semester1.chapter1.section_1_3;import BookClasses.turtles.Turtle;


/**
 * Created by user1928 on 9/12/14.
 */
public class ex12_StarTurtle_assignment extends Turtle {

    public void fivePointStar() {
        /*
        Each outside segment forming the star contour is 60 pixels.
        The tip of the star has angle 36 degrees so the turtle must turn 180 - 36 = 144 degrees
         */

        paint(0, 60); // paint first arm
        paint(72, 60); //paint left side of north tip
        paint(-144, 60); //right side of north tip
        paint(72, 60); //start on eastern tip
        paint(-144, 60); // finish eastern tip
        paint(72, 60); //start southeastern tip
        paint(-144, 60); //finish southeastern tip
        paint(72, 60); //start southwest tip
        paint(-144, 60); //finish southwest tip
        paint(72, 60); //start west tip (end of star)

    }

    public void starOfDavid() {
        /*
        LENGTH TO USE:
        x = length of the star breast = 60 + 60 + 60 = 180

        ANGLE TO TURN:
        The tip of the star is 60 degrees, so the turtle must turn 180 - 60 = 120 degrees
         */

        // Do first equilateral arithmeticSumByOnes
        paint(0, 180); // draw first line to reach northeast corner
        paint(-120, 180); //draw until south corner
        paint(-120, 180); //draw until northwest corner

        //Check position
        move(-120, 60); //move from the west arm to get to north tip
        move(60, 60); //move onto north tip

        //Do second equilateral sum
        paint(-120, 180); //draw until southeast corner
        paint(-120, 180); //draw until southwest corner
        paint(-120, 180); //draw until north tip


    }


}
