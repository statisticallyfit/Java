/*
package semester2.chapter7.section_7_2.Personnel.TheLongWay;

import semester2.chapter7.section_7_1.Worker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
*/
/**
 * This is a chained comparator that is used to sort a list by multiple
 * attributes by chaining a sequence of comparators of individual fields
 * together.
 *
 *//*

public class PersonnelChainedComparator implements Comparator<Worker> {

    private List<Comparator<Worker>> listComparators;


    public PersonnelChainedComparator(Comparator<Worker>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(Worker w1, Worker w2) {
        for (Comparator<Worker> comparator : listComparators) {
            int result = comparator.compare(w1, w2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
*/
