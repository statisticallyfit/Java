package semester1.chapter4.section_4_5;

/**
 * Created by user1928 on 11/21/14.
 */

//For exercise 4.12
public class Person extends Object {

    private String itsFirstName;
    private String itsLastName;
    private int itsBirthYear;

    //constructor
    public Person (String first, String last, int birthYear){
        super();
        // "this" refers to object being constructed
        this.itsFirstName = first;
        this.itsLastName = last;
        this.itsBirthYear = birthYear;
    }

    public String getFirstName(){
        return this.itsFirstName;
    }

    public String getLastName(){
        return this.itsLastName;
    }

    public int getAge(int currentYear){
        if(currentYear < this.itsBirthYear){
            return 0;
        }//else
        return (currentYear - this.itsBirthYear);
    }
}