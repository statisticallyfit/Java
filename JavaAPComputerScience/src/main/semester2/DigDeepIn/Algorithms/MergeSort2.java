package semester2.DigDeepIn.Algorithms;


public class MergeSort2 {

    public static void mergeSort(int numbers[], int temp[], int arraySize) {
        mergeSortHelper(numbers, temp, 0, arraySize - 1);
    }

    public static void mergeSortHelper(int numbers[], int temp[], int left, int right) {
        int mid;
        if (left < right) {
            System.out.println("Entering " + left + "-" + right);
            mid = (right + left) / 2;

            System.out.println("Will sort low half of " + left + "-" + right);
            mergeSortHelper(numbers, temp, left, mid);

            System.out.println("Will sort high half of " + left + "-" + right);
            mergeSortHelper(numbers, temp, mid + 1, right);

            System.out.println("Will merge halves into " + left + "-" + right);
            merge(numbers, temp, left, mid+1, right);


            System.out.println("Return " + left + "-" + right + "       the array = " + Print.array(numbers));
        }
    }

    public static void merge(int numbers[], int temp[], int left, int mid, int right) {
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
        int[] list = new int[]{64, 21, 70, 33, 40, 2, 50, 10, 7, 6, 3, 5, 1};

        System.out.println(Print.array(list));
        mergeSort(list, new int[list.length], list.length);
        System.out.println(Print.array(list));
    }
}
