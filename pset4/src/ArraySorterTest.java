import java.util.Arrays;
import static java.lang.System.nanoTime;

/**
 * Created by Sean on 5/15/15
 * ArraySorterTest is meant to test the ArraySorter class and the classes that implement it
 */
public class ArraySorterTest {

    /**
     * fillArray method fills the passed array with random integers
     * @param array an integer array
     */
    public void fillArray (int[] array) {
        for (int i = 0, n = array.length; i < n; i++) {
            array[i] = (int) (Math.random() * 32175);   // Integer.MAX_VALUE
        }
    }

    /**
     * reverseArray method reverses, in place, the order of elements in an array
     * @param array an integer array
     */
    public void reverseArray(int[] array) {
        if (array.length < 2)
            return;

        int j = array.length - 1;
        int n = array.length / 2;
        int temp;
        for (int i = 0; i < j; i++) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            j--;
        }
    }

    // time how long to sort the array

    /**
     * timeSort method calls the passed sort method and times its execution
     * @param arraySorter an ArraySorter instance that has set the sort method to be used
     * @param array an integer array to have its sorting timed
     * @return the time in nanoseconds (1e-9s) measured to complete the sort of the passed array
     */
    public long timeSort(ArraySorter arraySorter, int[] array) {
        long starttime = nanoTime();
        arraySorter.performSort(array);
        long endtime = nanoTime();
        arraySorter.performSort(array);

        return (endtime - starttime);
    }

    public static void main (String[] args) {
        // add any new sort classes to this line
        SortStrategy[] methods = {new BubbleSort(), new InsertionSort(), new JavaSort(), new SelectionSort()};

        ArraySorterTest arraySorterTest = new ArraySorterTest();
        ArraySorter arraySorter = new ArraySorter();


        // generate an array with random elements
        int[] random = new int[5000];
        arraySorterTest.fillArray(random);

        // create an array from the random array with elements already sorted
        int[] ordered = new int[5000];
        ordered = Arrays.copyOf(random, random.length);
        Arrays.sort(ordered);

        // create an array from the ordered array all elements in reverse sort order
        int[] reversed = new int[5000];
        reversed = Arrays.copyOf(random, random.length);
        arraySorterTest.reverseArray(reversed);

        int[][] testarrays = {random, ordered, reversed};

        // run each sort method on each test array
        for (SortStrategy sorter : methods) {
            arraySorter.setSorter(sorter);

            // run for each variety of test array
            for (int j = 0, n = testarrays.length; j < n; j++) {
                // copy the original array so it is not altered and identical array reused on other methods
                int[] testarray = Arrays.copyOf(testarrays[j], testarrays[j].length);

                // time the sorting of the array then push it unto the sorting class's time arraylist
                long time = arraySorterTest.timeSort(arraySorter, testarray);
                sorter.addTime(time);
            }
        }

        // display matrix of sorting time results
        System.out.println("(times in msec)       Random     Ordered    Reversed");
        for (SortStrategy sorter : methods) {
            System.out.printf("%-16s", sorter.getName());

            for (long time : sorter.getTimes()) {
                System.out.printf("%12.4f", time * 1e-6);
            }
            System.out.println();
        }
    }
}
