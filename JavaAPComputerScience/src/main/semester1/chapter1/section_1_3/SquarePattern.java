package semester1.chapter1.section_1_3;

public class SquarePattern
{
    // Make an X shape with one big 40x40 square in the center
    // and a small 10x10 square in each corner.

    public static void main (String[ ] args)
    {    SmartTurtle sue;
        sue = new SmartTurtle();
        sue.makeBigSquare();      // draw the center square

        sue.move (-90, 15);       // go south
        sue.move (90, 15);        // move to the southeast corner
        sue.makeSmallSquare();    // draw the southeast square

        sue.move (90, 70);        // move to the northeast corner
        sue.makeSmallSquare();    // draw the northeast square

        sue.move (90, 70);        // move to the northwest corner
        sue.makeSmallSquare();    // draw the northwest square

        sue.move (90, 70);        // move to the southwest corner
        sue.makeSmallSquare();    // draw the southwest square
    }
}