import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by iHAL on 5/14/15.
 * JavaSort class calls the Arrays.sort for comparison purposes and other interface required methods
 */
public class JavaSort implements SortStrategy {

    // an arraylist to store execution times of various arrays sorted by this class
    public final String sortname = "Java Arrays.sort";
    private ArrayList<Long> times = new ArrayList<Long>();

    /**
     * getTimes method returns the arraylist of sort execution times
     * @return ArrayList of long type nanosecond times
     */
    @Override
    public ArrayList<Long> getTimes() {
        return times;
    }

    /**
     * addTime method adds the sort execution time to the arraylist
     * @param time long type of time in nanoseconds
     */
    @Override
    public void addTime(long time) {
        times.add(time);
    }

    /**
     * getName method to retrieve the sort method's name
     * @return String of the sort method's name
     */
    @Override
    public String getName() {
        return sortname;
    }

    /**
     * sort method sorts an array of integers in place
     * @param values int array to be sorted
     */
    @Override
    public void sort(int[] values) {
        // uses the Arrays.sort method which is a dual-pivot quicksort O(n log(n))
        Arrays.sort(values);
    }
}
