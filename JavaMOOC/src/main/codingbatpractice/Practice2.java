package main.codingbatpractice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice2 {

    /*
     * from String 1
     * Precondition: string length must be odd
     */
    public static String middleThree(String str) {
        int mid = str.length()/2;
        return str.substring(mid-1, mid) +
                str.substring(mid, mid+1) +
                str.substring(mid+1, mid+2);
    }


    /**
     * AP-1
     */
    public static boolean scoresIncreasing(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] > scores[i+1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * AP-1
     * @param a, b, n
     */
    public static String[] mergeTwo(String[] a, String[] b, int n) {
        int i = 0; //a's iterator
        int j = 0; //b's iterator
        int counter = 1; //overall n-comparison
        int k = 0; //merged's iterator
        //String[] merged = new String[n];
        List<String> merged = new ArrayList<String>();


        //for first item of merged
        //merged[k] != null &&
        if(k == 0){
            if (a[i].compareTo(b[j]) <= 0) {
                merged.add(k, a[i]);
                i++;
            } else {
                merged.add(k, b[j]);
                j++;
            }
            k++;
            counter++;
        }


        while(counter < n) {
            k = merged.size() - 1;
            //for rest of items
            if (a[i].compareTo(b[j]) <= 0) {
                if (!merged.get(k-1).equals(a[i]))
                    merged.add(k, a[i]);
                if(i+1 < a.length)
                    i++;
            } else {
                if (!merged.get(k-1).equals(b[j]))
                    merged.add(k, b[j]);
                if(j+1 < b.length)
                    j++;
            }
            counter++;
        }
        return merged.toArray(new String[merged.size()]);
    }


    public static void main(String[] args) {

        /**
         * Testing middleThree()
         */
        assert middleThree("Candy").equals("and") :     "1";
        assert middleThree("and").equals("and") :       "2";
        assert middleThree("solving").equals("lvi") :   "3";
        assert middleThree("bugging").equals("ggi") :   "4";
        assert middleThree("verylongwords").equals("ong") : "5";


        /**
         * Testing mergeTwo()
         */
        assert Arrays.equals(mergeTwo(
                new String[]{"a", "c", "z"},
                new String[]{"b", "f", "z"}, 6),
                new String[]{"a", "b", "c", "f", "z"}) :         "1";

        assert Arrays.equals(mergeTwo(
                new String[]{"a", "c", "z"},
                new String[]{"c", "f", "z"}, 6),
                new String[]{"a", "c", "f", "z"}) :              "2";

        assert Arrays.equals(mergeTwo(
                new String[]{"f", "g", "z"},
                new String[]{"c", "f", "g"}, 6),
                new String[]{"c", "f", "g", "z"}) :              "3";
    }
}
