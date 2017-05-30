package main.bookAP.Chapter3_PolyAbsInt.Abstracts;


import java.util.Scanner;

abstract class Shape {
    private String name;

    public Shape(String shapeName){
        name = shapeName;
    }

    public String getName(){
        return name;
    }

    public abstract double area();
    public abstract double perimeter();

    public double semiPerimeter(){
        return perimeter()/2;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double cRadius, String cName){
        super(cName);
        radius = cRadius;
    }

    public double perimeter(){
        return 2 * Math.PI * radius;
    }
    public double area(){
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    private double side;

    public Square(double sqSide, String sqName){
        super(sqName);
        side = sqSide;
    }

    public double perimeter(){
        return 4 * side;
    }
    public double area(){
        return side * side;
    }
}

public class ShapeTester {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Shape circ = new Circle(10, "circle");
        Shape sq = new Square(9.4, "square");
        Shape s = null;
        System.out.println("Which shape? ");
        String str = scan.next();
        if(str.equals("circle"))
            s = circ;
        else if (str.equals("square"))
            s = sq;

        System.out.println(s.perimeter());
        System.out.println(s.getName());
        System.out.println(s.area());
    }
}

/**
 * Rules for Abstract classes
 *
 * abstract class can have both instance variables and concrete (nonabstract) methods
 * not possible to create object of an abstract class
 * methods can be public or private
 * An abstract class can have no visible abstract methods: can all be inherited from
 *          an abstract superclass.
 * Abstract class could have constructors (not necessary)
 *
 * Also,
 *      Shape a = new Shape() // NOT legal
 *      Shape c = new Circle() //legal
 *
 */


/**
 * Rules for Interfaces
 *
 * interface cannot have instance variables
 * no method implementations
 * all methods are public
 * not possible to create object of interface
 * A subclass of a class that implements the interface will implement the interface automatically
 * A subclass can also directly implement interface it inherits
 * A subclass can implement many interfaces; can extend only one superclass
 *
 */