/**
 * Created by iHAL on 5/14/15.
 * a direct port of the insertion sort algorithm written in C for CS50x
 */
public class InsertionSort implements SortStrategy {
    // insertion sort implementation
    // 'unsorted' is first value in unsorted portion of array
    public void sort(int[] values) {
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
