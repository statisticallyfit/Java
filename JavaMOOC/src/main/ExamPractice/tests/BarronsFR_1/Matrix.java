package main.ExamPractice.tests.BarronsFR_1;


class ArrayUtil{
    /*public static void reverseArray(int[] arr){
        int len = arr.length - 1;

        for(int i = 0; i <= len; i++){
            int temp = arr[i];
            arr[i] = arr[len - i];
            arr[len - i] = temp;
        }
    }*/

    //correct method: java tutorials point
    public static void reverseArray(int[] arr){
        /*int[] result = new int[arr.length];

        for (int lo = 0, hi = result.length - 1; lo < arr.length; lo++, hi--) {
            result[hi] = arr[lo];
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = result[i];
        }*/

        int low = 0, high = arr.length - 1;

        while (low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}

public class Matrix {

    private int[][] mat;

    public Matrix(int[][] m){
        mat = m;
    }



    public void reverseAllRows(){
        for(int r = 0; r < mat.length; r++){
            ArrayUtil.reverseArray(mat[r]);
        }
    }

    public void reverseMatrix(){
        int low = 0, high = mat.length - 1;
        int[] temp;

        for(; low < high; low++, high--){
            temp = mat[low];
            mat[low] = mat[high];
            mat[high] = temp;
            ArrayUtil.reverseArray(mat[low]);
            ArrayUtil.reverseArray(mat[high]);
        }
        if(mat.length % 2 == 1){
            ArrayUtil.reverseArray(mat[low]); //works since low has been incremented before exiting for loop
        }
    }


    public void mirrorVerticalLeftToRight() {
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length / 2; col++)
                mat[row][mat[0].length - 1 - col] = mat[row][col];
        }
    }

    public void mirrorVerticalRightToLeft() {
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length / 2; col++)
                mat[row][col] = mat[row][mat[0].length - 1 - col];
        }
    }

    public void mirrorHorizontalTopToBottom() {
        for (int row = 0; row < mat.length / 2; row++) {
            for (int col = 0; col < mat[0].length; col++)
                mat[mat.length - 1 - row][col] = mat[row][col];
        }
    }

    public void mirrorHorizontalBotToTop() {
        for (int row = 0; row < mat.length / 2; row++) {
            for (int col = 0; col < mat[0].length; col++)
                mat[row][col]= mat[mat.length - 1 - row][col];
        }
    }

    // mirrors only the square part of the matrix
    public void mirrorMajorDiagonalTopToBottom(){
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat.length; col++)
                mat[col][row] = mat[row][col];
        }
    }

    public void mirrorMajorDiagonalBotToTop(){
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat.length; col++)
                mat[row][col] = mat[col][row];
        }
    }

    public void mirrorMinorDiagonalTopToBot(){
        for(int r = 0; r < mat.length; r++)
            for(int c = 0; c < mat[0].length; c++)
                mat[mat[0].length - 1 - c][mat.length - 1 - r] = mat[r][c];
    }

    public int[] getMajorDiagonal(){
        int[] major = new int[mat.length];
        if(mat.length != mat[0].length)
            return major; //empty

        for(int r = 0; r < mat.length; r++)
            major[r] = mat[r][r];
        return major;
    }

    public int[] getMinorDiagonal(){
        int[] minor = new int[mat.length];
        if(mat.length != mat[0].length)
            return minor;

        for(int r = 0; r < mat.length; r++)
            minor[r] = mat[r][mat.length - 1 - r];
        return minor;
    }


    public void method1(){

        int numRows = mat.length;
        int numCols = mat[0].length;
        int[][] newMat = new int[numRows][numCols];

        for(int r = 0; r < numRows; r++)
            for(int c = 0; c < numCols; c++)
                newMat[numRows - r - 1][c] = mat[r][c];
        mat = newMat;
    }


    public void method2(){

        int numRows = mat.length;
        int numCols = mat[0].length;
        int[][] newMat = new int[numRows][numCols];

        for(int r = 0; r < numRows; r++)
            for(int c = 0; c < numCols; c++)
                newMat[r][c] = mat[numRows - r - 1][c];
        mat = newMat;
        mat = newMat;
    }


    public void printMatrix(){
        for(int[] row : mat) {
            System.out.println();
            for (int item : row) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {1, 2, 3, 4, 5},
                {5, 6, 7, 8, 7},
                {4, 5, 7, 1, 4},
                {9, 8, 7, 2, 9},
                {4, 5, 2, 3, 9}
        };

        int[][] matrix2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix3 = new int[][]{
                {1, 2, 3, 4, 5},
                {5, 6, 7, 8, 9}
        };

        Matrix m = new Matrix(matrix2);
        m.mirrorMinorDiagonalTopToBot();
        m.printMatrix();

    }
}
