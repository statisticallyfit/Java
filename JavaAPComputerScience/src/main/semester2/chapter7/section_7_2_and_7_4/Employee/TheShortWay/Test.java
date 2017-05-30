package semester2.chapter7.section_7_2_and_7_4.Employee.TheShortWay;

import org.apache.commons.lang3.builder.CompareToBuilder;
import semester2.chapter7.section_7_2_and_7_4.Employee.TheLongWay.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class EmployeeUsingCompareToBuilder implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return new CompareToBuilder()
                .append(o1.getJobTitle(), o2.getJobTitle())
                .append(o1.getAge(), o2.getAge())
                .append(o1.getSalary(), o2.getSalary()).toComparison();
    }
}

public class Test {
    public static void main(String[] args) {

        List<Employee> listEmployees = new ArrayList<Employee>();

        listEmployees.add(new Employee("Tom", "Developer", 45, 80000));
        listEmployees.add(new Employee("Sam", "Designer", 30, 75000));
        listEmployees.add(new Employee("Bob", "Designer", 45, 134000));
        listEmployees.add(new Employee("Peter", "Programmer", 25, 60000));
        listEmployees.add(new Employee("Tim", "Designer", 45, 130000));
        listEmployees.add(new Employee("Craig", "Programmer", 30, 52000));
        listEmployees.add(new Employee("Anne", "Programmer", 25, 51000));
        listEmployees.add(new Employee("Alex", "Designer", 30, 120000));
        listEmployees.add(new Employee("Bill", "Programmer", 22, 30000));
        listEmployees.add(new Employee("Samuel", "Developer", 28, 80000));
        listEmployees.add(new Employee("John", "Developer", 35, 67000));
        listEmployees.add(new Employee("Patrick", "Developer", 35, 140000));
        listEmployees.add(new Employee("Alice", "Programmer", 35, 80000));
        listEmployees.add(new Employee("David", "Developer", 35, 99000));
        listEmployees.add(new Employee("Jane", "Designer", 30, 82000));

        System.out.println("*** Before sorting:");
        printEmps(listEmployees);

        Collections.sort(listEmployees, new EmployeeUsingCompareToBuilder());

        System.out.println("\n*** After sorting:");
        printEmps(listEmployees);
    }

    public static void printEmps(List<Employee> list){
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }
}
