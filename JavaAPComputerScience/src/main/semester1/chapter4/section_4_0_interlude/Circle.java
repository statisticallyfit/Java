package semester1.chapter4.section_4_0_interlude;

import BookClasses.turtles.Turtle;

import java.awt.*;

/**
 * Created by user1928 on 9/13/14.
 */

public class Circle extends Turtle {

//    int x;
//    int y;
    double radius;
    Color color;
    Turtle t;

    public Circle(/*int x, int y, */double radius, Color color, Turtle t) {
//        this.x = x;
//        this.y = y;
        this.radius = radius;
        this.color = color;
        this.t = t;
    }

    public void paint() {
        this.t.switchTo(this.color);
        this.t.fillCircle(this.radius);
    }

}
