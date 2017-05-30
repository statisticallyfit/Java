package main.ExamPractice.freeresponse.FR8;


import java.util.ArrayList;
import java.util.List;

public abstract class Ticket {

    private int serialNumber;

    public Ticket(){
        serialNumber = getNextSerialNumber();
    }

    public abstract double getPrice();

    public String toString(){
        return "Number: " + serialNumber + "\nPrice: " + getPrice();
    }

    public static int getNextSerialNumber(){
        return (int) (Math.random() * (999 - 100 + 1)) + 100;
    }
}



class Advance extends Ticket {
    private int daysInAdvance;

    public Advance(int numDays){
        //super();
        this.daysInAdvance = numDays;
    }

    public double getPrice(){
        return (daysInAdvance >= 10) ? 30.0 : 40.0;
    }
}



class StudentAdvance extends Advance {

    public StudentAdvance(int numDays){
        super(numDays);
    }

    public String toString(){
        return super.toString() + "\n(student ID required)";
    }

    public double getPrice(){
        return 15.0;
    }
}

class Q3Tester{

    public static void main(String[] args) {

        /* Testing Advance */

        Advance a1 = new Advance(10);
        Advance a2 = new Advance(9);

        System.out.println("a1 " + a1);
        System.out.println("a2 " + a2);


         /* Testing Student Advance */
        StudentAdvance s1 = new StudentAdvance(10);
        StudentAdvance s2 = new StudentAdvance(30);

        System.out.println("s1 " + s1);
        System.out.println("s2 " + s2);
    }
}