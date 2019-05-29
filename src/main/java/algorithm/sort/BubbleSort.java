package algorithm.sort;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> {

    /**
     * Bubble quiz.sort:
     * -> It has time complexity O(N^2), space complexity O(1)
     * -> Is stable sorting algorithm - which means that equal value elements retain their position w.r.t. each other
     * @param arr
     * @return
     */
    public T[] bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
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
    public int[] sort (int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1])
                    swap(numbers, j, j + 1);
            }
        }
        return numbers;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]) {
        int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
        int[] sortedNumbers;
        BubbleSort bubbleSort = new BubbleSort();
        sortedNumbers = bubbleSort.sort(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));
    }
}
