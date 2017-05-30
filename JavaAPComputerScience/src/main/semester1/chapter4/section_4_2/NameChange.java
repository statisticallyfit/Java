package semester1.chapter4.section_4_2;

import javax.swing.JOptionPane;

class NameChange {

    /*
    Ask user for first name and then last them, then print out in reverse order
     */

    public static void main(String[] args){
        JOptionPane.showMessageDialog(null,"Illustrate the use of JOptionPane methods");

        String firstName = JOptionPane.showInputDialog("What is your first name?");
        String lastName = JOptionPane.showInputDialog("What is your last name?");

        JOptionPane.showMessageDialog(null, "Reversed, your name is: " + lastName + ", " + firstName);

        //System.exit(0); //needed when using JOptionPane to terminate GUI interface
    }
}
