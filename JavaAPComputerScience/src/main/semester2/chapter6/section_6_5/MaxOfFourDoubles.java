package semester2.chapter6.section_6_5;


/*Exercise 6.37*/

public class MaxOfFourDoubles {

    public static double largestOfFour(double x, double y, double z, double w){
        return Math.max(Math.max(Math.max(x, y), z), w);
    }

    public static void main(String[] args) {
        //uses implicit widening conversion of int to double
        System.out.println(largestOfFour(4.0, 3, 90, -100));
    }
}
