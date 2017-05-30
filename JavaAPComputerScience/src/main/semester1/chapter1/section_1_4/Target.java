package semester1.chapter1.section_1_4;
import BookClasses.turtles.Turtle;
import java.awt.*;

class Circle extends Turtle{
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

public class Target {


    public static void main(String[] args) {
        Turtle sam = new Turtle();    // create the object sam refers to

        Circle[] circles = new Circle[]{
                new Circle(/*100, 100,*/ 50, Color.RED, sam),
                new Circle(/*100, 100,*/ 40, Color.WHITE, sam),
                new Circle(/*100, 100,*/ 30, Color.BLUE, sam),
                new Circle(/*100, 100,*/ 20, Color.BLACK, sam),
                new Circle(10, Color.ORANGE, sam)
        };


        for (int i = 0; i < circles.length; i++) {
            Circle c = circles[i];
            c.paint();
        }

    }
}
