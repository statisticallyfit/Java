package main.bookNutshell.exercise_2_1;


public class ComplexNumber {

    private double a;
    private double b;

    public ComplexNumber(double real, double imaginary){
        this.a = real;
        this.b = imaginary;
    }

    public double real(){
        return a;
    }

    public double imaginary(){
        return b;
    }

    /** Compute the magnitude of a complex number **/
    public double magnitude(){
        return Math.sqrt(a*a + b*b);
    }

    public String toString(){
        if(this.imaginary() >= 0)
            return "(" + a + " + " + b + "i)";
        return "(" + a + " - " + Math.abs(b) + "i)";
    }

    public ComplexNumber add(ComplexNumber other){
        return new ComplexNumber(this.a + other.a, this.b + other.b);
    }

    public ComplexNumber subtract(ComplexNumber other){
        return new ComplexNumber(this.a - other.a, this.b - other.b);
    }

    public ComplexNumber multiply(ComplexNumber other){
        return new ComplexNumber(this.a * other.a, this.b * other.b);
    }

    public ComplexNumber conjugate(){
        return new ComplexNumber(this.a, -this.b);
    }
}


class ComplexNumberRunner {

    public static void main(String[] args){
        ComplexNumber num1 = new ComplexNumber(3, -2);
        ComplexNumber num2 = new ComplexNumber(4, 7);

        System.out.println(num1.add(num2));
        System.out.println(num1.subtract(num2));
        System.out.println(num1.multiply(num2));
        System.out.println(num2.conjugate());
    }
}