/**
 * Created by Sean on 5/14/15.
 */
public class ArraySorter {
    private SortStrategy sortStrategy;

    public void setSorter(SortStrategy sorter) {
        sortStrategy = sorter;
    }

    public void sortFunction (int[] temp) {
        sortStrategy.sort(temp);
    }

    public static int stopWatch() {
        int starttime = 0;
        int endtime = 0;
        //read clock to find start time
        // starttime != 0
        // read clock again then subtract to find elapsed time
        return (endtime - starttime);
    }

    public static void main (String[] args) {
        int[] random = {3,5,1,9,7};
System.out.println(random);
        ArraySorter temp = new ArraySorter();
        temp.setSorter(new BubbleSort());
        temp.sortFunction(random);
        System.out.println(random);
    }
}
