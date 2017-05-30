package semester2.DigDeepIn.Algorithms;


public class InsertionSort {

    /**
     * Sort an array of integers into ascending order.
     *
     * @param elements an array containing the items to be sorted.
     *
     * Postcondition: elements contains its original items and items in elements
     * are sorted in ascending order.
     */
    public static void insertionSort(int[] elements)
    {
        /*for (int j = 1; j < elements.length; j++)
        {
            int temp = elements[j];
            int possibleIndex = j;
            while (possibleIndex > 0 && temp < elements[possibleIndex - 1])
            {
                elements[possibleIndex] = elements[possibleIndex - 1];
                possibleIndex--;
            }
            elements[possibleIndex] = temp;
        }*/

        for(int i = 1; i < elements.length; i++){

            int temp = elements[i];
            int j = i - 1;
            while(j >= 0 && temp < elements[j]){

                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = temp;
        }
    }


    /*public static void nullsAreBigger(Comparable[] elements)
    {
        for (int j = 1; j < elements.length; j++)
        {
            Comparable temp = elements[j];
            int possibleIndex = j;
            while (possibleIndex > 0 && (temp.compareTo(elements[possibleIndex - 1]) < 0 || temp == null))
            {
                elements[possibleIndex] = elements[possibleIndex - 1];
                possibleIndex--;
            }
            elements[possibleIndex] = temp;
        }
    }*/

    public static void main(String[] args) {
        int[] list = new int[]{1, 7, 9, 5, 4, 12};

        System.out.println(Print.array(list));
        insertionSort(list);
        System.out.println(Print.array(list));
    }
}
