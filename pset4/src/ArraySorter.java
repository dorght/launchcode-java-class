
/**
 * Created by Sean on 5/14/15.
 */
public class ArraySorter {
    private SortStrategy sortStrategy;

    public void setSorter(SortStrategy sorter) {
        sortStrategy = sorter;
    }

    public void performSort(int[] values) {
        sortStrategy.sort(values);
    }
}

