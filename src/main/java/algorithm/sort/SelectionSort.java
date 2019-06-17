package algorithm.sort;

import java.util.Arrays;

public class SelectionSort<T extends Comparable<T>> {

    /**
     * Selection algorithm.assignment.sort:
     * -> Has time complexity O(N^2) and space complexity O(1)
     * -> It is stable sorting algorithm
     * -> Used when less number of swaps are preferred
     * @param arr
     * @return
     */
    public T[] selectionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
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
     * Selection algorithm.assignment.sort applied for integers
     * @param numbers
     * @return
     */
    public int[] sort (int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[minPos] > numbers[j]) {
                    minPos = j;
                }
            }
            swap(numbers, i, minPos);
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
        SelectionSort selectionSort = new SelectionSort();
        sortedNumbers = selectionSort.sort(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));
    }
}
