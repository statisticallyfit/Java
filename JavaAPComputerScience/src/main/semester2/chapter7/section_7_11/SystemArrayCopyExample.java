package semester2.chapter7.section_7_11;


public class SystemArrayCopyExample {

    private Object[] itsList = new Object[10];
    private int itsSize = itsList.length;

    public static void main(String[] args) {

        int arr1[] = { 1000, 1, 2, 3, 4, 5 };
        int arr2[] = { 0, 10, 20, 30, 40, 50 };


        /*System.out.print("Before: array2 = ");
        for(int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i]);
        }

        // copies an array from the specified source array
        System.arraycopy(arr1, 0, arr2, 4, 1);
        System.out.print("After: array2 = ");
        for(int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i]);
        }*/

        ///
        int index = 4;
        int element = 333;
        int size = arr1.length;
        System.arraycopy(arr1, index, arr1, index + 1,
                size - index);
        arr1[index] = element;
        size++;

        for(int i = 0; i < size; i++){
            System.out.println(arr1[i]);
        }

    }

    public void add(int index, Object element) {

        System.arraycopy(itsList, index, itsList, index + 1,
                itsSize - index);
        itsList[index] = element;
        itsSize++;
    }
}
