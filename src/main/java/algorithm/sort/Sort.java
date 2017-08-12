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
        int len = arr.length;
        arr = mergeSort(arr, 0, len - 1);
        return arr;
    }

    private T[] mergeSort(T[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            arr = mergeSort(arr, start, mid);
            arr = mergeSort(arr, mid + 1, end);
            arr = merge(arr, start, mid, end);
        }
        return arr;
    }

    private T[] merge(T[] arr, int start, int mid, int end) {
        int l1 = mid - start + 1;
        int l2 = end - mid;

        // need to define an array of type T that extends Comparable
        T[] tempArr1 = (T[]) new Integer[l1];
        T[] tempArr2 = (T[]) new Integer[l2];

        for (int i=0; i<l1; i++) {
            tempArr1[i] = arr[start + i];
        }
        for (int i=0; i<l2; i++) {
            tempArr2[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;
        while (i < l1 && j < l2) {
            if (tempArr1[i].compareTo(tempArr2[j]) < 0) {
                arr[k++] = tempArr1[i++];
            } else {
                arr[k++] = tempArr2[j++];
            }
        }
        while (i < l1) {
            arr[k++] = tempArr1[i++];
        }
        while (j < l2) {
            arr[k++] = tempArr2[j++];
        }
        return arr;
    }

    enum SortMethod {
        BUBBLE_SORT,
        SELECTION_SORT,
        INSERTION_SORT,
        MERGE_SORT
    }
}
