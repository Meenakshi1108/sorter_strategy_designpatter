// SortingTimer.java
package sorting;

public class SortingTimer {
    public static long measureExecutionTime(Sorter sorter, int[] array) {
        long startTime = System.currentTimeMillis();
        sorter.sort(array);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
