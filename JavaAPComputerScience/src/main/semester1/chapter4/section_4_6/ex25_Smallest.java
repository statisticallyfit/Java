package semester1.chapter4.section_4_6;
import javax.swing.JOptionPane;
/**
 * Created by user1928 on 12/12/14.
 */
public class ex25_Smallest {

    /*public void findSmallest(){

        JOptionPane.showMessageDialog (null, "Finding the smallest of a group of integers");
        String prompt = "Enter an integer.  Click Cancel when done";
        String s = JOptionPane.showInputDialog (prompt);
        if (s != null){

            int smallestSoFar = Integer.parseInt (s);
            s = JOptionPane.showInputDialog (prompt);
            while (s != null){
                int input = Integer.parseInt (s);
                if (smallestSoFar > input)
                    smallestSoFar = input;  // replace the value in smallestSoFar by the one in input
                s = JOptionPane.showInputDialog (prompt);
            }
            JOptionPane.showMessageDialog (null, "The smallest was " + smallestSoFar);
        }
    }*/

    public void findSmallest(){
        //post instructions
        String instructions = "Input an sequence of integers by clicking 'OK' after each one. " +
                "\nWhen finished, click 'CANCEL'";
        //get first value
        String newInputStr = JOptionPane.showInputDialog(instructions);

        if(newInputStr != null){
            int smallestInputSoFar = Integer.parseInt(newInputStr);
            //get at least one more value
            newInputStr = JOptionPane.showInputDialog(instructions);

            while(newInputStr != null) {
                int newInputInt = Integer.parseInt(newInputStr);

                if(smallestInputSoFar > newInputInt){
                    smallestInputSoFar = newInputInt;
                }
                // keep getting input; if null, exit while loop
                newInputStr = JOptionPane.showInputDialog(instructions);
            }
            JOptionPane.showMessageDialog(null, "The smallest value was: " + smallestInputSoFar);
        }


        //compare newInput to smallestInput - if new is smaller, replace smallest, if new is bigger, input again
    }

    public static void main(String[] args){
        ex25_Smallest small = new ex25_Smallest();
        small.findSmallest();
    }

}
