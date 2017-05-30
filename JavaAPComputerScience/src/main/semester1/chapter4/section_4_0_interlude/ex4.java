package semester1.chapter4.section_4_0_interlude;

import BookClasses.turtles.Turtle;

/**
 * Created by user1928 on 11/14/14.
 */
public class ex4 extends Turtle {

    //diameters: 60, 120, 180, 240, 300
    //radii: 30, 60, 90, 120, 150
    public void FiveCircles(){
        //int turn = 360;

        for(int radius = 30; radius <= 150; radius = radius + 30){
            swingAround(radius);
        }
    }

    public static void main(String[] args){
        ex4 circler = new ex4();

        circler.FiveCircles();
    }
}
