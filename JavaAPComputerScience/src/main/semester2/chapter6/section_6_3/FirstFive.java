package semester2.chapter6.section_6_3;

import javax.swing.*;


public class FirstFive {

    public static boolean sameFirstFive(String one, String two){
        return one != null && two != null
                && one.length() >= 5 && two.length() >= 5
                && one.substring(0, 5).equals(two.substring(0, 5));
    }



    public static void main(String[] args) {

        String one = JOptionPane.showInputDialog("Input the first String: ");
        String two = JOptionPane.showInputDialog("Input the second String: ");

        System.out.println(sameFirstFive(one, two));
    }
}
