package semester1.chapter4.section_4_4;

import BookClasses.turtles.Turtle;

/**
 * Created by user1928 on 11/21/14.
 */
public class NamedTurtle extends Turtle {

    public String itsName = null;

    public NamedTurtle(String name){
        super();
        this.itsName = name;
    }

    public String getTurtleName(){
        return this.itsName;
    }
}
