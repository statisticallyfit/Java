package semester2.chapter7.section_7_11;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMethodsTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        System.out.println("The size: " + list.size());

        list.add(3);
        list.add(0, 1);
        list.add(2, 90); //** set() only replaces stuff already there
        list.add(3, 30);
        list.add(4, 100);
        list.add(5, 10);
        list.add(6, 2);
        list.add(7, 4);
        list.add(8, 3);
        list.add(9, 50);
        list.add(10, 40);

        System.out.println("The size: " + list.size());

        for(Integer value : list){
            System.out.println(value);
        }

        Integer removed = list.remove(2);

        System.out.println("Removed: " + removed);
        System.out.println("Added again: " + list.add(removed));
        System.out.println("Change it: " + list.set(list.size() - 1, 10000));

        for(Integer value : list){
            System.out.println(value);
        }

        Object[] array = Arrays.copyOf(list.toArray(), 12);
        array[11] = 123123;
        System.out.println("PRINTING ");
        for(Object value : array){
            System.out.println(value);
        }
    }
}
