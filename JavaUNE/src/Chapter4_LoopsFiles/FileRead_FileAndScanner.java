package Chapter4_LoopsFiles;


import java.util.Scanner;
import java.io.*;

/**
 *
 */
public class FileRead_FileAndScanner {

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in); //note -one scanner object for reading file name

        //Get the file name.
        System.out.print("Enter the name of a file: ");
        String filename = "src/Chapter4_LoopsFiles/" + keyboard.nextLine();

        //Open the file.
        File file = new File(filename);
        Scanner inputFile = new Scanner(file); //now we can operate on inputFile using scanner methods.

        // read lines until no more are left.
        while(inputFile.hasNext()){
            String friendName = inputFile.nextLine();

            //display the last name read.
            System.out.println(friendName);
        }

        inputFile.close();
    }
}
