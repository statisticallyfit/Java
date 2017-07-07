package Chapter4_LoopsFiles.exercises;

import java.util.Scanner;
import java.io.*;


/**
 * Asks user to enter file name and enter a char.
 * Counts and displays num times the char appears in the file.
 */
public class ex6_FileLetterCounter {


    public static void main(String[] args) throws IOException {
        String filename;
        String path = "src/Chapter4_LoopsFiles/exercises/";
        char letter;
        int letterCount = 0;


        // Enter the filename and letter
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        filename = keyboard.nextLine();
        System.out.print("Enter the letter to count: ");
        letter = keyboard.nextLine().toLowerCase().charAt(0);


        // Make the file reader using File + Scanner
        File file = new File(path + filename);
        // check file exists before potential error in opening file.
        if(!file.exists()){
            System.out.println("The file " + filename + " does not exist.");
            System.exit(1);
        }
        // Opening file
        Scanner inputFile = new Scanner(file);


        // Get/read the lines and count the num times char occurs.
        while(inputFile.hasNext()){
            String line = inputFile.nextLine().toLowerCase();

            // Counting num times the letter occurs in line
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == letter){
                    letterCount++;
                }
            }
        }

        // Close file.
        inputFile.close();

        System.out.println("Number of times letter '" + letter + "' occurs in file " + filename + " is = " + letterCount);
    }

}
