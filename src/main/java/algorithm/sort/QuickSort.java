package algorithm.sort;

public class QuickSort<T extends Comparable<T>> {

    /**
     * Quick sort: Has time complexity O(NLogN), space complexity O(1)
     * @param arr
     * @return
     */
    public T[] quickSort(T[] arr) {
        int start = 0;
        int end = arr.length - 1;
        quickSort(arr, start, end);
        return arr;
    }

    private T[] quickSort(T[] arr, int start, int end) {
        int mid = start + (end - start) / 2;
        int i = start;
        int j = end;
        T pivot = arr[mid];

        while (i <= j) {
            while (arr[i].compareTo(pivot) < 0)
                i++;
            while (arr[j].compareTo(pivot) > 0)
                j--;
            if (i <= j) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (start < j)
            quickSort(arr, start, j);
        if (end > i)
            quickSort(arr, i, end);
        return arr;
    }
}
