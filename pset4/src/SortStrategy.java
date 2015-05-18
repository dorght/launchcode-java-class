import java.util.ArrayList;

/**
 * Created by Sean on 5/14/15.
 * SortStrategy is an interface for sort methods
 */
interface SortStrategy {
    public String getName();
    public void sort(int[] array);
    public void addTime(long time);
    public ArrayList<Long> getTimes();
}
