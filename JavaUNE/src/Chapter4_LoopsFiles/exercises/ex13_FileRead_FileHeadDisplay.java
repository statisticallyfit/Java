package Chapter4_LoopsFiles.exercises;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class ex13_FileRead_FileHeadDisplay {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); // scanner to read filename
        String filename;
        String path = "src/Chapter4_LoopsFiles/exercises/";
        final int HEAD = 5;
        int currentLine = 1;

        // Preparing to entre filename.
        System.out.print("Enter filename: ");
        filename = scanner.nextLine();


        //Preparing to read file.
        File file = new File(path + filename);
        if(!file.exists()){
            System.out.println(String.format("File %s does not exist. Program will exit.", filename));
            System.exit(1);
        }
        //Opening file up
        Scanner inputFile = new Scanner(file);

        System.out.println();
        while(inputFile.hasNext() && currentLine <= HEAD){
            String line = inputFile.nextLine();
            System.out.println(currentLine + ": " + line);
            currentLine++;
        }
        inputFile.close();
    }
}
