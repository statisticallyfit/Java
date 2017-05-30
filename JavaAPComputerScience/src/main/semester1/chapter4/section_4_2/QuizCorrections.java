package semester1.chapter4.section_4_2;

import javax.swing.*;

/**
 * Created by user1928 on 11/14/14.
 */
public class QuizCorrections {

    public void questionSix(){
        for (int k = 5;  k < 65; k++){
            if ((k % 3) == 1)
                System.out.println ("  " + " *" + k);
            else
                System.out.print ("   " + k);
        }
    }

    public boolean isTall(){
        int read1 = Integer.parseInt(JOptionPane.showInputDialog("Get read1"));
        int read2 = Integer.parseInt(JOptionPane.showInputDialog("Get read2"));

        return read1 > read2;
    }


    public static void main(String[] args){
        QuizCorrections quizzer = new QuizCorrections();

        quizzer.questionSix();


        //--------------------------------------------

        QuizCorrections x = new QuizCorrections();
        //x = null;

        int arbitrary = 0;

        while(!x.isTall()){ //expression x.isTall == false is too complicated
            arbitrary++;
        }
    }
}
