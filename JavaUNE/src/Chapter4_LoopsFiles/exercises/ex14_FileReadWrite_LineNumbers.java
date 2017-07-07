package Chapter4_LoopsFiles.exercises;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * Asks user for filenmae and modifies the file by line-numbering it.
 */
public class ex14_FileReadWrite_LineNumbers {

    public static void main(String[] args) throws IOException {

        String filename;
        String newFilename;
        final int EXT_LEN = 4; //example length of extension is 4 if ext is .txt or .rtf
        String path = "src/Chapter4_LoopsFiles/exercises/";
        int lineCount = 1;
        String line; //to hold line input.
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter filename: ");
        filename = keyboard.nextLine();

        // Making connection with file (below) first line.
        File file = new File(path + filename);
        if(!file.exists()){
            System.out.println(String.format("File %s does not exist. Exiting ...", filename));
            System.exit(1);
        }
        // Opening file.
        Scanner inputFile = new Scanner(file); // to read from file.
        newFilename = filename.substring(0, filename.length() - 4) + "_numbered.txt";
        PrintWriter outputFile = new PrintWriter(path + newFilename); // to write to file


        //Reading the lines to number them.
        while(inputFile.hasNext()){
            line = inputFile.nextLine();

            //reformatting line
            outputFile.println(String.format("%d: %s", lineCount, line));

            lineCount++;
        }
        inputFile.close();
        outputFile.close();
    }
}

/**
 The silvery moonlight danced and beamed through the rustling fig tree leaves.
 Their wide, heart-shaped leaves caught the moonbeams and seemed to play with them,
 splashing them around like dewdrops over their generous surface. Stars glimmered high above,
 and shadows cast about like playful foxes in a game of chase. The night air was cool
 and dry and lily of the valley flowers scented the air with their sweet perfume.
 Nightingales had long ago sung their last song before the last rays of sun
 bathed the scene in vibrant red, and now the world was asleep, the soft grays, purples,
 and faded blues of night was its only blanket.
 */