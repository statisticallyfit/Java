package main.bookAP.Chapter3_PolyAbsInt.Interfaces.Ex1;


public class Tiger extends AnimalImpl {

    public Tiger(String name, String breed) {
        super(name, breed);
    }

    @Override
    public boolean livesInClimate(Climate climate) {
        return Climate.BOREAL == climate;
    }
}
