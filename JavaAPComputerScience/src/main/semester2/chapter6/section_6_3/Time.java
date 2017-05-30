package semester2.chapter6.section_6_3;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by user1928 on 11/21/14.
 */
public class Time implements Comparable /*Comparable implemented in chapter 6*/{

    //declare instance variables
    private int itsDays; //Assignment 4.18, part a) instance variable itsDays is added here
    private int itsHour;
    private int itsMin;


    /*
     * Assignment 4.18, part b) parameter itsDays is added
     *
     *
     * Assignment 4.20: says to revise the constructor as stated in 4.19;
     * but Mrs. Creasy approved the use of normalizeDHM() for all exercises,
     * so assignment 4.20 is completed as below.
     *
     *
     * Assignment: 4.33: Write out the full Time constructor as:
     * public Time(int totalMinutes) and allow for negative inputs.
     *
     */

    //first constructor with args list: days, hour, min
    public Time(int days, int hour, int min) {
        super();  //super() call to the Object class is implicit -- doesn't need to be made explicit

        init(days, hour, min); //initializing with days, hours, min
    }

    //second constructor with arg list: totalMinutes
    public Time(int totalMinutes) {
        super();
        init(0, 0, totalMinutes); // given totalMins, pass this to normalizeDHM() to store the correct values in itsDays, itsHour, itsMin
    }

    private void init(int days, int hour, int min) {
        int[] dhm = normalizeDHM(days, hour, min);
        itsDays = dhm[0];
        itsHour = dhm[1];
        itsMin = dhm[2];
    }

    public int getItsDays(){
        return itsDays;
    }

    public int getItsHour() {
        return itsHour;
    }

    public int getItsMin() {
        return itsMin;
    }

    //Assignment 4.18, part c) instance method is added to give day of week
    public static String setDayOfWeek(int days){
        String dayStr;
        switch(days){
            case 1: dayStr = "Monday";
                return(dayStr);
            case 2: dayStr = "Tuesday";
                return(dayStr);
            case 3: dayStr = "Wednesday";
                return(dayStr);
            case 4: dayStr = "Thursday";
                return(dayStr);
            case 5: dayStr = "Friday";
                return(dayStr);
            case 6: dayStr = "Saturday";
                return(dayStr);
            case 7: dayStr = "Sunday";
                return(dayStr);

        }
        return "No day has fully passed"; // if case 0
    }

    /**
     * Exercise 4.14 revise the method
     */
    public String toString() {
        String value = null;
        final int BASE = 10; //Exercise 5.11

        if (itsHour < BASE && itsMin < BASE) {
            value = "Day: " + setDayOfWeek(itsDays) + "  " + ("0" + itsHour) + ":" + "0" + itsMin;
        }
        if (itsHour < BASE && itsMin >= BASE) {
            value = "Day: " + setDayOfWeek(itsDays) + "  " + ("0" + itsHour) + ":" + itsMin;
        }
        if (itsHour >= BASE && itsMin < BASE) {
            value = "Day: " + setDayOfWeek(itsDays) + "  " + ("" + itsHour) + ":" + "0" + itsMin; //put "" so returns string
        }
        if (itsHour >= BASE && itsMin >= BASE) {
            value = "Day: " + setDayOfWeek(itsDays) + "  " + ("" + itsHour) + ":" + itsMin; //put "" so returns string
        }
        return value;
    }

    /*Precondition: ob is a time object */
    public int compareTo(Object ob){
        Time that = (Time)ob;
        return this.itsHour != that.itsHour
                ? this.itsHour - that.itsHour
                : this.itsMin - that.itsMin;
    }

    public boolean equals(Time that){
        return that != null
                && this.itsDays == that.itsDays
                && this.itsHour == that.itsHour
                && this.itsMin == that.itsMin;
    }

    /**
     * Exercise 4.15 (not an assignment): add() uses normalizeDHM(), which Mrs. Creasy approved.
     * Also accounts for days, even though not required, but this was approved by Mrs. Creasy
     */

    public Time add(Time that) {

        int[] addedDaysHoursMin = normalizeDHM(this.itsDays + that.itsDays, this.itsHour + that.itsHour, this.itsMin + that.itsMin);

        return new Time(addedDaysHoursMin[0], addedDaysHoursMin[1], addedDaysHoursMin[2]);
    }

