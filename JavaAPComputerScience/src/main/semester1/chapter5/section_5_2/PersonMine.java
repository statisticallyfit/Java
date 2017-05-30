package semester1.chapter5.section_5_2;

/**
 * Created by user1928 on 12/16/14.
 */

import java.util.Arrays;

/**
 * INFO TO PROVIDE FOR CLASSES:
 * <p/>
 * 1) class query method (such as static getAge() )
 * 2) class variables with initialization
 * 3) statements to update class variable if needed
 * <p/>
 * INFO TO PROVIDE FOR OBJECTS:
 * <p/>
 * 1) instance query method (such as [nonstatic] getAge() )
 * 2) instance variable sometimes with initialization (can be done in constructors)
 * 3) statements to update instance variables if needed
 */

public class PersonMine implements Comparable<Person> {

    private static int theNumberOfPersons = 0;
    private String itsFirstName;
    private String itsLastName;
    private int itsBirthYear;
    private static String theLatestFirstName = "none so far"; //Exercise 5.7


    public PersonMine(String first, String last, int year) {
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
     * For Assignment 5.9: compareTO method is implemented to help sort a list of Person objects
     */

    //This method overrides the compareTo() method in the Comparable interface. Associated with CODE # 1
    //This method does the same thing as the compare() method of Comparator interface
    public int compareTo(Person p2) {

        PersonMine p1 = this; //reference

        /*System.out.println("FIRST " + p1.getItsFirstName() + ", " + p1.getItsBirthYear() +
                "     SECOND " + p2.getItsFirstName() + ", " + p2.getItsBirthYear());*/

        //ascending order
        return p1.itsBirthYear - p2.getItsBirthYear();

        //descending order
        //return p2.getItsBirthYear - p1.getItsBirthYear;
    }
}

/*
This class implements Comparator interface. Associated with CODE #2
This method does the same thing as the compareTo() method of Comparable interface
 */
/*class PersonComparator implements Comparator<Person> {

    public int compare(Person p1, Person p2) {

        System.out.println("FIRST " + p1.getItsFirstName() + ", " + p1.getItsBirthYear() +
                "     SECOND " + p2.getItsFirstName() + ", " + p2.getItsBirthYear());

        //ascending order
        return p1.getItsBirthYear() - p2.getItsBirthYear();

        String pName1 = p1.getItsFirstName().toUpperCase();
        String pName2 = p2.getItsFirstName().toUpperCase();

        //ascending order
        return pName1.compareTo(pName2);


        //descending order
        //return pName2.compareTo(pName1);
    }

}*/



class SmallestAndAverageBirthYearsMINE {

    /*
     * Assignment 5.9: "smallest birth year" means the the birth year number that is smallest
     * which refers to the oldest person
     * However, if "smallest birth year" means the birth year of the youngest person
     * the sort can be reversed so that the "biggest birth year" is returned, referring to the youngest person
     */

    public int getSmallestBirthYears() {
        PersonMine[] persons = new PersonMine[4];

        PersonMine brother = new PersonMine("Peter", "Jones", 1990);
        PersonMine sister = new PersonMine("Susan", "Jones", 1995);
        PersonMine baby = new PersonMine("Lucy", "Jones", 1998);
        PersonMine grandpa = new PersonMine("Grandpa", "Jones", 1920);

        persons[0] = brother;
        persons[1] = sister;
        persons[2] = baby;
        persons[3] = grandpa;


        if (persons.length == 0) {
            return -1;
        } else if (persons.length > 0) {

            Arrays.sort(persons);
            //CODE #1 this code is used to call the method of the ComparABLE interface.
            // Its method compareTo() is implemented inside the Personclass
            // How this works: Arrays.sort(persons) calls the method compareTo()

            //Arrays.sort(persons, new PersonComparator());
            // CODE #2 this is used with the Comparator interface.
            // Its method compare() is implemented outside the Person class
            //How this would work: Arrays.sort(persons, new PersonComparator()) calls the method compare()
        }

        return persons[0].getItsBirthYear(); //return the smallest birth year. The smallest birth years are at the top
    }


    public int getAverageBirthYears() {
        PersonMine[] persons = new PersonMine[4];

        PersonMine brother = new PersonMine("Peter", "Jones", 1990);
        PersonMine sister = new PersonMine("Susan", "Jones", 1995);
        PersonMine baby = new PersonMine("Lucy", "Jones", 1998);
        PersonMine grandpa = new PersonMine("Grandpa", "Jones", 1920);

        persons[0] = brother;
        persons[1] = sister;
        persons[2] = baby;
        persons[3] = grandpa;

        int sumOfBirthYears = 0;
        for (int i = 0; i < persons.length; i++) {
            sumOfBirthYears += persons[i].getItsBirthYear();
        }

        return sumOfBirthYears / persons.length; //average of birth years
    }


}




