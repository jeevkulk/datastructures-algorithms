package algorithm.sort;

public class Sort<T extends Comparable<T>> implements ISort<T> {

    @Override
    public T[] sort(T[] arr, SortMethod sortMethod) {
        switch(sortMethod) {
            case BUBBLE_SORT:
                arr = bubbleSort(arr);
            case SELECTION_SORT:
                arr = selectionSort(arr);
            case INSERTION_SORT:
                arr = insertionSort(arr);
            case MERGE_SORT:
                arr = mergeSort(arr);
        }
        return arr;
    }

    /**
     * Bubble sort: Has time complexity O(N^2), space complexity O(1)
     * @param arr
     * @return
     */
    public T[] bubbleSort(T[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

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

    /**
     * Insertion sort: Has time complexity O(N^2), space complexity O(1)
     * @param arr
     * @return
     */
    public T[] insertionSort(T[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i].compareTo(arr[j]) < 0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * Merge sort: Has time complexity O(NLogN), space complexity O(1)
     * @param arr
     * @return
     */
    public T[] mergeSort(T[] arr) {
        //TBD
        return arr;
    }

    enum SortMethod {
        BUBBLE_SORT,
        SELECTION_SORT,
        INSERTION_SORT,
        MERGE_SORT
    }
}
