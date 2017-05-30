
package semester2.chapter6.section_6_3;


/*todo: PRESS "Control H" on interface to see classes that implement the interface
* todo: PRESS " Control Shift H" on method*/

import java.util.Date;

/*the compareTo() method does not need to be implemented because
* when using the Comparable type arguments, we can pass in any class
* that implements Comparable interface. That class also implements
* the compareTo() method*/

 public class ComparableExample {

    public static String ordered(Comparable x, Comparable y, Comparable z){ //names are arbitrary!
        if(x.compareTo(y) == 0){
            return (y.compareTo(z) <= 0) ? "in ascending order" : "in descending order";
        }
        else if(x.compareTo(y) < 0){
            return (y.compareTo(z) < 0) ? "in ascending order" : "not in order";
        }
        else{ // sun, then pony
            return (y.compareTo(z) < 0) ? "not in order" : "in descending order";
        }
    }

    public static void main(String[] args) {
        System.out.println(ordered("g", "i", "p")); //in ascending order
        System.out.println(ordered("p", "i", "g")); //in descending order
        System.out.println(ordered("i", "p", "g")); //not in order

        Date a = new Date(2015, 3, 4);
        Date b = new Date(2015, 4, 5);
        Date c = new Date(2015, 5, 6);

        System.out.println(ordered(a, b, c)); //in ascending order
    }
}

/*Source: @todo http://examples.javacodegeeks.com/java-basics/java-comparable-example/
* @todo http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
* @todo http://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html*/