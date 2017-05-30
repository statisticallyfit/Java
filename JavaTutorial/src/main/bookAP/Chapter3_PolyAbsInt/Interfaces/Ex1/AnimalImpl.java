package main.bookAP.Chapter3_PolyAbsInt.Interfaces.Ex1;

/**
 * Created by user1928 on 3/21/2015.
 */
public abstract class AnimalImpl implements Animal {

    String name;
    String breed;

    public AnimalImpl(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public abstract boolean livesInClimate(Climate climate);
}
