package algorithm.sort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {

    /**
     * Merge quiz.sort: Has time complexity O(NLogN), space complexity O(1)
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

    /**
     * Merge quiz.sort implementation for integer arrays
     * @param numbers
     * @return
     */
    public int[] sort (int[] numbers) {
        int len = numbers.length;
        numbers = mergeSort(numbers, 0, len - 1);
        return numbers;
    }

    private int[] mergeSort(int[] numbers, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            numbers = mergeSort(numbers, start, mid);
            numbers = mergeSort(numbers, mid + 1, end);
            numbers = merge(numbers, start, mid, end);
        }
        return numbers;
    }

    private int[] merge(int[] numbers, int start, int mid, int end) {
        int l1 = mid - start + 1;
        int l2 = end - mid;
        int[] tempArr1 = new int[l1];
        int[] tempArr2 = new int[l2];

        for (int i = 0; i < l1; i++) {
            tempArr1[i] = numbers[start + i];
        }
        for (int i = 0; i < l2; i++) {
            tempArr2[i] = numbers[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;
        while (i < l1 && j < l2) {
            if (tempArr1[i] < tempArr2[j]) {
                numbers[k++] = tempArr1[i++];
            } else {
                numbers[k++] = tempArr2[j++];
            }
        }
        while (i < l1) {
            numbers[k++] = tempArr1[i++];
        }
        while (j < l2) {
            numbers[k++] = tempArr2[j++];
        }
        return numbers;
    }


    public static void main(String args[]) {
        int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
        int[] sortedNumbers;
        MergeSort mergeSort = new MergeSort();
        sortedNumbers = mergeSort.sort(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));
    }

}
