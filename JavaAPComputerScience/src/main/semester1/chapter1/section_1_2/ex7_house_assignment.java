package semester1.chapter1.section_1_2;
import BookClasses.turtles.Turtle;
/**
 * Created by user1928 on 9/12/14.
 */
public class ex7_house_assignment {

    public static void main(String[] args){

        // declare variable name sue: reference is Turtle
        Turtle sue;

        // make an object of class Turtle. Call to the constructor called public Turtle()
        // to create new object
        sue = new Turtle();

        // Draw house as rectangle
        sue.paint(0, 200); //draw house base
        sue.paint(90, 75); // draw the right side of the house
        sue.paint(90, 200); // draw base of roof
        sue.paint(90, 75); // draw left side of house

        // Add triangle roof
        sue.move(180, 75); // get to top left of house
        sue.paint(-53.13, 125); //make the left slope of roof
        sue.paint(-73.74, 125); // make right slope

        // Add door with doorknob
        sue.move(-53.13, 75);
        sue.move(-90,80);
        sue.paint(-90, 56); //draw right side of door
        sue.paint(90, 40); // draw top
        sue.paint(90, 56); //draw left side of door
        //now add the doorknob
        sue.move(90, 30);
        sue.move(90, 28); //get to the right position, halfway up door
        sue.fillCircle(4); // draw doorknob


        // Draw windows

        // FIRST WINDOW
        sue.move(-90, 36);
        sue.paint(0, 28); // draw bottom side
        sue.paint(90, 28); //draw right side
        sue.paint(90, 28);// draw top
        sue.paint(90, 28); //draw left side
        //DRAW CROSS LINES
        sue.move(180, 14);
        sue.paint(-90, 28); //draw horizontal cross line
        sue.move(90, 14);
        sue.move(90, 14);
        sue.paint(90, 28); //draw vertical cross


        //SECOND WINDOW
        sue.move(-90, 106);// travel to left side of house
        sue.paint(0, 28); //draw base
        sue.paint(-90, 28); //draw left side
        sue.paint(-90, 28); //draw top
        sue.paint(-90, 28); //draw right side
        //DRAW CROSS LINES
        sue.move(180, 14);
        sue.paint(90, 28); //draw cross horizontal
        sue.move(-90, 14);
        sue.move(-90, 14);
        sue.paint(-90, 28); //draw vertical cross


    }
}
