package semester1.chapter4.section_4_4;

/**
 * Created by user1928 on 11/21/14.
 */
public class Person extends Object {

    private String firstName;
    private String lastName;

    //constructor
    public Person (String first, String last){
        super();
        // "this" refers to object being constructed
        this.firstName = first;
        this.lastName = last;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
}


/*
public class Person extends Object {

    private String itsFirstName;
    private String itsLastName;

    //constructor
    public Person (String first, String last){
        super();
        itsFirstName = first;
        itsLastName = last;
    }

    public String getFirstName(){
        return itsFirstName;
    }

    public String getLastName(){
        return itsLastName;
    }
}
 */