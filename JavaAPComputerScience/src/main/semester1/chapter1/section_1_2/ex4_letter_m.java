package semester1.chapter1.section_1_2;

import BookClasses.turtles.Turtle;
/**
 * Created by user1928 on 9/12/14.
 */
public class ex4_letter_m {

    public static void main(String[] args){

        Turtle sue = new Turtle();

        /*
        sue.paint(90, 7);
        sue.paint(-90, 5);
        sue.paint(-90, 7);
        sue.move(180, 7);
        sue.paint(-90, 4);
        sue.paint(-90, 7);

         */


        // ANSWER
/*
        sue = new Turtle();
        sue.paint (90, 6);  // the left side of the 'm'
        sue.paint (-90, 4);
        sue.paint (-90, 7);  // the center part of the 'm'
        sue.move (180, 7);
        sue.paint (-90, 4);
        sue.paint (-90, 7);  // the right side of the 'm'
        */

        sue.paint(90, 7);
        sue.paint(0, 50);
        sue.move(0, 2);
        sue.paint(0, 1);
    }

}








