package Chapter2_Fundamentals;

import javax.swing.JOptionPane;
/**
 *
 */
public class Name_JOptionPane {

    public static void main(String[] args) {
        String firstName = JOptionPane.showInputDialog("What is your first name? ");
        String middleName = JOptionPane.showInputDialog("What is your middle name? ");
        String lastName = JOptionPane.showInputDialog("What is your last name? ");

        JOptionPane.showMessageDialog(null, "Hello " + firstName +
                " " + middleName + " " + lastName);

        //note: absolutely need this otherwise thread continues running after end of main:
        System.exit(0);
    }
}
