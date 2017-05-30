package semester2.chapter7.section_7_2_and_7_4.Fruit;

import org.apache.commons.lang3.builder.CompareToBuilder;
import java.util.Comparator;


public class FruitUsingCompareToBuilder implements Comparator<Fruit> {

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return new CompareToBuilder()
                .append(o1.getFruitName(), o2.getFruitName())
                .append(o1.getQuantity(), o2.getQuantity()).toComparison();
    }
}