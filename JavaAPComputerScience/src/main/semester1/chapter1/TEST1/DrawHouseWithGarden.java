package semester1.chapter1.TEST1;
/**
 * Created by user1928 on 9/19/14.
 */
public class DrawHouseWithGarden extends HouseMaker {
//Program goal: use HouseMaker to draw the house
    public static void main(String[] args) {
        HouseMaker sam = new HouseMaker();

        sam.makeBigSquare();
        sam.makeDoor();
        sam.makeWindows();
        sam.makeRoof();

        //make the flowers on the left side
        sam.move(0, -91); //move to base of leftmost flower so there are 25 pixels between right flower and left house base
        sam.drawTwoFlowers();

        //make flowers on right side of house
        sam.move(0, 311); //move right side of house, 20 pixels to the right
        sam.drawTwoFlowers();

        sam.move(0, -220); // move back to southwest corner of house
    }
}
