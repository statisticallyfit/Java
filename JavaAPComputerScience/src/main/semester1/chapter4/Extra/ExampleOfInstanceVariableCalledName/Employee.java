package semester1.chapter4.Extra.ExampleOfInstanceVariableCalledName;

/**
 * Created by user1928 on 11/21/14.
 */

//From TutorialsPoint: http://www.tutorialspoint.com/java/java_variable_types.htm

public class Employee{
    // this instance variable is visible for any child class.
    public String name;

    // salary  variable is visible in Employee class only.
    private double salary;

    // The name variable is assigned in the constructor.
    public Employee (String empName){
        this.name = empName;
    }

    // The salary variable is assigned a value.
    public void setSalary(double empSal){
        this.salary = empSal;
    }

    // This method prints the employee details.
    public void printEmp(){
        System.out.println("name  :  " + name );
        System.out.println("salary :  " + salary);
    }

}

class ChangerOfInstanceVariables{
    public static void main(String args[]){

        Employee empOne = new Employee("Danielle");
        empOne.setSalary(1000);
        empOne.name = "Martha";
        empOne.printEmp();
    }
}