    /**
     * Assignment 4.17: subtract() uses normalizeDHM(), which Mrs. Creasy approved.
     * Also accounts for days, even though not required, but this was approved by Mrs. Creasy
     */
    public Time subtract(Time that){
        int[] subtractedDaysHoursMin = normalizeDHM(this.itsDays - that.itsDays, this.itsHour - that.itsHour, this.itsMin - that.itsMin);

        return new Time(subtractedDaysHoursMin[0], subtractedDaysHoursMin[1], subtractedDaysHoursMin[2]);
    }


    /**
     * Assignment 4.19: method normalizeDHM() adjusts for negative input and adjusts for minutes greater
     * than 59 and for hours greater than 24.
     * Also accounts for days, even though not required, but this was approved by Mrs. Creasy
     */
    private static int[] normalizeDHM(int days, int hours, int minutes) {
        //correct for negative days, hours, or mins:
        while(minutes < 0){
            minutes += 60;
            hours--;
        }
        while(hours < 0){
            hours += 24;
        }
        while(days < 0){
            days += 7;
        }
        while(days > 7){
            days -= 7;
        }

        // convert hours to minutes and sum them
        int totalMinutes = minutes;

        totalMinutes += 60 * hours;
        totalMinutes += 60 * (24 * days);

        /*converting from minutes to hours to days
        hoursMin = minutes to hours; daysHours = hours to days*/
        BigDecimal[] hoursMin = new BigDecimal(totalMinutes).divideAndRemainder(new BigDecimal(60));
        BigDecimal[] daysHours = hoursMin[0].divideAndRemainder(new BigDecimal(24));
        return new int[]{daysHours[0].intValue(), daysHours[1].intValue(), hoursMin[1].intValue()}; // int[] {days, hours, min}
    }


