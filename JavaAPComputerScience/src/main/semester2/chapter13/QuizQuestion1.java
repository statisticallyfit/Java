package semester2.chapter13;

//Quiz 7.02

import semester2.DigDeepIn.Algorithms.Print;

public class QuizQuestion1 {

    // Question 1 ----------------------------

    public static void sort(int a[]){

        int left = 0, right = a.length - 1;
        int k;

        while(left < right){

            if (a[left] > a[right]){
                swap(a, left, right);
            }


            for (k = left + 1; k < right; k++ ){

                if (a[k]  < a[left]){
                    swap(a,k,left);
                }
                else if (a[k] > a[right]){
                    swap(a,k,right);
                }
            }
            left++;
            right--;
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    // Question 2 ----------------------------


    public static void doMergeSort(int[] numbers, int[] temp, int arrayLength){
        mergeSort(numbers, temp, 0, arrayLength - 1);
    }


    public static void mergeSort(int numbers[], int[] temp, int left, int right){
        if (left == right) {
            return;
        } else if (right == left + 1) {
            if (numbers[right] < numbers[left])
                swap(numbers, left, right);    // swaps a[n1] and a [n2]
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(numbers, temp, left, mid);
        mergeSort(numbers, temp, mid + 1, right);

        if (numbers[mid] > numbers [mid+1])
            merge(numbers, temp, left, mid, right);  // merges a[n1] . . . a[m] and a[m+1] . . . a[n2]

        /*int mid;
        if (left < right) {
            System.out.println("Entering " + left + "-" + right);
            mid = (right + left) / 2;

            System.out.println("Will sort low half of " + left + "-" + right);
            mergeSort(numbers, temp, left, mid);

            System.out.println("Will sort high half of " + left + "-" + right);
            mergeSort(numbers, temp, mid + 1, right);

            System.out.println("Will merge halves into " + left + "-" + right);
            merge(numbers, temp, left, mid+1, right);


            System.out.println("Return " + left + "-" + right + "       the array = " + Print.array(numbers));
        }*/
    }

    public static void merge(int numbers[], int temp[], int left, int mid, int right) {
        System.out.println("In merge method now");

        int i, leftEnd, numOfElements, tmpPos;
        leftEnd = mid - 1;
        tmpPos = left;
        numOfElements = right - left + 1;

        while ((left <= leftEnd) && (mid <= right)) {
            if (numbers[left] <= numbers[mid]) {
                temp[tmpPos] = numbers[left];
                tmpPos++;
                left++;
            }
            else {
                temp[tmpPos] = numbers[mid];
                tmpPos++;
                mid++;
            }
        }

        while (left <= leftEnd) {
            temp[tmpPos] = numbers[left];
            left++;
            tmpPos++;
        }

        while (mid <= right) {
            temp[tmpPos] = numbers[mid];
            mid++;
            tmpPos++;
        }

        for (i = 0; i < numOfElements; i++) {
            numbers[right] = temp[right];
            right--;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 4, 3, 6, 5, 8, 7};

        doMergeSort(array, new int[array.length], array.length);
        System.out.println(Print.array(array));
    }
}
