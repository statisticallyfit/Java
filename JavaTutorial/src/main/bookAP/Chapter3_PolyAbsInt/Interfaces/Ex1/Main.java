package main.bookAP.Chapter3_PolyAbsInt.Interfaces.Ex1;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Tiger("fluffy", "big cats"),
                new Squirrel("bushy", "nut eater")};

        for (Animal a : animals) {
            if(a.livesInClimate(Climate.BOREAL)) {
                System.out.println(a.getName() + " lives in " + Climate.BOREAL);
            }
        }
//        assert t.livesInClimate(Climate.BOREAL) : "Lives in forests";
//        assert t.livesInClimate(Climate.TEMPERATE) : "Lives at tropics";
    }
}
