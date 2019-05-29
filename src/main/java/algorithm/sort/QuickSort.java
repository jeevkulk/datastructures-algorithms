package algorithm.sort;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> {

    /**
     * Quick quiz.sort:
     * -> Has time complexity O(NLogN), space complexity O(n/2)
     * -> It is unstable
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


    /**
     * Quick quiz.sort implementation for integer arrays
     * @param arr
     * @return
     */
    public int[] sort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        quickSort(arr, start, end);
        return arr;
    }

    private int[] quickSort(int[] arr, int start, int end) {
        int mid = start + (end - start) / 2;
        int i = start;
        int j = end;
        int pivot = arr[mid];

        while (i <= j) {
            while (arr[i] > pivot)
                i++;
            while (arr[j] < pivot)
                j--;
            if (i <= j) {
                int temp = arr[i];
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

    public static void main(String args[]) {
        int[] randomNumbers = {2,4,6,8,10,12,14,16,18,20};
        int[] sortedNumbers;
        QuickSort quickSort = new QuickSort();
        sortedNumbers = quickSort.sort(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));
    }
}
