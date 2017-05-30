package semester1.chapter1.section_1_4;
import BookClasses.turtles.Turtle;
/**
 * Created by user1928 on 9/13/14.
 */


public class FlowerMaker2 extends Turtle {

    // Draw two flowers each 60 pixels tall.
    // Start and end facing east at the base of the left flower.

    public void drawTwoFlowers()
    {
        drawFlower(); //flower to the left
        move(0,-20); // NEW
        move (90, 61); //position
        //fillBox(3, 20); //make flower 2 higher by 20 px with stem of 3 px
        drawFlower(); //draw the flower to the right
        move(0,20); // NEW
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

        paint(45, 10);    // one-half of the way up the stem ---- SEEMS STEM HAS 1 px thickness inside
        // (total 3 px) - use paint to cover it as we go along to paint leaves
        paint(45, 8);     // draw the twig for the left leaf
        drawLeaf();

        paint(-45, 30);   // to top of stem, in the center
        switchTo (PINK);
        fillCircle (15);   // draw the flower petals
        switchTo (BLACK);
        move (180, 50);    // return to the base of the flower
    }


    public void drawSmallFlower() {

        move(90, 0);
        fillBox(3, 10); // angle self 90 to the left and make stem
        move(0, 10); // move the radius to center of flower
        switchTo(RED);
        fillCircle(7); // make flower

    }


    public void drawLeaf()
    {
        switchTo (GREEN);
        fillCircle (3);
        move(0, 3);
        fillCircle(2);
        move(0, 2);
        fillCircle(1);
        move(0, -13);
        switchTo(BLACK);
    }
}
