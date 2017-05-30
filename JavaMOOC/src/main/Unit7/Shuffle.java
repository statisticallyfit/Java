package main.Unit7;

public class Shuffle {

    public static int[] shuffle(int[] nums){
        int n = nums.length;
        int[] result = new int[n];

        for(int i = 0; i < n/2; i++){

            result[i * 2] = nums[i];
            result[i * 2 + 1] = nums[i + n/2];
        }
        return result;
    }



    public static void selectSortDescending(int[] elements){
        for(int j = elements.length - 1; j > 0; j--){
            int minIndex = j;

            for(int k = 0; k < j; k++){

                if(elements[k] < elements[minIndex])
                    minIndex = k;
            }

            int temp = elements[j];
            elements[j] = elements[minIndex];
            elements[minIndex] = temp;
        }
    }



    public static void printArr(int[] array){
        for(int val : array)
            System.out.print(val + " ");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 50, 60, 70/*, 80*/};
        int[] arr1 = new int[]{3, 1, 5, 7, 1, 8, 5, 3};

        //printArr(shuffle(arr));

        selectSortDescending(arr1);
        printArr(arr1);

    }
}


