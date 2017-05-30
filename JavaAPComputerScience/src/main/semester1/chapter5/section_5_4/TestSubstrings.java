package semester1.chapter5.section_5_4;


import java.util.ArrayList;

import static java.lang.System.*;

/**
 * Created by user1928 on 12/17/14.
 */
public class TestSubstrings {

    private final static String[] SECRETWORDLIST = {"algae", "horse", "music", "flute", "dough", "silver"};

    public void usingStringsMethods(){

        String word = "airplane";
        out.println(word.charAt(3)); // result = p

        out.println("Concat 1: " + word.concat(" in the sky!"));
        out.println("Changed or not??? : " + word);
        out.println("\"Concat 2\":  Word itself is unchanged: " + word + " above the clouds");
        word += 123;
        out.println(word);
        word += " soaring high";
        out.println("Concat 3: Word is changed: " + word);
        out.println(word);

        String word2 = "airplane";
        out.println(word2.equalsIgnoreCase("AIRPLANE")); //true
        out.println(word2.equalsIgnoreCase("airlapne")); //false

        out.println(word2.length());
        out.println(word2.replace("p", "FLYP"));
        out.println(word2.replace("p", "FLYP").toLowerCase());

        String sub = "0123456789";
        out.println(sub.substring(2) + " and " + sub.substring(8));
        out.println(sub.substring(2, 8)); //prints out from START and ends at END - 1
        out.println(sub.substring(1, 9));
        out.println(sub.substring(5, 6) + " is same as " + sub.charAt(5)); // 5  only
        System.out.println("OVER HERE LOOK " + sub.substring(9, 10));

        out.println(sub.toString()); //do nothing method

        String uglyTitle = "T he La st      Cr usad e             ";
        out.println(uglyTitle);
        out.println(uglyTitle + "x");
        out.println("Formatted title: " + uglyTitle.trim() + "x");
        out.println(uglyTitle.replace(" ", ""));

        String prettyTitle = uglyTitle.replace(" ", "").replace("eL", "e L").replace("tC", "t C");
        out.println(prettyTitle);

        String testing = "012345";
        System.out.println("OVER HERE MAN: " + testing.substring(0, 5)); //predict print: 01234
        System.out.println("OVER HERE MAN: " + testing.substring(0, testing.length())); //print 012345
        System.out.println(testing.substring(1));

        ArrayList<String> itsPastIndexes = new ArrayList<String>();
        itsPastIndexes.add("0");
        itsPastIndexes.add("1");
        itsPastIndexes.add("2");

        out.println(itsPastIndexes.contains("2"));
    }


    public static void main(String[] args){
        TestSubstrings tester = new TestSubstrings();
        tester.usingStringsMethods();
    }
}
