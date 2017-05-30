package semester1.chapter4.Extra.overloading;

/**
 * Created by user1928 on 12/14/14.
 */
class OverloadPrimitiveType
{
    private void demo (int a)
    {
        System.out.println ("a: " + a);
    }
    public void demo(int a, int b)
    {
        System.out.println ("a and b: " + a + "," + b);
    }
    public double demo(double a) {
        System.out.println("double a: " + a);
        return a*a;
    }
    public static double demo(double a, double b){
        return a * b;
    }
}

class OverloadReferenceType {



}
class MethodOverloading
{
    public static void main (String args [])
    {
        OverloadPrimitiveType obj = new OverloadPrimitiveType();
        double result;
        obj.demo(10);
        obj.demo(10, 20);
        result = obj.demo(5.5);
        System.out.println("O/P : " + result);

        //OverloadPrimitiveType.demo(43 * 2);

    }
}


/*
 *Rules for Method Overloading

 * overloaded methods occur in the same class
 * parameter list must differ in type and/or amount
 * return type is irrelevant
 * access modifier cannot be more restrictive (going from overloaded to last overloader)
 * static methods CAN be overloaded
 * called compile time polymorphism.
 *
 */