import sorting.*;
import java.util.Arrays;
import java.util.Random;

public class SortingApp {
    public static void main(String[] args) {
        int[] data = generateLargeTestData(1000); // Adjust the size as needed

        SortingContext sortingContext = new SortingContext();

        sortingContext.setSorter(new BubbleSorter());
        measureAndPrintTime(sortingContext, Arrays.copyOf(data, data.length));

        sortingContext.setSorter(new QuickSorter());
        measureAndPrintTime(sortingContext, Arrays.copyOf(data, data.length));

        sortingContext.setSorter(new MergeSorter());
        measureAndPrintTime(sortingContext, Arrays.copyOf(data, data.length));

        sortingContext.setSorter(new HeapSorter());
        measureAndPrintTime(sortingContext, Arrays.copyOf(data, data.length));
    }

    private static void measureAndPrintTime(SortingContext sortingContext, int[] data) {
        long executionTime = SortingTimer.measureExecutionTime(sortingContext.getSorter(), data);
        System.out.println(sortingContext.getSorterInfo() + " - Execution Time: " + executionTime + " milliseconds");
    }

    private static int[] generateLargeTestData(int size) {
        int[] data = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(1000); // Adjust the range of random values as needed
        }

        return data;
    }
}
