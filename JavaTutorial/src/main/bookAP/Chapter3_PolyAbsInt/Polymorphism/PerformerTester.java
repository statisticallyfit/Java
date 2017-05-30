package main.bookAP.Chapter3_PolyAbsInt.Polymorphism;


class Dancer{
    public void act(){
        System.out.print(" spin");
        doTrick();
    }

    public void doTrick(){
        System.out.print(" float");
    }
}

class Acrobat extends Dancer {
    public void act(){
        super.act();
        System.out.print(" flip");
    }

    public void doTrick(){
        System.out.print(" somersault");
    }

    public void makeNoise(){
        System.out.println(" FWOOP!");
    }
}

public class PerformerTester {

    public static void main(String[] args) {
        Dancer d = new Acrobat();
        Acrobat a = new Acrobat();
        d.act();

        System.out.println();

        //d.makeNoise(); //compiler error since d is Dancer type and Dancer has no makeNoise() method
        a.makeNoise();
        ((Acrobat)d).makeNoise();
    }
}

/**
 * Rules for subclasses:
 *
 * subclass cannot redefine public method as private
 * subclass must define its own constructor (else compile time error occurs if superclass has no default)
 *
 *      =>  if there is no default constructor in superclass
 *          and you make default in subclass, compiler error occurs
 *      =>  But if there is a default constructor in superclass
 *          default in subclass is legal.
 *
 *
 * For a.method(b), where Parent a = Child()
 *      =>  at compile time, method must be found in Parent. If not, need explicit cast to Child
 *          (true whether or not method is polymorphic)
 *      =>
 */