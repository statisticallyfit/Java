package semester2.DigDeepIn.Algorithms;


public class MergeSort3 {

    private int[] itsItem;  // the array to be sorted
    private int[] itsSpare; // spare to facilitate sorting


    public MergeSort3 (int[] item, int[] spare) {
        itsItem = item;
        itsSpare = spare;
    }

    public void sort (int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sortToSpare(start, mid);
            sortToSpare(mid + 1, end);
            merge(itsSpare, itsItem, start, mid, mid + 1, end);
        }
    }


    private void sortToSpare (int start, int end) {
        if (start >= end) {
            itsSpare[start] = itsItem[start];
        } else {
            int mid = (start + end) / 2;
            sort(start, mid);
            sort(mid + 1, end);
            merge(itsItem, itsSpare, start, mid, mid + 1, end);
        }
    }


    private void merge (int[] from, int[] into, int lo, int mid, int hi, int end) {
        System.out.println("lo: " + lo + "  and hi: " + hi);
        for (int spot = lo;  spot <= end;  spot++){
            if (lo > mid || (hi <= end && (from[lo] > from[hi])))
                into[spot] = from[hi++];
            else
                into[spot] = from[lo++];
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{64, 21, 70, 33, 40, 2, 50, 10/*, 7, 6, 3, 5, 1*/};

        System.out.println(Print.array(list));
        new MergeSort3(list, new int[list.length]).sort(0, list.length - 1);
        System.out.println(Print.array(list));
    }
}

