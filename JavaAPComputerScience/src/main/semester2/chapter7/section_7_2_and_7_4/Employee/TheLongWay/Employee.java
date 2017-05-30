package semester2.chapter7.section_7_2_and_7_4.Employee.TheLongWay;


/*This is the model class containing foundations */

public class Employee {
    private String name;
    private String jobTitle;
    private int age;
    private int salary;

    public Employee(String name, String jobTitle, int age, int salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.age = age;
        this.salary = salary;
    }

    public String getName(){
        return this.name;
    }
    public String getJobTitle(){
        return this.jobTitle;
    }
    public int getAge(){
        return this.age;
    }
    public int getSalary(){
        return this.salary;
    }

    public String toString() {
        return String.format("%s\t%s\t%d\t%d", name, jobTitle, age, salary);
    }
}
