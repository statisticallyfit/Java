package semester2.chapter7.section_7_2_and_7_4.Personnel.TheShortWay;


import org.apache.commons.lang3.builder.CompareToBuilder;
import semester2.chapter7.section_7_1.Worker;

import java.util.Comparator;

public class WorkerCompareToBuilder implements Comparator<Worker> {

    @Override
    public int compare(Worker w1, Worker w2) {
        return new CompareToBuilder()
                .append(w1.getLastName(), w2.getLastName())
                .append(w1.getFirstName(), w2.getFirstName())
                .toComparison();
    }
}
