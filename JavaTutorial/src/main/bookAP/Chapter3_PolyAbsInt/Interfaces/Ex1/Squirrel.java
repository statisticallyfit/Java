package main.bookAP.Chapter3_PolyAbsInt.Interfaces.Ex1;

/**
 * Created by user1928 on 3/21/2015.
 */
public class Squirrel extends AnimalImpl {

    public Squirrel(String name, String breed) {
        super(name, breed);
    }

    @Override
    public boolean livesInClimate(Climate climate) {
        return Climate.TEMPERATE == climate;
    }
}
