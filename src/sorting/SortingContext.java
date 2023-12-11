// SortingContext.java
package sorting;

public class SortingContext {
    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void performSort(int[] array) {
        sorter.sort(array);
    }

    public String getSorterInfo() {
        return "Sorting algorithm: " + sorter.getName();
    }

    public Sorter getSorter() {
        return sorter;
    }
}
