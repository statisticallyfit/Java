package semester2.chapter7.section_7_11;


import java.util.ArrayList;
import java.util.Arrays;

public class Arraylist extends ArrayList<Object> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] itsList;
    private int itsSize;
    private int itsCapacity;


    /* Create empty list of elements */

    public Arraylist(int initialCapacity){
        this.itsList = new Object[initialCapacity];  //(max > 5) ? new Object[max] : new Object[5];
        this.itsCapacity = this.itsList.length;
        this.itsSize = this.size();
    }

    public Arraylist(){
        this.itsList = new Object[DEFAULT_CAPACITY];
        this.itsCapacity = this.itsList.length;
        this.itsSize = this.size();
    }

    public void resize(int resizer){
        ensureCapacity(itsSize + resizer);
        itsSize += resizer;
    }

    public void ensureCapacity(int minCapacity){
        itsSize++;
        int numToAdd = minCapacity - itsSize;

        if(minCapacity > itsCapacity){
            growTo(minCapacity);
            itsCapacity += numToAdd;
        }
        itsSize--;
    }

    /* Creates a new array with same name until a specified capacity */

    public void growTo(int minCapacity){
        itsList =  Arrays.copyOf(itsList, minCapacity);
    }

    public int size(){
        return itsSize;
    }

    /*Throw IndexOutOfBoundsException unless 0 <= index < size() */

    public Object get(int index){
        return itsList[index];
    }

    /** Replace the element at this index by ob.  Throw
     *  IndexOutOfBoundsException unless 0 <= index < size(). */

    public Object set(int index, Object o) {
        Object oldValue = itsList[index];
        itsList[index] = o;
        return oldValue;
    }

    /* Delete the element at this index and return it.
    * Shrink the list by 1 element.
    * Throw IndexOutOfBoundsException unless 0 <= index < size() */

    public Object remove(int index){
        Object oldValue = itsList[index];
        set(index, null);

        if(itsSize - index != 1) { //if object at index is not the last element then ...
            for(int i = index; i < this.size(); i++)
                set(i, itsList[i + 1]); //itsList[i] = itsList[i + 1]
        }
        resize(-1); //do this if object is the last element

        return oldValue;
    }

    /* Put ob as the last element in the list.
    * Return true*/

    public boolean add(Object o){
        resize(1);
        set(itsSize - 1, o);
        return true;
    }

    /* Insert ob at this index. Expand the list by 1. Throw
    * IndexOutOfBoundsException unless 0 <= index < size()  */

    public void add(int index, Object o) {
        resize(1);
        for(int i = itsSize - 1; i > index; i--){ //move elements down by 1
            itsList[i] = itsList[i - 1];
        }
        set(index, o);
    }

    /* Assignment 7.11a: remove all the values from array */

    public void clear(){
        while(itsSize != 0)
            remove(0);
    }

    /* Assignment 7.11b: check if list contains a value */

    public boolean contains(Object o){
        for(int i = 0; i < itsSize; i++){
            if(itsList[i].equals(o))
                return true;
        }
        return false;
    }

    /* Assignment 7.11c: swaps first and second,
     * third and fourth, fifth and sixth... etc */

    public void flip(){
        if(itsSize % 2 == 0){
            Object temp = null;

            for(int i = 0; i < itsSize; i = i + 2){
                temp = itsList[i + 1];
                itsList[i + 1] = itsList[i];
                itsList[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Arraylist list = new Arraylist(5);
        list.add(0, 0);
        list.add(1, 1);
        list.add(2, 2);
        list.add(3, 3);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
