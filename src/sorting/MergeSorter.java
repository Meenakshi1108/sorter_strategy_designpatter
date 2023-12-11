package sorting;
import java.util.Arrays;
public class MergeSorter implements Sorter{
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted using MergeSort: " + Arrays.toString(array));
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = Arrays.copyOfRange(array, left, left + n1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, mid + 1 + n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j])
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];
        }

        while (i < n1)
            array[k++] = leftArray[i++];

        while (j < n2)
            array[k++] = rightArray[j++];
    }

    public String getName() {
        return "MergeSort";
    }
}
