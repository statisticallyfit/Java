package main.bookAP.Chapter1_Intro;

/**
 * Created by user1928 on 1/18/15.
 */
public class Labels {

    public void labelsMethod(){
        int count = 0;
        outerLabel:
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++)
            {
                count++;
                System.out.println("i: " + i + "   |    j: " + j + "   |    count " + count);
                if(count > 2) {
                    continue outerLabel;
                }
            }
            count += 10;
        }
    }

    public static void main(String[] args) {
        Labels label = new Labels();

        label.labelsMethod();
    }
}
