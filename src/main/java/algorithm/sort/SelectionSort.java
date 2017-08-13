package algorithm.sort;

public class SelectionSort<T extends Comparable<T>> {

    /**
     * Selection sort: Has time complexity O(N^2), space complexity O(1)
     * @param arr
     * @return
     */
    public T[] selectionSort(T[] arr) {
        for (int i=0; i<arr.length; i++) {
            int minPos = i;
            for (int j=i; j<arr.length; j++) {
                if (arr[minPos].compareTo(arr[j]) > 0) {
                    minPos = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
        return arr;
    }
}
