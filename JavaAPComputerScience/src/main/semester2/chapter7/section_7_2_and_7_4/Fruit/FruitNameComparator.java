package semester2.chapter7.section_7_2_and_7_4.Fruit;

import java.util.Comparator;

public class FruitNameComparator implements Comparator<Fruit>{
    @Override
    public int compare(Fruit fruit1, Fruit fruit2)  {
        //using the compareTo method of String class
        return fruit1.getFruitName().toUpperCase().compareTo(
                fruit2.getFruitName().toUpperCase()); //ascending order
    }
}
