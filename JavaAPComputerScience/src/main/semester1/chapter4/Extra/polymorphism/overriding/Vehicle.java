package semester1.chapter4.Extra.polymorphism.overriding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user1928 on 12/14/14.
 */

/*
 * FIRST WAY OF CALLING OVERRIDDEN METHOD...
 */
public class Vehicle {

    public String getType() {
        return "vehicle";
    }

    public static void move() {
        System.out.println("Vehicle");
    }
    public void makeNoise(){
        System.out.println("Generic noise");
    }
}

class Car extends Vehicle {

    public String getType() {
        return "car";
    }

    public String getParentType() {
        return super.getType();
    }

    public static void move() {
        //super.move(); // invokes the super class method
        System.out.println("Car");
    }

    public void makeNoise(){
        System.out.println("Honk honk!");
    }
}

class TestCar {
    public static void main (String args []){
        /*Vehicle b = new Car(); // Vehicle reference but Car object
        b.move(); //Calls the method in Car class*/

        //this works -- not overriding
        Vehicle.move();
        Car.move();

        List<Vehicle> vehicles = new ArrayList<Vehicle>(3);
        vehicles.add(new Vehicle());
        vehicles.add(new Car());
        vehicles.add(new Vehicle());

        /*if(koko) {
            vehicles.add(koko2 ? new Vehicle() : new Car());

        }
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getType());
        }

        Vehicle o1 = new Vehicle();

        if(koko) {
            o1 = new Car();
        }

        Vehicle.move();
        new Car().getParentType();*/


        Vehicle vehicle = new Vehicle();
        Vehicle car = new Car();

        System.out.println("Stuff at the end");

        vehicle.makeNoise();
        car.makeNoise();

        System.out.println("Now statics");

        Vehicle.move();
        Car.move();

    }
}