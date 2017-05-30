package semester1.chapter4.section_4_0_interlude;
import BookClasses.turtles.Turtle;
/**
 * Created by user1928 on 11/14/14.
 */
public class ex5_ManyHi extends Turtle {

    public void sayHi(int numberOfTimes){

        for(int i = 0; i < numberOfTimes ; i++){
            say("Hi");
            move(0, 20);
        }
    }

    public static void main(String[] args){
        ex5_ManyHi saluter = new ex5_ManyHi();

        saluter.sayHi(7);
    }
}
