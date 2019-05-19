package algorithm.sort;

public class InsertionSort<T extends Comparable<T>> {

    /**
     * Insertion sort: Has time complexity O(N^2), space complexity O(1)
     * @param arr
     * @return
     */
    public T[] insertionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].compareTo(arr[j]) < 0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
