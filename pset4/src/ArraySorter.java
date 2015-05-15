import java.util.Arrays;

import static java.lang.System.nanoTime;

/**
 * Created by Sean on 5/14/15.
 */
public class ArraySorter {
    private SortStrategy sortStrategy;

    public void setSorter(SortStrategy sorter) {
        sortStrategy = sorter;
    }

    public void sortFunction (int[] temp) {
        sortStrategy.sort(temp);
    }

    public static void main (String[] args) {
        int[] random = {3,5,1,9,7,7};
System.out.println(Arrays.toString(random));
        ArraySorter temp = new ArraySorter();
        temp.setSorter(new SelectionSort());
        long starttime = nanoTime();
        temp.sortFunction(random);
        long endtime = nanoTime();
System.out.println(Arrays.toString(random));
        long elapsed = endtime - starttime;
System.out.println("" + elapsed + " nanoseconds");
    }
}
