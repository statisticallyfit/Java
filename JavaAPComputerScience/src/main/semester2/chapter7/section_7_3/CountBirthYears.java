package semester2.chapter7.section_7_3;

import semester2.chapter7.section_7_1.Buffin;
import semester2.chapter7.section_7_1.Worker;

import java.util.ArrayList;
import java.util.List;


public class CountBirthYears {

    private Buffin itsFile = new Buffin("C:\\D\\tmp\\workers.txt");
    private static final int TIMESPAN = 10;
    private static final int YEAR = 1960;
    private static final int NUMLETTERS = 26;
    private static final int LONGERTIMESPAN = 65;
    private static final int EARLIERYEAR = 1920;


    /*Read a file and return String representation
    * of number of workers born in each year from
    * 1960 to 1969 */

    public String countBirthYears(){
        int[] count = new int[TIMESPAN];

        //read worker data and update the counts
        Worker workerData = new Worker(itsFile.readLine());

        while(workerData.getName() != null){
            int lastDigit = workerData.getBirthYear() - YEAR;
            if(lastDigit >= 0 && lastDigit <= (TIMESPAN - 1)){
                count[lastDigit]++;
            }
            workerData = new Worker(itsFile.readLine());
        }

        //construct string of answers
        String s = "";

        for(int i = 0; i < TIMESPAN; i++){
            s += (YEAR + i) + ": " + count[i] + " workers\n";
        }
        /*for(int i = 0; i < TIMESPAN; i++){
            s += "Nineteen sixty" + unit[i] + ": " + count[i] + " workers\n";
        }*/
        return s;
    }

    /* Exercise 7.15: Read a file and return String representation
     * of number of workers born in each year from 1960 to 1969 */

    public String countNames(){
        int[] count = new int[NUMLETTERS];
        Worker workerData = new Worker(itsFile.readLine());

        while(workerData.getName() != null){
            int index = workerData.getName().charAt(0) - 'A';
            if(index >= 0 && index <= (NUMLETTERS - 1)){
                count[index]++;
            }
            workerData = new Worker(itsFile.readLine());
        }

        String s = "";
        for(int i = 0; i < NUMLETTERS; i++) {
            s += "Letter " + "\"" + (char)('A' + i) + "\"" + ": " + count[i] + " workers\n";
        }

        return s;
    }

    /*Assignment 7.16
     * Answer:
     * a) if variables were used instead of a counter array,
     * then there would be 65 initializations to zero, from
     * count20 ... count 84.
     * b) there would be 130 total lines using if-else
     * such as if(lastDigit == count 84) {count84++}
     * c) there would be 65 lines needed to print the results, such as
     * System.out.println("Year 1920 had " + count20 + " workers")
     * Therefore the total number of additional lines is: 260
     */


    /* Assignment 7.17 */

    public String countBirthYearsWithWords(){
        int[] count = new int[LONGERTIMESPAN];

        /*when declared the shorter way with {} it is called INITIALIZER LIST */
        String [ ] unit = new String [10];
        unit[0] = "";
        unit[1] = "-one";
        unit[2] = "-two";
        unit[3] = "-three";
        unit[4] = "-four";
        unit[5] = "-five";
        unit[6] = "-six";
        unit[7] = "-seven";
        unit[8] = "-eight";
        unit[9] = "-nine";

        String[] tens = new String[9];
        tens[0] = "";
        tens[1] = "";
        tens[2] = "twenty";
        tens[3] = "thirty";
        tens[4] = "forty";
        tens[5] = "fifty";
        tens[6] = "sixty";
        tens[7] = "seventy";
        tens[8] = "eighty";


        //read worker data and update the counts
        Worker workerData = new Worker(itsFile.readLine());

        while(workerData.getName() != null){
            int diff = workerData.getBirthYear() - EARLIERYEAR;
            if(diff >= 0 && diff <= (LONGERTIMESPAN - 1)){
                count[diff]++;
            }
            workerData = new Worker(itsFile.readLine());
        }


        String s = "";
        int t = 0;
        int u = 0;
        int tenthsAndUnit = 0;

        for(int i = 0; i < LONGERTIMESPAN; i++){
            tenthsAndUnit = (EARLIERYEAR + i) - 1900;
            t = (tenthsAndUnit)/10;
            u = Integer.parseInt(Integer.toString(tenthsAndUnit).substring(1, 2));
            s += "Nineteen " + tens[t] + unit[u] + ": " + count[i] + " workers\n";
        }

        return s;
    }

    /*Assignment 7.18 */

    public void printNumberOfBirthsNotInSixties(){
        int numOfBirthsNotInSixties = 0;
        List<Integer> listOfBirths = new ArrayList<Integer>();


        Worker workerData = new Worker(itsFile.readLine());

        for(int i = 0; workerData.getName() != null; i++){
            listOfBirths.add(i, workerData.getBirthYear());
            workerData = new Worker(itsFile.readLine());
        }

        for(int i = 0; i < listOfBirths.size(); i++){
            if(listOfBirths.get(i) < 1960 || listOfBirths.get(i) > 1969){
                numOfBirthsNotInSixties++;
            }
        }
        System.out.println("Number of people not born in the 1960s is: " + numOfBirthsNotInSixties);
    }
}

/*Source UML:
* http://www.ibm.com/developerworks/rational/library/content/RationalEdge/sep04/bell/
* */