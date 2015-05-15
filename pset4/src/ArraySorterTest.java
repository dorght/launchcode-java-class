import java.util.Arrays;
import java.util.HashMap;

import static java.lang.System.nanoTime;

/**
 * Created by Sean on 5/15/15.
 */
public class ArraySorterTest {

    public void fillArray(int[] array) {
        for (int i = 0, n = array.length; i < n; i++) {
            array[i] = (int) (Math.random() * 32175);   // Integer.MAX_VALUE
        }
    }

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

 //    time the sorting of the array
    public long timeSort(ArraySorter arraySorter, int[] array) {
        long starttime = nanoTime();
        arraySorter.performSort(array);
        long endtime = nanoTime();
        arraySorter.performSort(array);

        return (endtime - starttime);
    }

    public static void main (String[] args) {
        ArraySorterTest arraySorterTest = new ArraySorterTest();
        ArraySorter arraySorter = new ArraySorter();


        // generate an array with random elements
        int[] random = new int[5000];
        arraySorterTest.fillArray(random);

        // generate an array with elements already sorted
        int[] ordered = new int[5000];
        arraySorterTest.fillArray(ordered);
        Arrays.sort(ordered);

        // generate an array with all elements in reverse sort order
        int[] reversed = new int[5000];
        arraySorterTest.fillArray(reversed);
        Arrays.sort(reversed);
        arraySorterTest.reverseArray(reversed);

        HashMap bubbletimes = new HashMap();
        arraySorter.setSorter(new BubbleSort());
        int[] testarray = Arrays.copyOf(random, random.length);
        long testtime = arraySorterTest.timeSort(arraySorter, testarray);
        bubbletimes.put("Random", testtime);

        arraySorter.setSorter(new InsertionSort());
        testarray = Arrays.copyOf(ordered, ordered.length);
        testtime = arraySorterTest.timeSort(arraySorter, testarray);
        bubbletimes.put("Ordered", testtime);

        arraySorter.setSorter(new JavaSort());
        testarray = Arrays.copyOf(reversed, reversed.length);
        testtime = arraySorterTest.timeSort(arraySorter, testarray);
        bubbletimes.put("Reversed", testtime);


//        Object[] methods = {new BubbleSort(), new InsertionSort(), new JavaSort(), new SelectionSort()};
//        int[][] testarrays = {random, ordered, reversed};
//        long[][] times = new long[methods.length][testarrays.length];
//
//        for (int i = 0, m = methods.length - 1; i < m; i++) {
//            // set sort method to be tested
//            arraySorter.setSorter((SortStrategy) methods[i]);
//
//            for (int j = 0, n = testarrays.length - 1; j < n; j++) {
//                // copy the original array so it is not altered and identical array reused on other methods
//                int[] testarray = Arrays.copyOf(testarrays[j], testarrays[j].length);
//
//                // time the sorting of the array
//                long starttime = nanoTime();
//                arraySorter.performSort(testarray);
//                long endtime = nanoTime();arraySorter.performSort(testarray);
//                times[i][j] = endtime - starttime;
//            }
//        }
//
//        // display sorting time results
//        String[] tests = {"Bubble Sort", "Insertion Sort", "Java's Sort", "Selection Sort"};
//        System.out.println("                 Random     Ordered     Reversed");
//        for (int i = 0, m = tests.length; i < m; i++) {
//            System.out.print(tests[i]);
//            for (int j = 0, n = methods.length; j < n; j++) {
//                System.out.print("     " + times[i][j]);
//            }
//            System.out.println();
//        }
//    }
}
