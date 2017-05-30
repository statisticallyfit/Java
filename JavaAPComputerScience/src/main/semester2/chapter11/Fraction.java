package semester2.chapter11;

public class Fraction extends Numeric {

    public static final Fraction ZERO = new Fraction (0, 1);
    private int numerator;  // the numerator of the fraction
    private int denominator;  // the denominator of the fraction


    /** Construct a Fraction from the given two integers. */

    public Fraction (int num, int denom) {
        if (num == 0 || denom == 0) {
            this.numerator = 0;
            denominator = 1;

        } else if (denom < 0) {
            this.numerator = - num;
            denominator = - denom;
            this.reduceToLowestTerms();

        } else {
            this.numerator = num;
            this.denominator = denom;
            this.reduceToLowestTerms();
        }
    }


    /** The parameter should be two ints separated by '/', e.g.
     *  "2/3".  Return null if par is null or "".  Otherwise
     *  throw a NumberFormatException if the wrong form. */

    public Numeric valueOf (String par) {
        if (par == null || par.length() == 0)
            return null;
        int k = 0;
        while (k < par.length() - 1 && par.charAt (k) != '/')
            k++;
        return new Fraction
                (Integer.parseInt (par.substring (0, k)),
                        Integer.parseInt (par.substring (k + 1)));
    }

    /** Express the Fraction as a String, e.g., "2/3". */

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }


    /** Tell whether the two Fraction objects are equal. */

    public boolean equals (Object ob) {
        return ob instanceof Fraction
            && ((Fraction) ob).numerator == this.numerator
            && ((Fraction) ob).denominator == this.denominator;
    }


    /** Return the sum of the executor and par. */

    public Numeric add (Numeric par) {
        Fraction that = (Fraction) par;    // for simplicity
        return new Fraction (this.numerator * that.denominator
                + this.denominator * that.numerator,
                this.denominator * that.denominator);
    }

    /** Reduce the fraction to lowest terms.  Precondition:  the
     *  denominator is positive and the numerator is non-zero. */

    private Fraction reduceToLowestTerms() {
        divideOut (2);
        int limit = Math.min (Math.abs (numerator), denominator);
        for (int divider = 3;  divider <= limit;  divider += 2)
            divideOut (divider);
        return this;
    }

    /** "Cancel" out divider as much as possible.  Precondition:
     *  numerator, denominator, and divider are all non-zero. */

    private void divideOut (int divider) {
        while (numerator % divider == 0 && denominator % divider == 0) {
            numerator /= divider;
            denominator /= divider;
        }
    }

    /** Return the approximate value as a double value. */

    public double doubleValue() {
        return numerator * 1.0 / denominator;
    }

    // these three are stubbed and left as exercises
    public int compareTo (Object ob)             { return 0; }
    public Numeric subtract (Numeric par)         { return null; }
    public Numeric multiply (Numeric par)         { return null; }

}
