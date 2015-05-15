/**
 * Created by Sean on 5/14/15.
 */
public class BubbleSort implements SortStrategy {
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
