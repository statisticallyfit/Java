package semester2.chapter7.section_7_2_and_7_4.Employee.TheLongWay;

import java.util.Comparator;

/**
 * This comparator compares two employees by their salaries.
 */
public class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getSalary() - emp2.getSalary();
    }
}