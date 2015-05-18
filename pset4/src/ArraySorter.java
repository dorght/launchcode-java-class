/**
 * Created by Sean on 5/14/15.
 * ArraySorter class provides a method to set which sort method to implement and a method to perform that sort
 * using a Strategy design pattern
 */
public class ArraySorter {
    private SortStrategy sortStrategy;

    /**
     * setSorter method provides an accessible method of setting which sorting method to utilize
     * @param sorter
     */
    public void setSorter(SortStrategy sorter) {
        sortStrategy = sorter;
    }

    /**
     * performSort method provides an accessible method of calling the set sorter method
     * @param values integer array to be sorted
     */
    public void performSort(int[] values) {
        sortStrategy.sort(values);
    }
}

