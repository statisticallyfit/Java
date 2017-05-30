package semester1.chapter4.section_4_2;

import javax.swing.JOptionPane;

/**
 * Created by user1928 on 11/14/14.
 */
public class ex1_EqualOrDifferentStrings_assignment {


    public String getFirstString() {
        String firstString = JOptionPane.showInputDialog("Enter the number of the day you were born");
        if(firstString == null || firstString.equals("")) {
            JOptionPane.showMessageDialog(null, "Stop fooling around!");
        }
        return firstString;
    }

    public String getSecondString() {
        String secondString = JOptionPane.showInputDialog("Enter the number of the month you were born");
        if(secondString == null || secondString.equals("")) {
            JOptionPane.showMessageDialog(null, "Stop fooling around!");
        }
        return secondString;
    }

    public void doStringComparison(){

        for (int tries = 3; tries > 0; tries--) {

            String firstString = getFirstString();
            String secondString = getSecondString();

            if ((firstString == null || firstString.isEmpty()) || (secondString == null || secondString.isEmpty())) {
                System.out.println("This fool is wasting tries..."); //my log
                //give different showUpdatedStatus if tries are 0
                if((tries-1)==0){
                    JOptionPane.showMessageDialog(null, "Tries expired");
                    break;
                }
                JOptionPane.showMessageDialog(null, "You have " + (tries - 1) + " tries left");
            } else {

                JOptionPane.showMessageDialog(null, firstString.equals(secondString) ?
                        "Equal input " : "Different input ");
                break;
            }
        }
    }

    public static void main(String[] args) {

        ex1_EqualOrDifferentStrings_assignment obj = new ex1_EqualOrDifferentStrings_assignment();

        obj.doStringComparison();

    }

}


//            //get second string
//            for (int tries = 3; tries >= 0; tries--) {
//                if (tries == 0) {
//                    if (obj.getSecondString().equals("")) {
//                        JOptionPane.showMessageDialog(null, "Sorry, your tries expired");
//                        break;
//                    }
//                }
//            }
//

//if strings are equal but not null, say "Equal"
//        if(firstStr.equals(secondStr) && (!firstStr.equals("")) && (!firstStr.equals(""))){
//            JOptionPane.showMessageDialog(null, "Equal birth date and month");
//        }
//        //if strings are not and not null, say "Equal"
//        if(!firstStr.equals(secondStr) && (!firstStr.equals("")) && (!firstStr.equals(""))){
//            JOptionPane.showMessageDialog(null, "Different birth date and month");
//        }
//        //if  strings are equal and are null, say so
//        else if(firstStr.equals(secondStr) && firstStr.equals("") && firstStr.equals("")){
//            JOptionPane.showMessageDialog(null, "You entered no values. Cannot report");
//        }
//        //if either string is null, say so
//        else if((firstStr.equals("") && !secondStr.equals("")) || (!firstStr.equals("") && secondStr.equals(""))) {
//            JOptionPane.showMessageDialog(null, "Either input is null. Cannot report");
//        }

