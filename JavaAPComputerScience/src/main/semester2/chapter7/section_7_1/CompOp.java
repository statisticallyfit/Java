package semester2.chapter7.section_7_1;


public class CompOp {
    /** Return the String representation of the last/largest of
     *  three Comparable values. */

    public static String lastOne (Comparable first, Comparable second, Comparable third) {

        /* Arguments are Comparable type : that means arguments must be of types that
        * implement Comparable (like String class or Worker class...)  */

         Comparable last =  first.compareTo(second) >= 0 ?  first  :  second;
        if (last.compareTo(third) < 0){
            last = third;
        }
        return last.toString(); //polymorphic -- if last is Worker type, toString() is Worker's,
        // but if last is String, then String's toString() is called
    }

    /*Exercise 7.3: return youngest of workers*/

    public static String youngestOne(Worker first, Worker second, Worker third){

        Worker youngest = first.getBirthYear() >= second.getBirthYear() ? second : first;
        youngest = youngest.getBirthYear() <= third.getBirthYear() ? youngest : third;
        return youngest.toString();
    }

    /*Return oldest of workers */

    public static String oldestOne(Worker first, Worker second, Worker third){
        Worker oldest =   first.getBirthYear() >= second.getBirthYear()  ?  first : second;
        if (oldest.getBirthYear() < third.getBirthYear())
            oldest = third;
        return oldest.toString();
    }

    /*Assignment 7.6: Return name and pay of person with lowest weekly pay. */

    public static String lowestWeeklyPay(Worker first, Worker second, Worker third) {
        Worker lowest = first.seeWeeksPay() >= second.seeWeeksPay() ? second : first;
        lowest = lowest.seeWeeksPay() <= third.seeWeeksPay() ? lowest : third;
        return lowest.getName() + " has lowest weekly pay of " + lowest.seeWeeksPay();
    }

    public static void main(String[] args) {
        System.out.println(lowestWeeklyPay(new Worker("Isabel Dasilva 11 3.30"), new Worker("Bo Tucker 10 3.30"), new Worker("Will Hawkins 11 3.30")));
    }
}