package semester2.chapter6.section_6_5;

import java.util.Date;


/*Assignment 6.42 */

public class LongOverflow {
    public static void main(String[] args) {
        System.out.println("The long value will overflow on: " + new Date(Long.MAX_VALUE));
    }
}
