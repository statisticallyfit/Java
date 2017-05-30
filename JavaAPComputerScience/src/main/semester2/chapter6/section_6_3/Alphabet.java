package semester2.chapter6.section_6_3;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;



/*Manual sorting not efficient!*/
/*for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                anotherFirst = list.get(i + 1);
                if (first.compareTo(anotherFirst) >= 0) {
                    first = anotherFirst;
                }//else first stays the same
            }
        }
        return first;*/




/*Assignment 6.21*/

public class Alphabet {

    private static class StringWithComparator implements Comparator<String> {

        public int compare(String s1, String s2) {
            return s1.compareTo(s2); //the compareTO() method doesn't need to be implemented since String argument is given, and String already implements compareTo()
        }
    }

    public static String getFirstString(String one, String two, String three) {

        String[] strings = new String[]{one, two, three};
        Arrays.sort(strings, new StringWithComparator());
        return strings[0]; //now the first one
    }

    public static void main(String[] args) {
        String one = JOptionPane.showInputDialog("Input the first string: ");
        String two = JOptionPane.showInputDialog("Input the second string: ");
        String three = JOptionPane.showInputDialog("Input the three string: ");

        System.out.println("The first one is: " + getFirstString(one, two, three));
    }



    /*TESTING */
    public static void checkCorrectness(){
        /*No tests failed!*/
        if (!getFirstString("a", "b", "c").equals("a") || !getFirstString("c", "b", "a").equals("a")) {
            System.err.println("Test 1 failed");
        }
        if (!getFirstString("f", "f", "f").equals("f")) {
            System.err.println("Test 2 failed");
        }
        if (!getFirstString("a", "a", "c").equals("a")) {
            System.err.println("Test 3 failed");
        }
        if (!getFirstString("c", "a", "a").equals("a")) {
            System.err.println("Test 4 failed");
        }
        if (!getFirstString("b", "b", "a").equals("a")) {
            System.err.println("Test 5 failed");
        }
        if (!getFirstString("b", "a", "c").equals("a")) {
            System.err.println("Test 6 failed");
        }
        if (!getFirstString("a", "c", "b").equals("a")) {
            System.err.println("Test 7 failed");
        }
        if (!getFirstString("n", "p", "m").equals("m")) {
            System.err.println("Test 8 failed");
        }
        if(!getFirstString("nutty", "potato", "mouse").equals("mouse")){
            System.err.println("Test 9 failed!");
        }
    }
}
