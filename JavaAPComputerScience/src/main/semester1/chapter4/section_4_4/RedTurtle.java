package semester1.chapter4.section_4_4;

import BookClasses.turtles.Turtle;

/**
 * Created by user1928 on 11/21/14.
 */
public class RedTurtle extends Turtle {

    //constructor
    public RedTurtle(){
        super();
        switchTo(RED); //always red
        move(180, 0); //due west heading
    }
}
