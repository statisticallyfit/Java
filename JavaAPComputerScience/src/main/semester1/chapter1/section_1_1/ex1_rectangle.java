package semester1.chapter1.section_1_1;

import BookClasses.turtles.Turtle;


/**
 * Created by user1928 on 9/12/14.
 */
public class ex1_rectangle {

    public static void main(String[] args){

        // declare variable sue and create new instance of sue
        Turtle sue = new Turtle();

        // turtle starts out facing right, so turn it 90 left first
        /*sue.paint(90, 60);
        sue.switchTo(Turtle.RED);
        sue.paint(-90, 120);
        sue.switchTo(Turtle.BLUE);
        sue.paint(-90, 60);
        sue.switchTo(Turtle.YELLOW);
        sue.paint(-90, 120);*/

        sue.switchTo(Turtle.BLACK);
        sue.paint(0, 120);
        sue.switchTo(Turtle.BLUE);
        sue.paint(90, 60); //first right side
        sue.switchTo(Turtle.ORANGE);
        sue.paint(90, 120); //top
        sue.switchTo(Turtle.RED);
        sue.paint(90, 60); //second left side

    }



}
