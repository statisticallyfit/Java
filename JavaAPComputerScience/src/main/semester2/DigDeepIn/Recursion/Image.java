package semester2.DigDeepIn.Recursion;

/* From AP Barrons book page 298 */

import java.util.Arrays;

public class Image {
    private final int BLACK = 1;
    private final int WHITE = 0;
    private int size = 8; //number of rows and columns
    private int[][] image = {
            {0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 1},
            {0, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 0, 0, 1, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
    };

    /*private char[][] image = {
            {'W', 'W', 'B', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'B', 'B', 'B', 'B', 'B', 'B', 'W'},
            {'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B'},
            {'W', 'B', 'W', 'B', 'W', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'W', 'W', 'W', 'B', 'W'},
            {'W', 'B', 'B', 'B', 'B', 'B', 'B', 'W'},
            {'B', 'B', 'B', 'B', 'W', 'W', 'B', 'W'},
            {'W', 'W', 'W', 'B', 'B', 'W', 'W', 'W'},
    };*/

    public Image() {

    }

    public void display() {
        for (int row = 0; row < 8; row++) {
            System.out.println();
            for (int col = 0; col < 8; col++) {
                System.out.print(this.image[row][col] + " ");
            }
        }
    }

    public void print(int[][] array) {
        for (int row = 0; row < 8; row++) {
            System.out.println();
            for (int col = 0; col < 8; col++) {
                System.out.print(this.image[row][col] + " ");
            }
        }
    }

    public static boolean isSame(int[][] newImage, int[][] oldImage) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (newImage[row][col] != oldImage[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isTheSame(int[][] oldImage) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (this.image[row][col] != oldImage[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] getImage() {
        return image;
    }

    /**
     * Precondition: Image is defined with either BLACK or WHITE cells
     * Postcondition: if 0 <= row < size, 0 <= col < size, and
     * image[row][col] is BLACK, set all cells in the
     * same blob to WHITE. Otherwise image is unchanged.
     *
     * @param row the given row
     * @param col the given column
     */

    public int[][] eraseBlob(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            if (image[row][col] == BLACK) {
                image[row][col] = WHITE;
                eraseBlob(row - 1, col);
                eraseBlob(row + 1, col);
                eraseBlob(row, col - 1);
                eraseBlob(row, col + 1);
            }
        }
        return image;
    }

    public static void main(String[] args) {
        Image o = new Image();

        o.display();
        int[][] old = copyMatrix(o.getImage());
        int[][] erased = o.eraseBlob(0, 2);

        System.out.println();
        o.display();

        System.out.println("\nSame? " + isSame(erased, old)); //todo why does it print true????
        System.out.println("\nThe same? " + o.isTheSame(old));

    }

    private static int[][] copyMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][];
        for (int l = 0; l < matrix.length; l++) {
            copy[l] = Arrays.copyOf(matrix[l], matrix[l].length);
        }
        return copy;
    }
}
