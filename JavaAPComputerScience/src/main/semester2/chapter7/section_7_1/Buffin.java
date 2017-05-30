package semester2.chapter7.section_7_1;

import java.io.*;


public class Buffin extends BufferedReader {
    private static boolean temp;
    private boolean isKeyboard;


    /** Connect to the disk file with the given name.  If this
     *  cannot be done, connect to the keyboard instead. */

    public Buffin(String filename) {
        super(openFile(filename));
        isKeyboard = temp;
    }

    private static Reader openFile(String filename) {

        try {
            temp = false;
            return new FileReader(filename);  // IOException here
        }catch(IOException e) {
            temp = true;
            return new InputStreamReader(System.in);
        }
    }

    /** Read one line from the file and return it.
     *  Return null if at the end of the file. */

    public String readLine() {
        if(isKeyboard) {
            System.out.print(" input> ");
            System.out.flush();  // flush the output buffer
        }
        try {
            return super.readLine(); // in BufferedReader
        }catch(IOException e) {
            System.out.println("Cannot read from the file");
            return null;
        }
    }

    public static void main(String[] args) {
        Buffin file = new Buffin("C:\\D\\tmp\\someFile.txt");
        String line = null;
        while((line = file.readLine()) != null){
            System.out.println(line);
        }

        Buffin nonFile = new Buffin("C:\\D\\tmp\\nonexistentFile.txt");
        //String nonLine = nonFile.readLine();
        String nonLine = null;
        while((nonLine = nonFile.readLine()) != null)
        System.out.println(nonLine);

    }
}