package semester1.chapter4.section_4_4;

/**
 * Created by user1928 on 11/21/14.
 */
public class Patient extends Person {

    private String doctor;

    //Rule: if body of instance method X mentions an instance variable without
    //specifying its executor, then its executor is by default the
    //executor of X ---> "this"
    public Patient(String first, String last, String doc){
        super(first, last);
        this.doctor = doc;
    }
}


/*
public class Patient extends Person {

    private String itsDoctor;

    public Patient(String first, String last, String doc){
        super(first, last);
        itsDoctor = doc;
    }
}
 */