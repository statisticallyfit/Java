package Chapter4_LoopsFiles;

import java.util.Scanner;
import java.io.*;
/**
 *
 */
public class FileRead_Numbers {

    public static void main(String[] args) throws IOException {

        double sum = 0;
        String filename = "Numbers1.txt";

        //declare file, make sure exists
        File file = new File("src/Chapter4_LoopsFiles/" + filename);
        if (!file.exists()){
            System.out.println("The file " + filename + " does not exist.");
            System.exit(0);
        }
        //Open the file for reading.
        Scanner inputFile = new Scanner(file);

        while(inputFile.hasNext()){
            double number = inputFile.nextDouble();
            sum += number;
        }

        inputFile.close();
        System.out.println("Sum = " + sum);
    }
}

