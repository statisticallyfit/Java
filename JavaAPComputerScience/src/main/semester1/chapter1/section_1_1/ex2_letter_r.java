package semester1.chapter1.section_1_1;

import BookClasses.turtles.Turtle;

/**
 * Created by user1928 on 9/12/14.
 */
public class ex2_letter_r {

    public static void main(String[] arguments){

        Turtle sam = new Turtle();

        /*
        sam.say("I'm going to introduce myself. My name is Sam! Hello!");
        sam.move(0, -200);
        //sam.fillCircle(100);
        //turtle starts facing right, so turn him left 90 degrees
        sam.paint(90, 12); // make r stem 12 pixels long
        sam.move(0,-5); //move back a bit to make the top r stem
        sam.move(-45, 0); // face right direction for the r curlicue top
        sam.paint(0,4); // make leaning top
        sam.move(-45,0); // face straight ahead to the east
        sam.paint(0,8 ); // make r straight top
        sam.move(-45, 0); // face softer degree
        sam.paint(0,4);  // taper off the end so it doesn't look like a box or straightedge
        */

        // ANSWER:
        sam.paint(90, 12);
        sam.move(180, 2); //position the place for stem of 'r'
        sam.paint(135,3);
        sam.paint(-45,6);
    }
}
