package algorithm.sort;

import java.util.Arrays;

public class HeapSort<T extends Comparable<T>> {

    /**
     * Heap quiz.sort:
     * -> Has time complexity O(N^2) and space complexity O(1)
     * -> It is stable sorting algorithm
     * -> Used when less number of swaps are preferred
     * @param arr
     * @return
     */
    private void heapify(int[] arr, int size, int rootIndex) {
        int minimumIndex = rootIndex;
        int leftNodeIndex = 2 * rootIndex + 1;
        int rightNodeIndex = 2 * rootIndex + 2;

        if (leftNodeIndex < size && arr[leftNodeIndex] > arr[minimumIndex])
            minimumIndex = leftNodeIndex;
        if (rightNodeIndex < size && arr[rightNodeIndex] > arr[minimumIndex])
            minimumIndex = rightNodeIndex;

        if (minimumIndex != rootIndex) {
            int temp = arr[minimumIndex];
            arr[minimumIndex] = arr[rootIndex];
            arr[rootIndex] = temp;
            heapify(arr, size, minimumIndex);
        }
    }

    public void sort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n-1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void main(String args[]) {
        int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(randomNumbers);
        System.out.println(Arrays.toString(randomNumbers));
    }
}
