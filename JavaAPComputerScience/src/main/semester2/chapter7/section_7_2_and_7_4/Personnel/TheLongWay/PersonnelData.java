package semester2.chapter7.section_7_2_and_7_4.Personnel.TheLongWay;

import semester1.chapter4.section_4_4.Person;
import semester2.chapter7.section_7_1.*;
import semester2.chapter7.section_7_6.WorkerList;

import java.io.*;
import java.util.*;



/*
Assignment 7.13 solution inspired from: http://www.codejava.net/java-core/collections/sorting-a-list-by-multiple-attributes-example
 */



/*For Assignment 7.13*/
class PersonnelChainedComparator implements Comparator<Worker> {

    private List<Comparator<Worker>> listOfComparators;


    public PersonnelChainedComparator(Comparator<Worker>... comparators) {
        this.listOfComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(Worker w1, Worker w2/*Object o1, Object o2*/) {
        /*Worker w1 = ((Worker)o1);
        Worker w2 = ((Worker)o2);*/

        for (Comparator<Worker> comparatorElement : listOfComparators) {
            int result = comparatorElement.compare(w1, w2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}

/*For Assignment 7.13*/
class PersonnelFirstNameComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker w1, Worker w2) {
        return w1.getFirstName().compareTo(w2.getFirstName()); // String's compareTo() method
    }
}

/*For Assignment 7.13*/
class PersonnelLastNameComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker w1, Worker w2) {
        return w1.getLastName().compareTo(w2.getLastName());
    }
}










public class PersonnelData {

    private Buffin itsFile = new Buffin("C:\\D\\tmp\\workers.txt");
    public static final int MAX_WORKERS = 5000;
    private static final int TIMESPAN = 10; //for question 8 test
    private static final int YEAR = 1960; //for question 8

    /*Read file of up to 5000 workers and displayOutput those who make more than
    * 50% above average pay*/

    public void printHighlyPaid(){
        WorkerList job = new WorkerList(MAX_WORKERS);
        job.addFromFile(itsFile);
        double cutoff = 1.5 * job.getAveragePay();

        job.thosePaidOver(cutoff);
    }

    /*Exercise 7.23: print every worker whose name comes alphabetically
    * before the name of last worker in input file */

    public void printThoseAlphabeticallyBeforeLast(){
        WorkerList job = new WorkerList(MAX_WORKERS);
        job.addFromFile(itsFile);
        job.thoseAlphabeticallyBeforeLast();
    }

    /*Assignment 7.24: Print the workers older than average worker */

    public void printThoseOlderThanAverage(){
        WorkerList job = new WorkerList(MAX_WORKERS);
        job.addFromFile(itsFile);
        job.thoseOlder(job.getAverageBirthYear());
    }

    /** Read a file and return the name of the Worker that is
     *  alphabetically first. */

      public String findEarliestWorker() {
        Worker answerSoFar = new Worker(itsFile.readLine());

        if(answerSoFar.getName() == null){
            return "no workers!";
        } else {
            Worker data = new Worker(itsFile.readLine());
            while(data.getName() != null) {
                if(data.compareTo(answerSoFar) < 0){
                    answerSoFar = data;
                }
                data = new Worker(itsFile.readLine());
            }
            return answerSoFar.getName() + " is first of all.";
        }
    }

    /*Exercise 7.8 */

    public double weeklyPayOfAll(){
        Worker worker = new Worker(itsFile.readLine());
        double sum = 0.0;

        while(worker.getName() != null){
            sum += worker.seeWeeksPay();
            worker = new Worker(itsFile.readLine());
        }
        return sum;
    }

    /*Exercise 7.9*/

    public boolean isSameCentury(){

        Worker answerSoFar = new Worker(itsFile.readLine());
        int century = answerSoFar.getBirthYear()/100;

        if(answerSoFar.getName() == null){
            return false;
        }else {
            Worker data = new Worker(itsFile.readLine());
            while(data.getName() != null) {
                if(data.getBirthYear()/100 != century){
                    return false;
                }
                data = new Worker (itsFile.readLine());
            }
            return true;
        }
    }

    /*Assignment 7.10: Return earliest birth year. */

    public int getLowestBirthYear(){
        List<Integer> births = new ArrayList<Integer>();
        int numOfLines = getNumOfLines();

        for(int i = 0; i < numOfLines; i++){
            births.add(i, new Worker(itsFile.readLine()).getBirthYear());
        }
        Collections.sort(births);

        return births.get(0); //lowest birth year
    }

    /*part of assignment 7.10*/
    public int getNumOfLines(){
        int lines = 0;
        try{
            File file = new File("C:\\D\\tmp\\workers.txt");

            if(file.exists()){
                FileReader fr = new FileReader(file);
                LineNumberReader lnr = new LineNumberReader(fr);

                while(lnr.readLine() != null){
                    lines++;
                }
            }
        }catch(IOException io){
            io.printStackTrace();
        }
        return lines;
    }


    /*Assignment 7.13: tell whether list of names are in increasing alphabetical order. */

    public boolean inAscendingOrderByName(){
        //read values, copy to other list, and sort previous list
        List<Worker> workersToBeSorted = new ArrayList<Worker>();
        List<Worker> unsorted = new ArrayList<Worker>(100);
        int numOfLines = getNumOfLines();

        for(int i = 0; i < numOfLines; i++){
            workersToBeSorted.add(i, new Worker(itsFile.readLine()));
        }

        //copy values from one list to another to compare other later
        unsorted.addAll(workersToBeSorted);
        Collections.sort(workersToBeSorted, new PersonnelChainedComparator(
                        new PersonnelLastNameComparator(),
                        new PersonnelFirstNameComparator())
        );

        //do for loop and compare value at old list with value at sorted list
        for(int i = 0; i < numOfLines; i++){
            //if only one worker, return true
            if(numOfLines == 1){
                return true;
            }else if(workersToBeSorted.get(i).compareTo(unsorted.get(i)) != 0){
                return false;
            }
        }
        return true;
    }


    /* Unit 6 test question 8 */

    public String countBirthYears(){
        int[] count = new int[TIMESPAN];

        Worker data = new Worker(itsFile.readLine());

        while(data.getName() != null){
            int lastDigit = data.getBirthYear() - YEAR;
            count[lastDigit]++;
            data = new Worker(itsFile.readLine());
        }

        int largestFreq = count[0];
        int lastDigit = 0; //default
        for(int i = 0; i < TIMESPAN; i++){
            //s += (YEAR + i) + ": " + count[i] + " workers\n";
            if(count[i] > largestFreq){
                largestFreq = count[i];
                lastDigit = i;
            }
        }

        return (YEAR + lastDigit) + " has the highest frequency of " + largestFreq + " workers";
    }

    public static void main(String[] args) {
        PersonnelData p = new PersonnelData();

        System.out.println(p.countBirthYears());
    }
}