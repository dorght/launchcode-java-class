import java.util.ArrayList;

/**
 * Created by Sean on 5/14/15.
 * BubbleSort class implements a bubble sort method and other interface required methods
 * The bubble sort algorithm is a direct port of the code I wrote in C for CS50x
 */
public class BubbleSort implements SortStrategy {
    public final String sortname = "Bubble Sort";

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
    @Override
    public void sort(int[] values) {
        int j = values.length - 1;
        while (j >= 0) {
            boolean swapped = false;
            for (int i = 0; i < j; i++) {
                if (values[i] > values[i + 1]) {
                    int tmp = values[i + 1];
                    values[i + 1] = values[i];
                    values[i] = tmp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
            j--;
        }
        return;
    }
}
