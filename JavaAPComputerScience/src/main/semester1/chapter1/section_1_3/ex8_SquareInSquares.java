package semester1.chapter1.section_1_3;

//THIS IS THE ANSWER - TRY ON OWN


public class ex8_SquareInSquares {


    public static void main (String[ ] args) {

        SmartTurtle cat;

        cat = new SmartTurtle();
        cat.makeBigSquare ();
        cat.move (0, 50);   // this is arbitrary; anything over 40 would do
        cat.makeBigSquare();
        cat.move (90, 25);
        cat.move (90, 25);  // to upper-left corner of inner square
        cat.makeSmallSquare();
        cat.move (0, 50);   //  to upper-left corner of the other inner square
        cat.makeSmallSquare();
    }
}
