package semester1.chapter1.section_1_5_to_1_8;

import BookClasses.turtles.Turtle;

/**
 * Created by user1928 on 9/19/14.
 */

class FractalTurtle extends Turtle
{
    public void drawTree (double trunk)
    {
        paint (0, trunk);             // go to top of trunk
        move (30, 0);                 // face to the left
        if (trunk > 1)
            drawTree (trunk * 0.7);    // make branches on the left
        move (-60, 0);                // face to the right
        if (trunk > 1)
            drawTree (trunk * 0.7);    // make branches on the right
        move (30, -trunk);            // go to bottom of trunk
    }
}

public class FractalApp
{
    // Draw a Pythogorean tree.

    public static void main (String[ ] args)
    {
        FractalTurtle pythagoras;
        pythagoras = new FractalTurtle();
        pythagoras.move (90, -240);
        pythagoras.drawTree (80);
    }
}



