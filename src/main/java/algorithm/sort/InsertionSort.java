package algorithm.sort;

import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>> {

    /**
     * Insertion sort:
     * -> Has time complexity O(N^2), space complexity O(1).
     * -> It is stable sorting algorithm.
     * @param arr
     * @return
     */
    public T[] insertionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1].compareTo(arr[j]) < 0) {
                    T temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * Implementation for integers
     * @param numbers
     * @return
     */
    public int[] sort(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numbers[j - 1] > numbers[j]) {
                    swap(numbers, j - 1, j);
                }
            }
        }
        return numbers;
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String args[]) {
        int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
        int[] sortedNumbers;
        InsertionSort insertionSort = new InsertionSort();
        sortedNumbers = insertionSort.sort(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));
    }
}
