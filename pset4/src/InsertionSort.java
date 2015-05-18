import java.util.ArrayList;

/**
 * Created by iHAL on 5/14/15.
 * InsertionSort class implements a insertion sort method and other interface required methods
 * a direct port of my insertion sort algorithm written in C for CS50x
 */
public class InsertionSort implements SortStrategy {
    public final String sortname = "Insertion Sort";

    // an arraylist to store execution times of various arrays sorted by this class
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
    public void sort(int[] values) {
        // 'unsorted' is first value in unsorted portion of array
        int unsorted = 1;
        int n = values.length;
        while (unsorted < n) {
            int sorted = unsorted - 1;
            int tmp = values[unsorted];

            // move arrays elements in sorted portion higher until insertion pt
            while (sorted >= 0 && tmp < values[sorted]) {
                values[sorted + 1] = values[sorted];
                sorted--;
            }

            // insert value into sorted portion
            values[sorted + 1] = tmp;
            unsorted++;
        }
    }
}
