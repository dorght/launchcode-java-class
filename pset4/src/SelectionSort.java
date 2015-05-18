/**
 * Created by iHAL on 5/14/15.
 * a direct port of my selection sort algorithm written in C for CS50x
 */
public class SelectionSort implements SortStrategy {
    public final String sortname = "Selection Sort";

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
