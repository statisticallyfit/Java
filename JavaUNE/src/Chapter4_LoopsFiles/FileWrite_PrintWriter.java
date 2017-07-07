package Chapter4_LoopsFiles;

/**
 * PrintWriter used to write data to file:
 * Examples:
 *
 * PrintWriter outputFile = new PrintWriter("filename.txt");
 * outputFile.println("Jim"); //note: stores data with newline char after it.
 * outputFile.println(98);
 * outputFile.print(name + " "); // note - no newline char.
 * outputFile.close(); //note: must close to refresh unsaved data in buffer.
 *
 *
 * Exceptions:
 * note: any method that wants to rethrow the types of exceptions a class uses
 * note .. must write "throws EXCEPTIONNAME" in their method header.
 * note ... Even if main calls another method that uses PrintWriter, both main
 * note ... and that method must write "throws exceptionname" in their headers.
 * note ... otherwise compiler error occurs.
 */


import java.util.Scanner;
import java.io.*;

public class FileWrite_PrintWriter {

    public static void main(String[] args) throws IOException {

        String filename;
        String path = "src/Chapter4_LoopsFiles/";
        String friendName;
        int numFriends;

        Scanner keyboard = new Scanner(System.in);

        //Get number of friends
        System.out.print("How many friends do you have? ");
        numFriends = keyboard.nextInt();

        //Get filename
        keyboard.nextLine(); //consume remaining newline char before reading string
        System.out.print("Enter the filename: ");
        filename = keyboard.nextLine();


        //note: checking if file exists. Creating File object just for its exists()  method,
        //note.... then can use fileobj to pass to printwriter.
        File file = new File(path + filename);
        if(file.exists()){
            System.out.println("The file " + filename + " already exists.");
            System.exit(0);
        }

        //Open/create the file
        PrintWriter outputFile = new PrintWriter(file);

        //Get data and write it to file
        for(int i = 1; i <= numFriends; i++){
            //Get name of friend.
            System.out.print("Friend name number " + i + ": ");
            friendName = keyboard.nextLine();

            //Write name to file;
            outputFile.println(friendName);
        }

        //Close the file.
        outputFile.close();
        System.out.println("Data are written to the file.");
    }
}
