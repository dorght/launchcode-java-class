import java.util.ArrayList;

/**
 * Created by iHAL on 5/14/15.
 * SelectionSort class implements a selection sort methods and other interface required methods
 * a direct port of my selection sort algorithm written in C for CS50x
 */
public class SelectionSort implements SortStrategy {

    // an arraylist to store execution times of various arrays sorted by this class
    public final String sortname = "Selection Sort";
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
    public void sort(int values[])
    {
        // selection sort implementation
        int j = 0;
        int n = values.length;
        while (j < n - 1)
        {
            // find minimum
            int min = j;
            for (int i = j + 1; i < n; i++)
            {
                if (values[i] < values[min])
                    min = i;
            }
            // swap
            int tmp = values[j];
            values[j] = values[min];
            values[min] = tmp;
            j++;
        }
    }
}
