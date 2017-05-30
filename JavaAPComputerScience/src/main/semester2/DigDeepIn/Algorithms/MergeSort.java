package semester2.DigDeepIn.Algorithms;


public class MergeSort {

    /**
     * Sort an array of integers into ascending order.
     *
     * @param elements an array containing the items to be sorted.
     *
     * Postcondition: elements contains its original items and items in elements
     * are sorted in ascending order.
     */
    public static void mergeSort(int[] elements) {
        int n = elements.length;
        int[] temp = new int[n];
        mergeSortHelper(elements, 0, n - 1, temp);
    }


    /**
     * Sorts elements[from] ... elements[to] inclusive into ascending order.
     *
     * @param elements an array containing the items to be sorted.
     * @param from the beginning index of the items in elements to be sorted.
     * @param to the ending index of the items in elements to be sorted.
     * @param temp a temporary array to use during the merge process.
     *
     * Precondition:
     * (elements.length == 0 or
     * 0 <= from <= to <= elements.length) and
     * elements.length == temp.length
     * Postcondition: elements contains its original items and the items in elements
     * [from] ... <= elements[to] are sorted in ascending order.
     */
    private static void mergeSortHelper(int[] elements,
                                        int from, int to, int[] temp) {
        if (from < to) {
            System.out.println("Entering " + from + "-" + to);
            int middle = (from + to) / 2;

            System.out.println("Will sort low half of " + from + "-" + to);
            mergeSortHelper(elements, from, middle, temp);

            System.out.println("Will sort high half of " + from + "-" + to);
            mergeSortHelper(elements, middle + 1, to, temp);

            System.out.println("Will merge halves into " + from + "-" + to);
            merge(elements, from, middle, to, temp);

            System.out.println("Return " + from + "-" + to + "       the array = " + Print.array(elements));
        }
    }


    /**
     * Merges two adjacent array parts, each of which has been sorted into ascending
     * order, into one array part that is sorted into ascending order.
     *
     * @param elements an array containing the parts to be merged.
     * @param from the beginning index in elements of the first part.
     * @param mid the ending index in elements of the first part.
     * mid+1 is the beginning index in elements of the second part.
     * @param to the ending index in elements of the second part.
     * @param temp a temporary array to use during the merge process.
     *
     * Precondition: 0 <= from <= mid <= to <= elements.length and
     * elements[from] ... <= elements[mid] are sorted in ascending order and
     * elements[mid + 1] ... <= elements[to] are sorted in ascending order and
     * elements.length == temp.length
     * Postcondition: elements contains its original items and
     * elements[from] ... <= elements[to] are sorted in ascending order and
     * elements[0] ... elements[from − 1] are in original order and
     * elements[to + 1] ... elements[elements.length − 1] are in original order.
     */
    private static void merge(int[] elements,
                              int from, int mid, int to, int[] temp) {
        int i = from;
        int j = mid + 1;
        int k = from;
        while (i <= mid && j <= to) {
            if (elements[i] < elements[j]) {//then put that smaller one into temp
                temp[k] = elements[i];
                i++;
            }
            else {//put the smaller one (that is after first) into temp
                temp[k] = elements[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = elements[i];
            i++;
            k++;
        }
        while (j <= to) {
            temp[k] = elements[j];
            j++;
            k++;
        }
        for (k = from; k <= to; k++) {
            elements[k] = temp[k];
        }
    }



    public static void main(String[] args) {
        int[] list = new int[]{64, 21, 70, 33, 40, 2, 50, 10/*, 7, 6, 3, 5, 1*/};

        Print.array(list);
        mergeSort(list);
        Print.array(list);
    }
}
