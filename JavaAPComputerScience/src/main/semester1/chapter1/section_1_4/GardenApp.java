package semester1.chapter1.section_1_4;
import BookClasses.turtles.Turtle;


/**
 * Created by user1928 on 9/13/14.
 */
public class GardenApp extends FlowerMaker
{
    // Draw 6 flowers all in a row, with a word title.

    public static void main (String[ ] args)
    {

       // FlowerMaker2 flora = new FlowerMaker2();

        FlowerMaker florist = new FlowerMaker();

        florist.drawTwoFlowers();    // the central two
        sleep(300);

        florist.move(0, 120);
        florist.drawTwoFlowers();    // the two right of center
        sleep(300);

        florist.move(0, -240);
        florist.drawTwoFlowers();    // the two left of center
        sleep(300);

        florist.move(40, 130);
        florist.switchTo(Turtle.BLUE);
        florist.say("My flower garden");  // above the flowers


        // PART 2: change height of flower

//        flora.drawTwoFlowers();    // the central two
//        flora.sleep (300);
//
//        flora.move (0, 120);
//        flora.drawTwoFlowers();    // the two right of center
//        flora.sleep (300);
//
//        flora.move (0, -240);
//        flora.drawTwoFlowers();    // the two left of center
//        flora.sleep (300);
//
//        flora.move (40, 130);
//        flora.switchTo (Turtle.ORANGE);
//        flora.say ("Flora: My flower garden");  // above the flowers



    }
}