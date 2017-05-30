package semester1.chapter4.section_4_5;

import javax.swing.JOptionPane;


public class Time_firstcopy extends Object
{
    private int itsHour;
    private int itsMin;

    /** Create an object for the given hour and minute.  If min
     *  is negative, adjust the values to make 0 <= min < 60. */

    public Time_firstcopy(int hour, int min)            // constructor
    { super();
        itsHour = hour;
        for (itsMin = min;  itsMin < 0;  itsMin = itsMin + 60)
            itsHour--;
    } //=======================

    /** Return the time expressed in military time. */

    public String toString(){
        return itsHour < 0 ? "0" + itsHour + itsMin : "" + itsHour + itsMin;
    }

    /** Return the result of adding this Time to that Time. */


    public Time_firstcopy add (Time_firstcopy that){
        Time_firstcopy valueObj = new Time_firstcopy(this.itsHour + that.itsHour, this.itsMin + that.itsMin);
        int valueInt = itsHour + itsMin;

        if(valueObj.itsMin >= 60){
            valueObj.itsMin -= 60;
            valueObj.itsHour++;
        }
        if(valueInt > 2359){
            valueInt = valueInt - 2400;
        }

        /*
        OR could have done--- why does it work?
        if(sum.itsHour > 2359)
                sum.itsHour %= 24;
         */
        return valueObj;
    }

    public static void main (String[] args)
    { Time_firstcopy t1 = new Time_firstcopy(13, 25);
        Time_firstcopy t2 = new Time_firstcopy(8, -150);
        JOptionPane.showMessageDialog (null, "1 " + t1.toString());
        JOptionPane.showMessageDialog (null, "2 " + t2.toString());
        Time_firstcopy t3 = t1.add (t2);
        JOptionPane.showMessageDialog (null, "3 " + t3.toString());
        t1 = t2.add (t3);
        JOptionPane.showMessageDialog (null, "1 " + t1.toString());
        System.exit (0);
    }
}