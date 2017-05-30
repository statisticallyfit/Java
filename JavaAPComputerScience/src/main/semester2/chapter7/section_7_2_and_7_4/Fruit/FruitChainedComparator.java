package semester2.chapter7.section_7_2_and_7_4.Fruit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FruitChainedComparator implements Comparator<Fruit> {

    private List<Comparator<Fruit>> listComparators;

    @SafeVarargs
    public FruitChainedComparator(Comparator<Fruit>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(Fruit fruit1, Fruit fruit2) {
        for (Comparator<Fruit> comparator : listComparators) {
            int result = comparator.compare(fruit1, fruit2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
