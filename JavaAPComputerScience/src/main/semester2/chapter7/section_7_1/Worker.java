package semester2.chapter7.section_7_1;
import semester2.chapter6.section_6_4.StringInfo;




public class Worker implements Comparable {

    public static final double WEEK = 40.0; // regular work week
    public static final int NUM_DAYS = 5;   // days in 1 work week

    private String itsFirstName = null;
    private String itsLastName = null;
    private int itsBirthYear = 0;
    private double itsHourlyRate = 0;
    private double [] itsHoursPaid = {8, 8, 8, 8, 8}; // 1 per day

    /*Create a Worker from an input String, a single line with
    * first name, last name, year, and rate in that order.
    * If the String value is bad, the name is made null. */

    public Worker(String input){
        StringInfo si = new StringInfo(input);
        si.trimFront(0);

        if(si.toString().length() > 0) {
            itsFirstName = si.firstWord();

            si.trimFront (itsFirstName.length()); //cleaning up si for the next operation
            itsLastName = si.firstWord();

            si.trimFront (itsLastName.length());
            itsBirthYear = (int) si.parseDouble (-1);

            si.trimFront (si.firstWord().length());
            itsHourlyRate = si.parseDouble(-1);
        }
        if(itsBirthYear < 0 || itsHourlyRate < 0){
            itsLastName = null;  // in case of bad input
        }
    }

    public String getName() { return (itsLastName == null)  ?  null :  itsFirstName + " " + itsLastName;}
    public String getFirstName() { return itsFirstName; }
    public String getLastName() { return itsLastName; }
    public int getBirthYear() { return itsBirthYear; }

    /*Return Worker's gross pay for the week. */

    public double seeWeeksPay(){
        double sum = 0.0;
        for(int i = 0;  i < NUM_DAYS;  i++) {
            sum += itsHoursPaid[i];
        }
        return sum <= WEEK  ?  itsHourlyRate * sum
                :  itsHourlyRate * (sum + (sum - WEEK)/2);
        // sum * 1.5 - WEEK/2 could be replaced by:
        // sum + (sum - WEEK)/2 to add the time and a half hours

    }

    /*Exercise 7.21: revise seeWeeksPay() to pay time and a half for hours
    * in excess of 8 in a single day, summed over NUM_DAYS days*/

    public double seeWeeksPayEight(){
        double sum = 0.0;
        for(int i = 0; i < NUM_DAYS; i++){
            sum += (itsHoursPaid[i] <= 8) ? itsHoursPaid[i] : itsHoursPaid[i] + (itsHoursPaid[i] - 8)/2;
        }
        return sum * itsHourlyRate;
    }

    /*Record hours worked in the most recent day. */

    public void addHoursWorked(double hoursWorked){
        for(int k = NUM_DAYS - 1;  k > 0;  k--) {
            itsHoursPaid[k] = itsHoursPaid[k - 1];
        }
        itsHoursPaid[0] = hoursWorked;
    }

    /*Return 0 if equal, negative if executor is before ob
    * (executor has an earlier last name or else the same last name
    * and earlier first name), positive otherwise.
    * Precondition: ((Worker)ob).getName() is non-null. */

    public int compareTo(Object obj){
        Worker that = (Worker) obj;
        int comp = this.itsLastName.compareTo (that.itsLastName);
        return  comp != 0  ?  comp
                : this.itsFirstName.compareTo (that.itsFirstName);

    }

    /*Tell whether one Worker has the same name as another. */

    public boolean equals(Worker worker){
        return worker != null && this.itsLastName != null
                && this.itsLastName.equals (worker.itsLastName)
                && this.itsFirstName.equals (worker.itsFirstName);
    }

    /*Return a String value containing most or all of the Worker's
    * data, suitable for printing in  a report. */

    public String toString(){
        return itsLastName + ", " + itsFirstName + "; born "
                + itsBirthYear + ". rate = " + itsHourlyRate;
    }

    /*Exercise 7.1*/

    public static void averageDailyPay(Worker worker){
        System.out.println("Worker " + worker.getName() + " has average daily pay of " + worker.seeWeeksPay() / 5);
    }







    /* Unit 6 Test Question */

    public double getHighestFrequencyOfHoursWorked(){
        double highestSoFar = itsHoursPaid[0];

        for(int i = 0; i < itsHoursPaid.length; i++){
            if(itsHoursPaid[i] > highestSoFar){
                highestSoFar = itsHoursPaid[i];
            }
        }

        return highestSoFar;
    }
}
