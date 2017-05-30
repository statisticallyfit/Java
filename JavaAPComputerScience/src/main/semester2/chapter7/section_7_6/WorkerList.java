package semester2.chapter7.section_7_6;


import semester2.chapter7.section_7_1.Buffin;
import semester2.chapter7.section_7_1.Worker;


/* for Assignment 7.32 and exercise 7.28 */
class GivenIsNullException extends Exception {
    public GivenIsNullException(String message){
        super(message);
    }
}



public class WorkerList {

    private Worker[] itsItem;
    private int itsSize = 0;


    /*Create an empty list capable of holding MAX WORKERS */

    public WorkerList(int max){
        this.itsItem = (max > 5) ? new Worker[max] : new Worker[5];
    }


    /*Add all Worker values in non-null file to this list
    * until there is no more room */

    public void addFromFile(Buffin file){
        Worker data = new Worker(file.readLine());
        while(data.getName() != null && itsSize < itsItem.length){
            itsItem[itsSize] = data;
            itsSize++;
            data = new Worker(file.readLine());
        }
        if(data.getName() != null){ //which means the while loop failed because size > 5000
            System.out.println("Warning: Skipping workers past " + data.getName());
        }
    }

    /* Tell whether par is a value in the WorkerList list */

    public boolean contains(Worker par){
        for(int i = 0; i < this.itsSize; i++){
            if(this.itsItem[i].equals(par)){
                return true;
            }
        }
        return false;
    }

    /* Return new object, duplicate of this WorkerList list */

    public WorkerList copy(){
        WorkerList copyValue;
        copyValue = new WorkerList(this.itsItem.length); //assigns the possible length (max 5000)
        copyValue.itsSize = this.itsSize; //assigns the actual occupied length of original array

        for(int i = 0; i < this.itsSize; i++){
            copyValue.itsItem[i] = this.itsItem[i]; //assign each corresponding value
        }

        return copyValue;
    }

    /*Return average pay for all workers in the list
    * Return 0 if list is empty */

    public double getAveragePay(){
        double totalPay = 0;
        for(int i = 0; i < this.itsSize; i++){
            totalPay += this.itsItem[i].seeWeeksPay();
        }
        return this.itsSize == 0 ? 0.0 : totalPay/this.itsSize;
    }

    /* Return average birth year for all workers in list
    * Return 0 if list is empty */

    public double getAverageBirthYear(){
        double sumOfBirthYears = 0.0;
        for(int i = 0; i < this.itsSize; i++){
            sumOfBirthYears += this.itsItem[i].getBirthYear();
        }
        return sumOfBirthYears / this.itsSize;
    }

    /* Print names of workers making more than the cutoff */

    public void thosePaidOver(double cutoff){
        for(int i = 0; i < this.itsSize; i++){
            if(this.itsItem[i].seeWeeksPay() > cutoff){
                System.out.println(this.itsItem[i]); //implicit call toString() of Worker class
            }
        }
    }

    //alternate independent class method example
    public static void thosePaidOver(Worker[] item, double cutoff){
        for(int i = 0; i < item.length; i++){
            if(item[i].seeWeeksPay() > cutoff){
                System.out.println(item[i]); //implicit call toString() of Workers
            }
        }
    }

    /* Print names of workers alphabetically ahead of cutoff */

    public void thoseAlphabeticallyBeforeLast(){
        Worker lastWorker = this.itsItem[this.itsSize - 1];

        for(int i = 0; i < this.itsSize - 1; i++){
            if(this.itsItem[i].compareTo(lastWorker) < 0){
                System.out.println(this.itsItem[i]);
            }
        }
    }

    /* Print names of workers whose birth years are higher than average */

    public void thoseOlder(double cutoff){
        for(int i = 0; i < this.itsSize; i++){
            if(this.itsItem[i].getBirthYear() > cutoff){
                System.out.println(this.itsItem[i]);
            }
        }
    }

    /* Exercise 7.25: tell whether all workers in list have
    * a week's pay that is less than a given cutoff value */

    public boolean everyonePaidLessThan(double cutoff){
        for(int i = 0; i < this.itsSize; i++){
            if(this.itsItem[i].seeWeeksPay() >= cutoff){
                return false;
            }
        }
        return true; //including when there are no workers
    }

    /* Exercise 7.26: Return the name of alphabetically
    * first of the workers */

    public String alphabeticallyFirst(){
        Worker earliest = this.itsItem[0];

        for(int i = 0; i < this.itsSize; i++){
            if(this.itsItem[i].compareTo(earliest) < 0){
                earliest = this.itsItem[i];
            }
        }
        return earliest.getName();
    }

