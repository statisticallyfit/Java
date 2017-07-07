package Chapter4_LoopsFiles;


import java.util.Scanner;
import java.io.*;
/**
 *
 */
public class FileAdd_FileWriter {

    public static void main(String[] args) throws IOException {

        //note: passing in true boolean to say "yes, append" flag.
        //note: if file does not exist it is created.

        //create the file connection
        FileWriter fwriter = new FileWriter("src/Chapter4_LoopsFiles/MyFriends.txt", true);
        //create printwriter for writing capabilites (to write to file).
        PrintWriter outputFile = new PrintWriter(fwriter);
        outputFile.println();
        outputFile.println("Sasha");
        outputFile.println("Danny");
        outputFile.println("Mikkel Hanna");
        outputFile.println("Hal");
        outputFile.println("Hickory");
        outputFile.println("Neige");
        outputFile.println("Isabel");
        outputFile.println("Dagfinn");
        outputFile.println("Bo");
        outputFile.println("Caprina");
        outputFile.close();
    }
}
