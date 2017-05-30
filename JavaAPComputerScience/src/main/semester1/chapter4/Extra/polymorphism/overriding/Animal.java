package semester1.chapter4.Extra.polymorphism.overriding;

/**
 * Created by user1928 on 12/14/14.
 */

/*
 * SECOND WAY OF CALLING OVERRIDDEN METHOD...
 */
public class Animal
{
    protected void methodToOverride() //Base class method
    {
        System.out.println ("I'm the method of Animal");
    }
}
class Kangaroo extends Animal
{
    public Kangaroo() {
        super.methodToOverride();
    }
    public void methodToOverride() //Derived Class method
    {
        System.out.println ("I'm the method of Kangaroo");
    }

    public void secondWayToOverride(){
        super.methodToOverride(); //this prints "I'm a method of Animal"
    }
}

class TestAnimal
{
    public static void main (String args []) {
        // Animal reference and object
        Animal animal = new Animal();

        // Animal reference but Kangaroo object
        Animal kangarooObjAnimalRef = new Kangaroo();

        //Kangaroo reference and obj since cannot have Animal reference since Animal cannot access secondWayToOverride()
        Kangaroo kangarooObjAndRef = new Kangaroo();


        animal.methodToOverride();
        System.out.println();
        kangarooObjAnimalRef.methodToOverride();
        System.out.println();
        kangarooObjAndRef.methodToOverride();
        System.out.println();
        kangarooObjAndRef.secondWayToOverride();
    }
}


/*
 * Rules for Method Overriding:

 * overriding method in subclass overrides overridden method in superclass
 * same return types
 * same signatures
 * overriding method cannot have more restrictive access modifier
 * static and final methods CANNOT be overridden
 * constructors cannot be overridden
 * is called runtime polymorphism since the object type not reference type determines which overridden method is used
 *
 */