package main.bookAP.Chapter7_Recursion;

/* Sample Free Response Question 1 */
public class ColorGrid {

    private String[][] pixels;
    private int rows;
    private int cols;

    public ColorGrid(String s, int numRows, int numCols){
        this.rows = numRows;
        this.cols = numCols;

        pixels = new String[rows][cols];
        int stringIndex = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                pixels[row][col] = s.substring(stringIndex, stringIndex + 1);
                stringIndex++;
            }
        }
    }




    public void displayGrid(){
        for(String[] row : pixels){
            System.out.println();
            for(String value : row){
                System.out.print(value + " ");
            }
        }
    }


    public static void main(String[] args) {
        ColorGrid grid = new ColorGrid("rrbgyybrbyrrggrrrbyrryrb", 4, 6);
        grid.displayGrid();
    }
}
