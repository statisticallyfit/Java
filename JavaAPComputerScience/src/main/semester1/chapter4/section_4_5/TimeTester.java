package semester1.chapter4.section_4_5;

import javax.swing.JOptionPane;

/**
 * Created by user1928 on 11/25/14.
 */
public class TimeTester {

    public static void main(String[] args) {
        Time t1 = new Time(0, 13, 25);
        Time t2 = new Time(0, 14, 20); //changed from 8, -150
        Time t4 = new Time(4, -4, -90);
        Time t5 = new Time(1, -3, -12);

        JOptionPane.showMessageDialog(null, "This is test1:    " + t1.toString());
        JOptionPane.showMessageDialog(null, "This is test2:    " + t2.toString());

        Time t3 = t1.add(t2);

        JOptionPane.showMessageDialog(null, "This is test3:    " + t3.toString());

        t1 = t2.add(t3);

        JOptionPane.showMessageDialog(null, "This is test4:    " + t1.toString());

        Time t6 = t4.add(t5);
        Time t7 = t4.subtract(t5);

        JOptionPane.showMessageDialog(null, "This is test5:    " + t6.toString()); //should be 6, 15, 8
        JOptionPane.showMessageDialog(null, "This is test6:    " + t7.toString()); //should be 3, 21, 42

    }
}
