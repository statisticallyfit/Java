package semester1.chapter1.section_1_4;
import BookClasses.turtles.Turtle;
/**
 * Created by user1928 on 9/19/14.
 */
public class ex21_ColoredCircles_assignment extends Turtle {

    public void drawHugeGreenCircle() {
        switchTo(GREEN);
        fillCircle(200);
    }

    public void drawMediumRedCircle() {
        switchTo(RED);
        fillCircle(40);
    }

    public void drawSmallYellowCircle() {
        switchTo(YELLOW);
        fillCircle(20);
    }

    public void drawMediumBlueCircle() {
        switchTo(BLUE);
        fillCircle(50);
    }

    public void drawBiggishMagentaCircle() {
        switchTo(MAGENTA);
        fillCircle(80);
    }


    public static void main(String[] args) {

        ex21_ColoredCircles_assignment sam; // name variable sam
        sam = new ex21_ColoredCircles_assignment(); // and instantiate the object

        sam.move(0, 50);
        sam.move(90, 50); //move to drawn blue circle off center
        sam.drawMediumBlueCircle();
        sleep(1000); //sleep half a second

        sam.move(125, 260); //move far away to the southwest corner
        sam.drawHugeGreenCircle();
        sleep(1000);

        sam.move(135, 290); //move to right corner
        sam.drawSmallYellowCircle();
        sleep(1000);

        sam.move(60, 180); //move up at steep angle
        sam.drawBiggishMagentaCircle();
        sleep(1000);

        sam.move(90, 400); // move in north west direction
        sam.drawMediumRedCircle();
    }
}
