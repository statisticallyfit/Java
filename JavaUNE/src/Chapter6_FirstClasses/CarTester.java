package Chapter6_FirstClasses;

/**
 *
 */

class Car {

    private int yearModel;
    private String make;
    private int speed;
    // int hyena; // note: if you do not put private, it is public.

    public Car(int carYearModel, String carMake){
        this.yearModel = carYearModel;
        this.make = carMake;
        this.speed = 0;
    }

    public void setYearModel(int newYearModel){ this.yearModel = newYearModel; }
    public void setMake(String newMake){ this.make = newMake; }
    public void setSpeed(int newSpeed){ this.speed = newSpeed; }

    public int getYearModel() { return yearModel; }
    public String getMake() { return make; }
    public int getSpeed() { return speed; }

    public void accelerate(){
        speed += 5;
    }

    public void brake(){
        speed -= 5;
    }
}


public class CarTester {

    public static void displayInfo(Car car){
        System.out.println(String.format("%d, %s. Speed: %d",
                car.getYearModel(), car.getMake(), car.getSpeed()));
    }

    public static void main(String[] args) {
        Car car = new Car(1945, "Mercedes");

        displayInfo(car);

        for(int i = 1; i <= 5; i++){
            car.accelerate();
        }

        displayInfo(car);

        for(int i = 1; i <= 5; i++){
            car.brake();
        }

        displayInfo(car);
    }
}

