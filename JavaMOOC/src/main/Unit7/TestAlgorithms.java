package main.Unit7;

/* From Be Prepared book Chapter 5 */

public class TestAlgorithms {


    public int findMostOccurrences(int[] numbers){
        int count = 1;

        for(int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j])
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] a = new int[]{8, 4, 5, 7, 2, 3, 9};


    }
}
