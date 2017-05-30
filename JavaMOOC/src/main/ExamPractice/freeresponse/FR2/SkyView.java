package main.ExamPractice.freeresponse.FR2;



public class SkyView {

    private double[][] view;

    public SkyView(int numRows, int numCols, double[] scanned){
        view = new double[numRows][numCols];

        int i = 0;
        int row = 0;

        while(row < numRows){
            for(int col = 0; col < numCols; col++){
                view[row][col] = scanned[i];
                i++;
            }

            row++;
            //i++;
            if(numRows % 2 == 1)
                break;

            for(int col = numCols - 1; col >= 0; col--){
                view[row][col] = scanned[i];
                i++;
            }
            row++;
        }
    }

    public String toString(){
        String s = "";

        for(double[] row : view){
            s += "\n";
            for(double val : row){
                s += val + " ";
            }
        }
        return s;
    }
}

class TestSkyView{

    public static void main(String[] args) {
        double[] scanned = new double[]
                {0.3, 0.7, 0.8,
                 0.4, 1.4, 1.1,
                 0.2, 0.5, 0.1,
                 1.6, 0.6, 0.9};

        SkyView sky = new SkyView(4, 3, scanned);
        System.out.println(sky.toString());

    }
}
