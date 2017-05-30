package semester1.chapter1.section_1_3;

/**
 * Created by user1928 on 9/12/14.
 */
public class ex13_BigDipper_assignment {

    public static void main(String[] args) {
        ex12_StarTurtle_assignment sue = new ex12_StarTurtle_assignment();


        // Make the cup of the dipper

        sue.move(-90, 90); //move to position first star
        sue.move(135, 228); // move so that first star is at right most corner of page
        sue.move(-45, 0); //finish movement

        sue.fivePointStar(); // draw northeast star of big dipper

        sue.move(126, 130); //move turtle to corner of next southeast star
        sue.move(90, 0); //turn left so star can be drawn

        sue.fivePointStar(); //draw southeast star of big dipper

        sue.move(36, 170); //move turtle to southwest star's position
        sue.move(-90, 130); //get to northeast corner
        sue.move(-90, 0); //face appropriate direction so it can draw the star

        sue.fivePointStar(); //draw the southwest star of big dipper

        sue.move(126, 130); //move to corner of next southwest star
        sue.move(90, 0); //turn left so star can be drawn

        sue.fivePointStar(); //draw the final southwest star



        // Make the handle

        sue.move(-54, 210); // position for dipper handle at northwestmost corner
        sue.move(-90, -170); // finish position with face to east to start the handle

        sue.fivePointStar();

        sue.move(-144, -180); // face east and position for six pointed star (handle's end)
        sue.move(90, 20); // move up more
        sue.move(-90, 0); //return to facing east

        sue.starOfDavid();


    }
}
