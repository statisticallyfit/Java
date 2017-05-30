package semester2.DigDeepIn.Algorithms;


import semester2.DigDeepIn.Algorithms.Print;

public class Insert {

    public static void insertionSort (Comparable[] item, int size)
    {
        for (int k = 1;  k < size;  k++){
            if (item[k] != null){
                insertInOrder (item, k);
            }
        }
    }

    /* Exercise 13.8 */
    private static void insertInOrder (Comparable[] item, int m)
    {
        Comparable save = item[m];
        for (;  m > 0 && (item[m - 1] == null || item[m - 1].compareTo (save) > 0);  m--)
            item[m] = item[m - 1];
        item[m] = save;
    }

    public static void main(String[] args) {
        Integer[] list = new Integer[]{10, 3, 9, null, 8, 6, 7, 5, 1, 0, 40};

        Print.array(list);
        insertionSort(list, 10);
        Print.array(list);
    }
}
