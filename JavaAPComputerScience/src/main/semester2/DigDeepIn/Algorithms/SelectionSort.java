package semester2.DigDeepIn.Algorithms;


public class SelectionSort {

    /**
     * Sort an array of integers into ascending order.
     *
     * @param elements an array containing the items to be sorted.
     *
     * Postcondition: elements contains its original items and items in elements
     * are sorted in ascending order.
     */

    public static void selectionSortAscending(int[] elements)
    {
        for (int j = 0; j < elements.length - 1; j++)
        {
            int minIndex = j;
            for (int k = j + 1; k < elements.length; k++)
            {
                if (elements[k] < elements[minIndex])
                {
                    minIndex = k;
                }
            }
            int temp = elements[j];
            elements[j] = elements[minIndex];
            elements[minIndex] = temp;
        }
    }

    /*public static void selectionSortAscending(Comparable[] elements)
    {
        for (int j = 0; j < elements.length - 1; j++)
        {
            int minIndex = j;
            for (int k = j + 1; k < elements.length; k++)
            {
                if (elements[k].compareTo(elements[minIndex]) < 0)
                {
                    minIndex = k;
                }
            }
            Comparable temp = elements[j];
            elements[j] = elements[minIndex];
            elements[minIndex] = temp;
        }
    }*/




   /* public static void selectionSortDescending(Integer[] elements)
    {
        for (int j = 0; j < elements.length - 1; j++)
        {
            int maxIndex = j;
            for (int k = j + 1; k < elements.length; k++)
            {
                if (elements[k] > elements[maxIndex])
                {
                    maxIndex = k;
                }
            }
            int temp = elements[j];
            elements[j] = elements[maxIndex];
            elements[maxIndex] = temp;
        }
    }*/

    public static void main(String[] args) {
        int[] list = new int[]{10, 8, 4, 2, 5};
        System.out.println(Print.array(list));
        selectionSortAscending(list);
        System.out.println(Print.array(list));
    }
}