    /* Exercise 7.27: Tell if the names are in ascending order
    * as determined by compareTo() of Worker class */

    public boolean inAscendingOrder(){
        for(int i = 0; i < this.itsSize - 1; i++){ //only until this.itsSize - 1 so no exception at [i + 1]
            if(this.itsItem[i].compareTo(this.itsItem[i + 1]) > 0)
                return false;
        }
        return true; //including when there are no workers
    }

    /* Exercise 7.28: Tell how many workers the executor
    * has in common with parameter in same position.
    * Throw exception if the given is null */

    public int countSameInPlace(WorkerList given){
        int countSame = 0;

        try {
            if(given == null)
                throw new GivenIsNullException("Given is null!");

            int upperlimit = (this.itsSize <= given.itsSize) ? this.itsSize : given.itsSize;
            for(int i = 0; i < upperlimit; i++){
                if(this.itsItem[i].equals(given.itsItem[i]))
                    countSame++;
            }
        } catch(GivenIsNullException gin){
            System.out.println(gin.getMessage());
        }
        return countSame;
    }

    /* Assignment 7.29: Return worker object who is oldest
    * Return null if no workers */

    public Worker oldestWorker(){
        Worker oldest = this.itsItem[0];

        if(this.itsSize == 0){
            return null; //since there are no workers
        }

        for(int i = 0; i < this.itsSize; i++){
            if(new Integer(this.itsItem[i].getBirthYear())
                    .compareTo(oldest.getBirthYear()) < 0){
                oldest = this.itsItem[i];
            }
        }
        return oldest;
    }

    /* Assignment 7.30: tell whether the par same Workers
    * as executor using equals from Worker class */

    public boolean equals(WorkerList par){
        int upperLimit = (this.itsSize <= par.itsSize) ? this.itsSize : par.itsSize;
        for(int i = 0; i < upperLimit; i++){
            if(!this.itsItem[i].equals(par.itsItem[i])){
                return false;
            }
        }
        return true;
    }

    /*Assignment 7.31: return new WorkerList object containing
    * only the Worker objects whose pay is above average. */

    public WorkerList highOnes(){
        WorkerList highlyPaid = new WorkerList(this.itsItem.length);
        double averagePay = this.getAveragePay();

        for(int i = 0; i < this.itsSize; i++){
            if(this.itsItem[i].seeWeeksPay() > averagePay){
                highlyPaid.itsItem[i] = this.itsItem[i];
            }
        }
        return highlyPaid;
    }

    /* Assignment 7.32: executor adds all Worker values from
    * WorkerList parameter to its own list, stopping only when
    * the executor array becomes full. Throw exception if
    * given is null */

    public void addAll(WorkerList given){
        int sizeLimit = (given.itsSize < this.itsItem.length) ? given.itsSize : this.itsItem.length;

        try {
            if(given == null)
                throw new GivenIsNullException("Given is null!");

            for(int i = 0; i < sizeLimit; i++){
                this.itsItem[i] = given.itsItem[i];
            }

        } catch(GivenIsNullException gin){
            System.out.println(gin.getMessage());
        }
    }




    /* Unit 6 test question 3*/

    public boolean anyonePaidLessThan(double given){
        Buffin file = new Buffin("thefile.txt");
        /*WorkerList obj = new WorkerList(5);*/

        addFromFile(file);

        for(int i = 0; i < itsSize; i++){
            if(this.itsItem[i].seeWeeksPay() < given){
                return true;
            }
        }
        return false;
    }

    /* Unit 6 test question 4*/

    public double averageBirthYear(){
        Buffin file = new Buffin("thefile.txt");
        addFromFile(file);

        double sum = 0.0;

        if(itsSize == 0){
            return 0.0;
        } else {
            for(int i = 0; i < itsSize; i++){
                sum += itsItem[i].getBirthYear();
            }
            return sum / itsSize;
        }
    }


    /* Unit 6 test question 5 */

    public int[] countBirths(int timeSpan, int year){
        int[] count = new int[timeSpan + 1];

        Buffin file = new Buffin("thefile.txt");
        addFromFile(file);

        for(int i = 0; i < itsSize; i++){
            if(itsItem[i].getBirthYear() >= year && itsItem[i].getBirthYear() <= (timeSpan + year)){
                count[itsItem[i].getBirthYear() - year]++;
            }
        }

        //print
        for(int i = 0; i < count.length; i++){
            System.out.println((year + i) + ": " + count[i]);
        }

        return count;
    }
}


