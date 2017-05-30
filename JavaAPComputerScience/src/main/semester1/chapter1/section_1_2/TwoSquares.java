package semester1.chapter1.section_1_2;
import BookClasses.turtles.Turtle;
/**
 * Created by user1928 on 9/12/14.
 */
public class TwoSquares {


    public static void main(String[] args){

        // Draw two 40x40 squares side by side, 10 px apart

        Turtle sam = new Turtle();


        // complete square one
        sam.paint(90, 40);
        sam.paint(-90, 40);
        sam.paint(-90, 40);
        sam.paint(-90, 40);

        //move pixels to have 10 pixel space between squares
        sam.move(-180, -50);

        // complete square two
        sam.paint(90, 40);
        sam.paint(-90, 40);
        sam.paint(-90, 40);
        sam.paint(-90, 40);


    }
}


/*
public class TwoSquares {


    Turtle sam = new Turtle();
    TwoSquares squareObj = new TwoSquares();


    public void makeSquare() {
        sam.paint(90, 40);
        sam.paint(-90, 40);
        sam.paint(-90, 40);
        sam.paint(-90, 40);

    }


    public static void main(String[] args){

        // Draw two 40x40 squares side by side, 10 px apart

        Turtle sam = new Turtle();
        TwoSquares squareObj = new TwoSquares();


        // complete square one
        squareObj.makeSquare();

        //move pixels to have 10 pixel space between squares
        sam.move(0, -50);

        // complete square two
        squareObj.makeSquare();


    }
}
 */