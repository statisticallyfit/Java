package semester2.chapter7.section_7_2_and_7_4.Fruit;

import java.util.*;


/*class SortFruitArrayList {

    public void sortFruitArrayListExample(){

        List<String> fruits = new ArrayList<String>();

        fruits.add("Pineapple");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");

        Collections.sort(fruits);

        int i=0;
        for(String temp: fruits){
            System.out.println("fruits " + ++i + " : " + temp);
        }
    }
}*/

//------------------------------------------------------------------------

class Fruit implements Comparable<Fruit> {


    /*
    * Source: http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
    */
    private String fruitName;
    private String fruitDesc;
    private int quantity;

    public Fruit(String fruitName, String fruitDesc, int quantity) {
        super();
        this.fruitName = fruitName;
        this.fruitDesc = fruitDesc;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Fruit " +
                "fruitName='" + fruitName + '\'' +
                ", fruitDesc='" + fruitDesc + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    /**
     * Internal work horse
     */
    int compareByQuantity(Fruit other) {
        System.out.println("Compare " + this + " with " + other);

        return this.quantity - other.getQuantity(); //ascending order
        //return compareByQuantity - this.quantity; //descending order
    }

    //used by the Arrays.sort() method, with no comparator flag
    @Override
    public int compareTo(Fruit o) {
        return this.compareByQuantity(o);
    }

    /**
     * @see #comparatorByName for a an alternative way to compare fruit
     */
    public static Comparator<Fruit> comparatorByName = new FruitComparatorByName(); //instantiates the class below

    private static class FruitComparatorByName implements Comparator<Fruit> {

        public int compare(Fruit fruit1, Fruit fruit2) {
            //using the compareTo method of String class
            return fruit1.getFruitName().toUpperCase().compareTo(
                    fruit2.getFruitName().toUpperCase()); //ascending order
        }
    }

    /**
     *
     */
    public static Comparator<Fruit> comparatorByQuantity = new Comparator<Fruit>() {

        public int compare(Fruit fruit1, Fruit fruit2) {
            //return fruit1.getQuantity()  - fruit2.getQuantity();
            return fruit1.compareByQuantity(fruit2);
        }
    };
}

class SortFruitObjects {

    public void printFruits(Fruit[] fruits) {
        int i = 0;
        for (Fruit aFruit : fruits) {
            System.out.println("fruits " + ++i + " : " + aFruit.getFruitName() +
                    ", Quantity : " + aFruit.getQuantity());
        }
    }

    public Fruit[] makeData() {
        Fruit[] fruits = new Fruit[14];

        fruits[0] = new Fruit("Banana", "Banana description", 2);
        fruits[1] = new Fruit("Banana", "Banana description", 2);
        fruits[2] = new Fruit("Banana", "Banana description", 2);
        fruits[3] = new Fruit("Banana", "Banana description", 2);
        fruits[4] = new Fruit("Apple", "Apple description", 2);
        fruits[5] = new Fruit("Orange", "Orange description", 2);
        fruits[6] = new Fruit("Blackberry", "Blackberry description", 2);
        fruits[7] = new Fruit("Orange", "Orange description", 2);
        fruits[8] = new Fruit("Strawberry", "Strawberry description", 2);
        fruits[9] = new Fruit("Strawberry", "Strawberry description", 2);
        fruits[10] = new Fruit("Blackberry", "Blackberry description", 2);
        fruits[11] = new Fruit("Mango", "Mango description", 2);
        fruits[11] = new Fruit("Licorice", "Licorice description", 2);
        fruits[12] = new Fruit("Peach", "Peach description", 2);
        fruits[13] = new Fruit("Peach", "Peach description", 2);

        /*fruits[0] = new Fruit("Banana", "Banana description", 20);
        fruits[1] = new Fruit("Banana", "Banana description", 112);
        fruits[2] = new Fruit("Banana", "Banana description", 2);
        fruits[3] = new Fruit("Banana", "Banana description", 200);
        fruits[4] = new Fruit("Banana", "Apple description", 276);
        fruits[5] = new Fruit("Banana", "Orange description", 234);
        fruits[6] = new Fruit("Banana", "Blackberry description", 212);
        fruits[7] = new Fruit("Banana", "Orange description", 29);
        fruits[8] = new Fruit("Banana", "Strawberry description", 23);
        fruits[9] = new Fruit("Banana", "Strawberry description", 24);
        fruits[10] = new Fruit("Banana", "Blackberry description", 25);
        fruits[11] = new Fruit("Banana", "Mango description", 72);
        fruits[11] = new Fruit("Banana", "Licorice description", 92);
        fruits[12] = new Fruit("Banana", "Peach description", 42);
        fruits[13] = new Fruit("Banana", "Peach description", 22);*/

        return fruits;
    }

    public void sortFruits() {

        Fruit[] fruits = makeData();
        {
            System.out.println("Before sorting: ");
            printFruits(fruits);
        }

        {
            // this sorts by quantity
            fruits = makeData();
            Arrays.sort(fruits);
            System.out.println("\n\nAfter sorting by quantity");
            printFruits(fruits);
        }

        {
            fruits = makeData();
            //this also sorts by quantity but using the comparator
            Arrays.sort(fruits, Fruit.comparatorByQuantity);
            System.out.println("\n\nAfter sorting by quantity with comparator");
            printFruits(fruits);
        }

        {
            fruits = makeData();
            // this sorts by name using the comparator
            Arrays.sort(fruits, Fruit.comparatorByName);
            System.out.println("\n\nAfter sorting by name with comparator");
            printFruits(fruits);
        }

        {
            fruits = makeData();
            //this sorts by quantities and names using comparator chaining method
            Arrays.sort(fruits, new FruitChainedComparator(
                            new FruitQuantityComparator(),
                            new FruitNameComparator())
            );
            System.out.println("\n\nAfter sorting by quantity and name with comparator chaining method (long way)");
            printFruits(fruits);
        }

        {
            fruits = makeData();
            //this sorts by quantities and names using CompareToBuilder - shorter than previous
            Arrays.sort(fruits, new FruitUsingCompareToBuilder());
            System.out.println("\n\nAfter sorting by name and quantity with compare to builder (shorter way than previous)");
            printFruits(fruits);
        }
    }
}

public class FruitTest {

    public static void main(String[] args) {
        new SortFruitObjects().sortFruits();
    }
}

