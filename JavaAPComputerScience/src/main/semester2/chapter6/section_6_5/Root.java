package semester2.chapter6.section_6_5;


/*Exercise 6.38*/

import java.util.ArrayList;
import java.util.List;

public class Root {

    public static void upToRoot(double num, double root){

        int i = 0;
        double multiplier = 2.0;
        List<Double> results = new ArrayList<Double>();

        do{
            results.add(Math.pow(num, (1/multiplier)));
            System.out.println(num + " to the root of " + multiplier + ": " + results.get(i));
            multiplier *= 2;
            i++;
        }while(multiplier <= root);
    }

    public static void main(String[] args) {
        upToRoot(256, 8);
    }
}
