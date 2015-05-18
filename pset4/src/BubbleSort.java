/**
 * Created by Sean on 5/14/15.
 * a direct port of my bubble sort algorithm written in C for CS50x
 */
public class BubbleSort implements SortStrategy {
    public final String sortname = "Bubble Sort";

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
