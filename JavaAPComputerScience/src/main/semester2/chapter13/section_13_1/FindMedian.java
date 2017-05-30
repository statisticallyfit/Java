package semester2.chapter13.section_13_1;


public class FindMedian {

    public static double median()
    {
        final int numToSort = 3000;
        Double[] elements = new Double[numToSort];

        for (int k = 0;  k < numToSort;  k++)
        {
            elements[k] = 1 + (Math.random() * 100);
        }

        long t = System.currentTimeMillis();
        //@todo: if want this to run, need to make selection sort have Comparable arguments type
        //SelectionSort.selectionSortAscending(elements);
        System.out.println("Seconds the sorting took: " + (System.currentTimeMillis() - t)/1000);

        return elements[numToSort / 2];
    }

    public static void main(String[] args) {
        median();
    }
}