    /*
     * Assignment 4.16:
     *
     * PROCESS:
     * timeInMinutes() gets the current date, stored in object date, which stores the time in milliseconds since Jan 1, 1970 midnight
     * Then it formats date to get currentDayStr in form yyyy/MM/dd
     * Then currentDayStr is concatenated to " 00:00:00" to get currentDayMidnight
     * Finally it subtracts the current date (date.getTime(), time in millis since Jan1 1970) ...
     * ....with the current date at midnight (currentDayMidnight.getTime(), time in millis since the current date's midnight)
     */
    public static void timeInMinutes(){

        //DateFormat objects can have just year/month/day or that as well as HH:mm:ss
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        //get current date time with Date()
        Date date = new Date();

        try {
            /**
             * currentDayStr is in form yyyy/MM/dd since dateFormat object is called
             */
            String currentDayStr = dateFormat.format(date);

            /*
             * Make object dateTimeFormat accept argument "00:00:00" as the HH:mm:ss part since dateTimeFormat takes hours, min , ss too
             * Because currentDayMidnight must be in same format as date object
             * So that we can find diffMillis = difference in milliseconds
             */
            Date currentDayMidnight = dateTimeFormat.parse(currentDayStr + " 00:00:00");

            // subtract and convert to minutes
            long diffMillis = date.getTime() - currentDayMidnight.getTime();
            long diffMins = diffMillis/1000/60;
            System.out.println("Total number of minutes since midnight: " + diffMins);
        } catch (ParseException e) { //to catch error if dateTimeFormat cannot parse the currentDayStr with "00:00:00"
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        checkCorrectness();
    }




    //-------------------TESTING AREA-----------------//

    private static void checkCorrectness() {

        assertThat(Arrays.equals(normalizeDHM(0, 0, 59), new int[]{0, 0, 59}));
        assertThat(Arrays.equals(normalizeDHM(0, 0, 59), new int[]{0, 0, 59}));
        assertThat(Arrays.equals(normalizeDHM(0, 0, 60), new int[]{0, 1, 0}));
        assertThat(Arrays.equals(normalizeDHM(0, 0, 120), new int[]{0, 2, 0}));
        assertThat(Arrays.equals(normalizeDHM(0, 1, 10), new int[]{0, 1, 10}));
        assertThat(Arrays.equals(normalizeDHM(0, 23, 10), new int[]{0, 23, 10}));
        assertThat(Arrays.equals(normalizeDHM(0, 24, 10), new int[]{1, 0, 10}));
        assertThat(Arrays.equals(normalizeDHM(0, 27, 10), new int[]{1, 3, 10}));
        assertThat(Arrays.equals(normalizeDHM(0, -7, -10), new int[]{0, 16, 50}));
        assertThat(Arrays.equals(normalizeDHM(0, 0, -60), new int[]{0, 23, 0}));
        assertThat(Arrays.equals(normalizeDHM(0, 0, -120), new int[]{0, 22, 0}));
        assertThat(Arrays.equals(normalizeDHM(0, 1, -63), new int[]{0, 23, 57}));
        assertThat(Arrays.equals(normalizeDHM(0, 0, -151), new int[]{0, 21, 29}));
        assertThat(Arrays.equals(normalizeDHM(-1, 0, -150), new int[]{6, 21, 30}));
        assertThat(Arrays.equals(normalizeDHM(4, -4, -90), new int[]{4, 18, 30}));
        assertThat(Arrays.equals(normalizeDHM(1, -3, -12), new int[]{1, 20, 48}));
        assertThat(Arrays.equals(normalizeDHM(4, 40, 0), new int[]{5, 16, 0}));
        assertThat(Arrays.equals(normalizeDHM(5, 38, 68), new int[]{6, 15, 8}));
        assertThat(Arrays.equals(normalizeDHM(20, 0, 0), new int[]{6, 0, 0}));


        {
            Time time1 = new Time(4, 18, 20);
            Time time2 = new Time(1, 20, 48);
            Time time3 = new Time(6, 15, 8);

            if (!(time1.add(time2)).equals(time3)){
                System.err.println("Error with add method");
            }
        }

        {
            if(!setDayOfWeek(1).equals("Monday")){
                System.err.println("Error 1");
            }
            if(!setDayOfWeek(2).equals("Tuesday")){
                System.err.println("Error 2");
            }
            if(!setDayOfWeek(3).equals("Wednesday")){
                System.err.println("Error 3");
            }
            if(!setDayOfWeek(4).equals("Thursday")){
                System.err.println("Error 4");
            }
            if(!setDayOfWeek(5).equals("Friday")){
                System.err.println("Error 5");
            }
            if(!setDayOfWeek(6).equals("Saturday")){
                System.err.println("Error 6");
            }
            if(!setDayOfWeek(7).equals("Sunday")){
                System.err.println("Error 7");
            }
            if(!setDayOfWeek(0).equals("No day has fully passed")){
                System.err.println("Error 0");
            }
        }

        {
            Time t1 = new Time(0, 7, 20);
            Time t2 = new Time(0, 14, 30);

            if(!t1.subtract(t2).equals(new Time(0, 16, 50))){
                System.err.println("Incorrect answer");
            }
        }


        {
            Time t1 = new Time(0, 13, 25);
            Time t2 = new Time(0, 14, 20); //changed from 8, -150

            if (!t1.add(t2).equals(t2.add(t1))) {
                System.err.println("Error 1");
            }
        }

        {
            Time t1 = new Time(0, 13, 75);

            if (t1.getItsHour() != 14) {
                System.err.println("Error 2");
            }

            if (t1.getItsMin() != 15) {
                System.err.println("Error 3");
            }

        }
        {
            Time t1 = new Time(0, 0, 0);

            if (t1.getItsHour() != 0) {
                System.err.println("Error 2");
            }

            if (t1.getItsMin() != 0) {
                System.err.println("Error 3");
            }

        }
        {
            Time t1 = new Time(0, 0, 59);

            if (t1.getItsHour() != 0) {
                System.err.println("Error 2");
            }

            if (t1.getItsMin() != 59) {
                System.err.println("Error 3");
            }

        }
        {
            Time t1 = new Time(0, 0, 60);

            if (t1.getItsHour() != 1) {
                System.err.println("Error 2");
            }

            if (t1.getItsMin() != 0) {
                System.err.println("Error 3");
            }

        }
        {
            Time t1 = new Time(0, 0, 61);

            if (t1.getItsHour() != 1) {
                System.err.println("Error 2");
            }

            if (t1.getItsMin() != 1) {
                System.err.println("Error 3");
            }

        }

    }

    private static void assertThat(boolean isTrue) {
        if (!isTrue) {
            System.out.println("This did not work!");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        return itsHour == time.itsHour &&
                itsMin == time.itsMin;

    }

    @Override
    public int hashCode() {
        int result = itsHour;
        result = 31 * result + itsMin;
        return result;
    }
}
