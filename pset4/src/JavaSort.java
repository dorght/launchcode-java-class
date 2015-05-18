import java.util.Arrays;

/**
 * Created by iHAL on 5/14/15.
 */
public class JavaSort implements SortStrategy {
    public final String sortname = "Java Arrays.sort";

    // uses the Arrays.sort method which is a dual-pivot quicksort O(n log(n))
    @Override
    public void sort(int[] values) {
        Arrays.sort(values);
    }
}
