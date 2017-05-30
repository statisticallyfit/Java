package semester1.chapter4.section_4_0_interlude;
import BookClasses.turtles.Turtle;
/**
 * Created by user1928 on 11/14/14.
 */
public class PowerTest extends Turtle {

    public void makeRegularPolygon (int turn, int side){
        paint(turn, side); //lets first one be outside because of the condition total < 360
        int total = turn;
        while (total < 360){
            paint(turn, side);
            total += turn; //a counter
        }
    }

    public static void main(String[] args){
        PowerTest tester = new PowerTest();

        tester.makeRegularPolygon(72, 100);
    }
}
