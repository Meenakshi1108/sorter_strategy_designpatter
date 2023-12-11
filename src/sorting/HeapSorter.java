package sorting;

public class HeapSorter implements Sorter{
    public void sort(int[] array) {
        int n = array.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (max element) with the last element
            swap(array, 0, i);

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // Compare with left child
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // Compare with right child
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // If the largest is not the root, swap and recursively heapify the affected subtree
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public String getName() {
        return "Heap Sort";
    }
}
