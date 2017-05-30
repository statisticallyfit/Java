package semester2.chapter11;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class Numeric implements Comparable {

    public abstract Numeric valueOf (String par);
    public abstract String toString();
    public abstract double doubleValue();
    public abstract boolean equals (Object ob);
    public abstract int compareTo (Object ob);
    public abstract Numeric add (Numeric par);
    public abstract Numeric subtract (Numeric par);
    public abstract Numeric multiply (Numeric par);


    /** Return the larger of the two Numeric values. Throw an
     *  Exception if they are not both non-null values of the
     *  same Numeric type.*/

    public static Numeric max (Numeric data, Numeric other) {
        return (data.compareTo (other) > 0)  ?  data  :  other;
    }


    /** Return the square of the executor. */

    public Numeric square() {
        return this.multiply (this);
    }


    /** Read Numeric values from the BufferedReader and add them
     *  to the executor, until null is seen or until a value
     *  cannot be added to the executor.  Return the total. */

    public Numeric addMore(BufferedReader source) {
        Numeric total = this;
        try {
            Numeric data = this.valueOf(source.readLine());
            while (data != null && total != null) {
                total = total.add (data);
                data = this.valueOf(source.readLine());
            }
        } catch(Exception e) {
           // no need for any statements here; just return total
        }
        return total;
    }

    /* Exercise 11.2 */

    public static Numeric minOfThree(Numeric n1, Numeric n2, Numeric n3){
        Numeric minOfTwo = (n1.compareTo(n2) < 0) ? n1 : n2;
        return (minOfTwo.compareTo(n3) < 0) ? minOfTwo : n3;
    }

    /* Exercise 11.3*/

    public Numeric smallest(BufferedReader source){
        Numeric smallest = null;
        try {
            smallest = valueOf(source.readLine()); //arbitrarily first
            Numeric data = valueOf(source.readLine());
            while(smallest != null && data != null){
                if(data.compareTo(smallest) < 0)
                    smallest = data;
                data = valueOf(source.readLine());
            }
        } catch(Exception e) {
            e.getMessage();
        }
        return smallest;
    }
}

class NumericTester {
    public static void main(String[] args) {
        //testing minOfThree()
        /*Numeric one = new Fraction(3, 4);
        Numeric two = new Fraction(1, 3);
        Numeric three = new Fraction(1, 2);

        Numeric minResult = Numeric.minOfThree(one, two, three);
        System.out.println("Minimum of three test: " + minResult);*/

        //testing smallest()
        Numeric numericExec = new Fraction(0, 1); //values not needed

        try {
            Numeric smallest = numericExec.smallest(new BufferedReader(new FileReader("C:\\D\\tmp\\FractionFile.txt")));
            System.out.println("Smallest of list: " + smallest);
        } catch(FileNotFoundException fnf){
            fnf.getMessage();
        }
    }
}
