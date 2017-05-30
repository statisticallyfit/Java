package main.codingbatpractice;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice1 {

    /*
     * Warmup 2
     */
    public static boolean noTriples(int[] nums) {
        int countTriples = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                countTriples++;
                if (countTriples == 3)
                    return false;
            } else {
                countTriples = 1;
            }

        }
        return true;
    }

    /**
     * String 3 section
     */
    public static int maxBlock(String str){
        int blockLen = 1;
        int maxBlockLen = 1;

        //first check if empty string
        if(str.length() == 0)
            return 0;

        for (int i = 0; i < str.length() - 1; i++){
            if (str.substring(i, i + 1).equals(str.substring(i+1, i+2))){
                blockLen++;
                if (blockLen >= maxBlockLen) {
                    maxBlockLen = blockLen;
                }
            } else {
                blockLen = 1; //refresh
            }
        }
        return maxBlockLen;
    }


    /**
     * String 3 section
     */
    public static int countHowManyWordsEndWithYOrZ(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            str = str.toLowerCase();
            Character aChar = str.substring(i, i + 1).charAt(0);

            if (!Character.isLetter(aChar)) {
                if (i != 0 && (str.substring(i - 1, i).equals("y") || str.substring(i - 1, i).equals("z"))) {
                    count++;
                }
            }
            else if(i + 1 == str.length()) {
                if (i != 0 && (str.substring(i, i + 1).equals("y") || str.substring(i, i + 1).equals("z"))) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * String 3 section
     * @param str
     */
    public static int sumDigits(String str){
        int sum = 0;

        for (int i = 0; i < str.length(); i++){
            Character aChar = str.substring(i, i + 1).charAt(0);
            if(Character.isDigit(aChar)){
                sum += Character.digit(aChar, 10);
            }
        }
        return sum;
    }


    /**
     * String 3 section
     * @param str
     */
    public static boolean gHappy(String str) {
        boolean happy = false;
        boolean wereNoGs = true;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            String letter = str.substring(i, i + 1);

            if (letter.equals("g")){
                wereNoGs = false;
                if ((i != 0 && str.substring(i-1, i).equals("g")) || (i != str.length() - 1 && str.substring(i+1, i+2).equals("g"))) {
                    happy = true;
                } else {
                    happy = false;
                }
            }
        }
        return wereNoGs || happy;
    }


    /**
     * Section array 3
     * @param nums
     */
    public static int findMaxSpan(int[] nums){
        int maxSpan = 1;
        int currSpan = 1;

        if(nums.length == 0)
            return 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    currSpan = j - i + 1;
                    if(currSpan > maxSpan)
                        maxSpan = currSpan;
                }
            }
        }
        return maxSpan;
    }


    /**
     * Array 3
     */
    private static void reverse(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int temp = numbers[low];
            numbers[low] = numbers[high];
            numbers[high] = temp;
            low++;
            high--;
        }
    }

    private static void addToFull(int[] numbers, List<Integer> full) {
        //now put the partial array into full list
        for (int j = 0; j < numbers.length; j++) {
            full.add(numbers[j]);
        }
    }

    private static int[] toIntArray(List<Integer> list) {
        //turn Integer list into int array
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] squareUp(int n) {
        List<Integer> full = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            int[] partial = new int[n];
            for (int counter = 1; counter <= i; counter++) {
                partial[counter - 1] = counter;
            }
            reverse(partial);
            addToFull(partial, full);
        }
        return toIntArray(full);
    }



    public static void main(String[] args) {

        /**
         * Testing noTriples()
         */
        assert noTriples(new int[]{1, 1, 2, 2, 1}) :        "check 1";
        assert !noTriples(new int[]{1, 1, 2, 2, 2, 1}) :    "check 2";
        assert !noTriples(new int[]{1, 1, 1, 2, 2, 2, 1}) : "check 3";

        /**
         * Testing maxBlock()
         */
        assert maxBlock("hoopla") == 2 :        "#1";
        assert maxBlock("follow") == 2 :        "#2";
        assert maxBlock("abbCCCddBBBxx") == 3 : "#3";
        assert maxBlock("") == 0 :              "#4";
        assert maxBlock("hhiiiyoooooou") == 6 : "#5";
        assert maxBlock("xyz") == 1 :           "#6";
        assert maxBlock("x") == 1 :             "#7";
        assert maxBlock("hi thereeeee") == 5 :  "#8";

        /**
         * Testing countHowMany...
         */
        assert countHowManyWordsEndWithYOrZ("buzz day") == 2 :                          "#1";
        assert countHowManyWordsEndWithYOrZ("trap yay") == 1 :                          "#2";
        assert countHowManyWordsEndWithYOrZ("") == 0 :                                  "#3";
        assert countHowManyWordsEndWithYOrZ(" ") == 0 :                                 "#4";
        assert countHowManyWordsEndWithYOrZ(" x") == 0 :                                 "#5";
        assert countHowManyWordsEndWithYOrZ("hi") == 0 :                                "#6";
        assert countHowManyWordsEndWithYOrZ("gigahertz funny brainy shiny ") == 4 :     "#7";
        assert countHowManyWordsEndWithYOrZ("@@day:yak:") == 1 :                          "#8";
        assert countHowManyWordsEndWithYOrZ(" y2   bz") == 2 :                          "#9";
        assert countHowManyWordsEndWithYOrZ("DAY abc XYZ") == 2 :                       "#10";


        /**
         * Testing sumDigits()
         */
        assert sumDigits("aa1bc2d3") == 6 :                 "#1";
        assert sumDigits("aa11b33") == 8 :                  "#2";
        assert sumDigits("ChocOLate") == 0 :                "#3";
        assert sumDigits("   #@$ ** ___ =  4488y") == 24 :  "#4";

        /**
         * Testing gHappy()
         */
        assert gHappy("xxxggxx") :          "#1";
        assert gHappy(" xx gg x x ") :      "#2";
        assert !gHappy("xgxx") :            "#3";
        assert !gHappy("g") :               "#4";
        assert !gHappy("xxggyygxx") :       "#5";
        assert gHappy("xxxgggxxggxx") : "#6";


        /**
         * Testing maxSpan()
         */
        assert findMaxSpan(new int[]{1, 2, 1, 1, 3}) == 4 :         "#1";
        assert findMaxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}) == 6 :   "#2";
        assert findMaxSpan(new int[]{1, 4, 2, 1, 4, 4, 4}) == 6 :   "#3";

        /**
         * Testing squareUp()
         */
        assert Arrays.equals(squareUp(0), new int[]{}) :                                                                "#0";
        assert Arrays.equals(squareUp(1), new int[]{1})  :                                                              "#1";
        assert Arrays.equals(squareUp(2), new int[]{0, 1,   2, 1}) :                                                    "#2";
        assert Arrays.equals(squareUp(3), new int[]{0,0,1, 0,2,1, 3,2,1}) :                                             "#3";
        assert Arrays.equals(squareUp(5), new int[]{0,0,0,0,1,  0,0,0,2,1,  0,0,3,2,1,  0,4,3,2,1,  5,4,3,2,1})  :      "#4";
    }
}
