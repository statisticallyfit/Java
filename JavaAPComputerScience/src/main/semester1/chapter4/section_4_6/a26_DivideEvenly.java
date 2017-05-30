package semester1.chapter4.section_4_6;

import javax.swing.*;

/**
 * Created by user1928 on 12/12/14.
 */
public class a26_DivideEvenly {

    public void getInput(){
        //state instructions
        JOptionPane.showMessageDialog(null, "Input two numbers by clicking 'OK' after each one. " +
                "When done, click 'CANCEL'");

        //input
        String firstNumStr = JOptionPane.showInputDialog("First number is: ");
        String secondNumStr = JOptionPane.showInputDialog("Second number is: ");

        //parse
        int firstNum = Integer.parseInt(firstNumStr);
        int secondNum = Integer.parseInt(secondNumStr);

        checkIfEvenDivision(firstNum, secondNum);
    }

    public void checkIfEvenDivision(int firstNum, int secondNum){

        if(firstNum >= secondNum){

            if((firstNum % secondNum) == 0){
                JOptionPane.showMessageDialog(null, "The two inputs divide evenly");

            }else if((firstNum % secondNum) != 0){
                JOptionPane.showMessageDialog(null, "No even division");
            }

        }else if (secondNum >= firstNum){
            if((secondNum % firstNum) == 0){
                JOptionPane.showMessageDialog(null, "The two inputs divide evenly");

            }else if((secondNum % firstNum) != 0){
                JOptionPane.showMessageDialog(null, "No even division");
            }
        }
    }

    public static void main(String[] args){

        a26_DivideEvenly divideEvenly = new a26_DivideEvenly();
        divideEvenly.getInput();
    }
}
