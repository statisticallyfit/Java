package main.ExamPractice.freeresponse.FR4;


public class NumberCube {

    public int toss(){
        return (int) (Math.random() * (6 - 1 + 1)) + 1;
    }

    /** Returns the starting index of a longest run of two or more
     * consecutive repeated values in the array values.
     * @param values an array of integer values representing a series
     * of number cube tosses
     * Precondition: values.length > 0
     * @return the starting index of a run of maximum size;
     * -1 if there is no run
     */
    public static int getLongestRun(int[] values) {
        /*int maxLength = 0;
        int currLength = 0;
        int maxRunIndex = 0;
        int currRunIndex = 0;

        for(int i = 0; i < values.length - 1; i++){
            if(values[i] == values[i + 1]){
                currRunIndex = i;
                while(i < values.length - 1 && values[i] == values[i + 1])
                    i++;
                currLength = i - currRunIndex + 1;
                if(currLength > maxLength){
                    maxLength = currLength;
                    maxRunIndex = currRunIndex;
                }
            }
        }
        if(maxLength == 0)
            return -1;
        return maxRunIndex;*/

        int currentLen = 0;
        int maxLen = 0;
        int maxStart = -1;
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i+1]) {
                currentLen++;

                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxStart = i - currentLen + 1;
                }
            } else {
                currentLen = 0;
            }
        }
        return maxStart;
    }

    public static void main(String[] args) {
        int[] tosses = new int[]{1, 5, 5, 4, 3, 1, 2, 2, 2, 2, 6, 1, 3, 3, 5, 5, 5, 5};

        System.out.println(getLongestRun(tosses));
    }
}
