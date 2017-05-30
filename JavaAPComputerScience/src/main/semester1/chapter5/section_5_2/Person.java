package semester1.chapter5.section_5_2;
import java.util.Arrays;



public class Person implements Comparable<Person> {

    private static int theNumberOfPersons = 0;
    private String itsFirstName;
    private String itsLastName;
    private int itsBirthYear;
    private static String theLatestFirstName = "none so far"; //Exercise 5.7


    public Person(String first, String last, int year) {
        super();
        theNumberOfPersons++;
        this.itsFirstName = first;
        this.itsLastName = last;
        this.itsBirthYear = year;
        theLatestFirstName = itsFirstName;
    }

    //query methods - "getters"
    //action methods - "setters"

    public static int getTheNumberOfPersons() {
        return theNumberOfPersons;
    }

    public int getItsBirthYear() {
        return itsBirthYear;
    }

    public String getItsFirstName() {
        return itsFirstName;
    }

    public String getItsLastName() {
        return itsLastName;
    }

    public String getTheLatestFirstName() {
        return theLatestFirstName;
    }


    /*
     * For Assignment 5.9: compareTo method is implemented to help sort a list of Person objects
     * It overrides the compareTo() method in the Comparable interface
     */

    public int compareTo(Person p2) {

        Person p1 = this;
        return p1.itsBirthYear - p2.getItsBirthYear(); //ascending order

        //return p2.getItsBirthYear - p1.getItsBirthYear; //descending order
    }
}

class SmallestAndAverageBirthYears {

    /*
     * Assignment 5.9: "smallest birth year" means the the birth year number that is smallest
     * which refers to the oldest person
     * However, if "smallest birth year" means the birth year of the youngest person
     * the sort can be reversed so that the "biggest birth year" is returned, referring to the youngest person
     */

    public int getSmallestBirthYears() {
        Person[] persons = new Person[4];

        Person brother = new Person("Peter", "Jones", 1990);
        Person sister = new Person("Susan", "Jones", 1995);
        Person baby = new Person("Lucy", "Jones", 1998);
        Person grandpa = new Person("Grandpa", "Jones", 1920);

        persons[0] = brother;
        persons[1] = sister;
        persons[2] = baby;
        persons[3] = grandpa;


        if (persons.length == 0) {
            return -1;
        } else if (persons.length > 0) {
            Arrays.sort(persons); //calls the method compareTo(), which is implemented in the Person class
        }

        return persons[0].getItsBirthYear(); //return the smallest birth year. The smallest birth years are at the top
    }


    /**
     * Assignment 5.10: method returns the average birth year of all persons created
     */

    public int getAverageBirthYears() {
        int resultToReturn = 0;

        Person[] persons = new Person[4];

        Person brother = new Person("Peter", "Jones", 1990);
        Person sister = new Person("Susan", "Jones", 1995);
        Person baby = new Person("Lucy", "Jones", 1998);
        Person grandpa = new Person("Grandpa", "Jones", 1920);

        persons[0] = brother;
        persons[1] = sister;
        persons[2] = baby;
        persons[3] = grandpa;

        int sumOfBirthYears = 0;
        for (int i = 0; i < persons.length; i++) {
            sumOfBirthYears += persons[i].getItsBirthYear();
        }

        if(persons.length == 0){
            resultToReturn = 0; //no persons have been created
        }else if(persons.length > 0){
            resultToReturn = sumOfBirthYears / persons.length; //average of birth years
        }

        return resultToReturn;
    }

}



