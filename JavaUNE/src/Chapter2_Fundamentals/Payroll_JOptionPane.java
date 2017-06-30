package Chapter2_Fundamentals;

import javax.swing.JOptionPane;
/**
 *
 */
public class Payroll_JOptionPane {

    public static void main(String[] args) {
        String inputter;
        String name = JOptionPane.showInputDialog("What is your name? ");
        int hoursWorked;
        double payRate;
        double grossPay;

        inputter = JOptionPane.showInputDialog("How many hours did you work? ");
        hoursWorked = Integer.parseInt(inputter);

        inputter = JOptionPane.showInputDialog("What is your hourlypay rate? ");
        payRate = Double.parseDouble(inputter);

        grossPay = hoursWorked * payRate;

        JOptionPane.showMessageDialog(null, "Hello " +
            name + ". Your gross pay is $" + grossPay);


        System.exit(0);
    }
}
