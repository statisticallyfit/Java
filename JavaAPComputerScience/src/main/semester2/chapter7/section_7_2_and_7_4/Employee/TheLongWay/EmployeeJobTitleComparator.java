package semester2.chapter7.section_7_2_and_7_4.Employee.TheLongWay;

import java.util.Comparator;

/**
 * This comparator compares two employees by their job titles.
 */
public class EmployeeJobTitleComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getJobTitle().compareTo(emp2.getJobTitle());
    }
}
