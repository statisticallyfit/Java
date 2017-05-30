package semester2.chapter11;


public class Person {

    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String first, String last, int birth){
        this.firstName = first;
        this.lastName = last;
        this.birthYear = birth;
    }

    public boolean equals(Object ob){
        return ob instanceof Person
                && ((Person) ob).lastName.equals(this.lastName)
                && ((Person) ob).birthYear == this.birthYear;
    }
}
