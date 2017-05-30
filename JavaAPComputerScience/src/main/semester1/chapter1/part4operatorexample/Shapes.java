package semester1.chapter1.part4operatorexample;

import BookClasses.turtles.Turtle;

/**
 * Created by user1928 on 11/14/14.
 */
public class Shapes extends Turtle{

    public void makeRegularPolygon(int turn, int side){
        for(int total = 0; total < 360; total = total + turn){
            paint(turn, side);
        }
    }

    public static void main(String[] args){
        Shapes shaper = new Shapes();

        shaper.makeRegularPolygon(72, 40);
    }
}
