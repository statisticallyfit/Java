package semester1.chapter1.section_1_3;
import BookClasses.turtles.Turtle;

/**
 * Created by user1928 on 9/12/14.
 */
public class SmartTurtle extends Turtle {

    //constructor (exercise 4.7)
    public SmartTurtle(){
        super();
    }

    // Make a 10x10 square; finish with the same position and heading


    // VOCABULARY NOTE: to default:
    // ==> the commands inside makeSmallSquare() and makeBigSquare()
    // default to the executor, which is object sam.

    public void makeSmallSquare() {
        paint(90, 10);
        paint(90, 10);
        paint(90, 10);
        paint(90, 10);
    }



    // Make a 40x40 square; finish with the same position and heading

    public void makeBigSquare() {
        paint(90, 40);
        paint(90, 40);
        paint(90, 40);
        paint(90, 40);
    }


    public static void main(String[] args) {

        SmartTurtle sam = new SmartTurtle();

        sam.makeSmallSquare();

        sam.makeBigSquare();

    }
}
