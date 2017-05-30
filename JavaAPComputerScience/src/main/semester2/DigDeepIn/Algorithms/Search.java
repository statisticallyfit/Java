package semester2.DigDeepIn.Algorithms;

public class Search {

    /**
     * Finds the index of a value in an array of integers.
     *
     * @param elements an array containing the items to be searched.
     * @param target the item to be found in elements.
     * @return an index of target in elements if found; -1 otherwise.
     */
    public static int sequentialSearch(int[] elements, int target)
    {
        for (int j = 0; j < elements.length; j++)
        {
            if (elements[j] == target)
            {
                return j;
            }
        }
        return -1;
    }


    /**
     * Find the index of a value in an array of integers sorted in ascending order.
     *
     * @param elements an array containing the items to be searched.
     * Precondition: items in elements are sorted in ascending order.
     * @param target the item to be found in elements.
     * @return an index of target in elements if target found;
     * -1 otherwise.
     */
    public static int binarySearch(int[] elements, int target)
    {
        int numIterations = 0;
        int left = 0;
        int right = elements.length - 1;
        while (left <= right)
        {
            int middle = (left + right) / 2;
            if (target < elements[middle])
            {
                right = middle - 1;
            }
            else if (target > elements[middle])
            {
                left = middle + 1;
            }
            else
            {
                return middle;
            }
            numIterations++;
            System.out.println(numIterations);
        }
        return -1;
    }


    /* From book */

    public static boolean binarySearch (int[] item, int size, int target)
    {
        if (size <= 0)
            return false;

        int lowerBound = 0;
        int upperBound = size - 1;

        while (lowerBound < upperBound)
        {
            int midPoint = (int) (0.5 + (lowerBound + upperBound) / 2.0); //(lowerBound + upperBound) / 2;
            if (item[midPoint] < (target))
                lowerBound = midPoint + 1;
            else
                upperBound = midPoint;
        }
        return item[lowerBound] == (target);
    }


    public static void main(String[] args) {

        int[] elements = new int[]{4, 7, 9, 11, 20, 24, 30, 41};

        binarySearch(elements, 27);
    }
}
