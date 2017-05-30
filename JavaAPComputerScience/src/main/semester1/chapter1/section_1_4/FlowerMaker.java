package semester1.chapter1.section_1_4;
import BookClasses.turtles.Turtle;
/**
 * Created by user1928 on 9/13/14.
 */


public class FlowerMaker extends Turtle {

    // Draw two flowers each 60 pixels tall.
    // Start and end facing east at the base of the left flower.

    public void drawTwoFlowers()
    {
        drawFlower(); //flower to the left
        move (90, 61); //position
        drawFlower(); //draw the flower to the right
        move (90, -59);
    }

    // Start facing east at the base of the flower, right side,
    // with the current drawing color being BLACK (for the stem).
    // End facing south at the base of the flower, center.

    public void drawFlower()
    {
        paint (90, 50);    // right side of stem
        paint (90, 2);
        paint (90, 50);    // left side of stem
        paint (90, 1);
        paint (90, 10);    // one-fourth of the way up the stem
        paint (-45, 8);    // draw the twig for the right leaf
        drawLeaf();

        paint(45, 10);    // one-half of the way up the stem
        paint(45, 8);     // draw the twig for the left leaf
        drawLeaf();

        paint(-45, 30);   // to top of stem, in the center
        switchTo (RED);
        fillCircle (15);   // draw the flower petals
        switchTo (BLACK);
        move (180, 50);    // return to the base of the flower
        //turtle left facing upside down at flower base
    }



    public void drawLeaf()
    {
        switchTo (GREEN);
        fillCircle (3);
        move (0, 3);
        fillCircle (2);
        move (0, 2);
        fillCircle (1);
        move (0, -13);
        switchTo (BLACK);
    }

}
