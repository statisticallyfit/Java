package semester1.chapter4.Extra.polymorphism.overriding;



public class Bicycle {

    // the Bicycle class has
    // three fields
    public int itsCadence;
    public int itsGear;
    public int itsSpeed;

    // the Bicycle class has
    // one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        this.itsGear = startGear;
        this.itsCadence = startCadence;
        this.itsSpeed = startSpeed;
    }

    // the Bicycle class has
    // four methods
    public void setCadence(int newValue) {
        this.itsCadence = newValue;
    }

    public void setGear(int newValue) {
        this.itsGear = newValue;
    }

    public void applyBrake(int decrement) {
        this.itsSpeed -= decrement;
    }

    public void speedUp(int increment) {
        this.itsSpeed += increment;
    }

    public void printDescription(){
        System.out.println("\nBike is " + "in gear " + this.itsGear
                + " with a cadence of " + this.itsCadence +
                " and travelling at a speed of " + this.itsSpeed + ". ");
    }

}

class MountainBike extends Bicycle {
    private String itsSuspension;

    /*
     *** if there is no default constructor in superclass
     * and you make default in subclass, compiler error occurs
     *
     *** but if there is a default constructor in superclass
     * default in subclass is legal.
     */

    /*public MountainBike(){
        super();
        itsSuspension = "";
    }*/
    public MountainBike(int startCadence, int startSpeed, int startGear, String suspensionType){
        super(startCadence, startSpeed, startGear);
        this.setSuspension(suspensionType);
    }

    public String getSuspension(){
        return this.itsSuspension;
    }

    public void setSuspension(String suspensionType) {
        this.itsSuspension = suspensionType;
    }

    public void printDescription() {
        super.printDescription();
        System.out.println("The MountainBike has a " +
                getSuspension() + " suspension.");
    }
}

class RoadBike extends Bicycle{
    // In millimeters (mm)
    private int itsTireWidth;

    public RoadBike(int startCadence, int startSpeed, int startGear, int newTireWidth){
        super(startCadence, startSpeed, startGear);
        this.setTireWidth(newTireWidth);
    }

    public int getTireWidth(){
        return this.itsTireWidth;
    }

    public void setTireWidth(int newTireWidth){
        this.itsTireWidth = newTireWidth;
    }

    public void printDescription(){
        super.printDescription();
        System.out.println("The RoadBike" + " has " + getTireWidth() +
                " MM tires.");
    }
}


class TestBikes {
    public static void main(String[] args){
        Bicycle bike, mtbike, rdbike; //all of type Bicycle

        //all their own specific objects
        bike = new Bicycle(20, 10, 1);
        mtbike = new MountainBike(20, 10, 5, "Dual");
        rdbike = new RoadBike(40, 20, 8, 23);

        bike.printDescription();
        mtbike.printDescription();
        rdbike.printDescription();
    }
}
