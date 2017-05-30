package semester2.chapter7.section_7_2_and_7_4.Fruit;


import java.util.Comparator;

public class FruitQuantityComparator implements Comparator<Fruit> {
    @Override
    public int compare(Fruit fruit1, Fruit fruit2) {
        //return fruit1.getQuantity()  - fruit2.getQuantity();
        return fruit1.compareByQuantity(fruit2);
    }
}
