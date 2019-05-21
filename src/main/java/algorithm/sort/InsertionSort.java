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
        boolean replacedFlag;
        for (int i = 0; i < arr.length; i++) {
            replacedFlag = false;
            T temp = arr[i];
            for (int j = i; j > 0; j--) {
                if (arr[j - 1].compareTo(temp) > 0) {
                    arr[j] = arr[j - 1];
                } else if (arr[j - 1].compareTo(temp) < 0) {
                    arr[j] = temp;
                    replacedFlag = true;
                    break;
                }
            }
            if (!replacedFlag) {
                arr[0] = temp;
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
        boolean replacedFlag;
        for (int i = 0; i < numbers.length; i++) {
            replacedFlag = false;
            int temp = numbers[i];
            for (int j = i; j > 0; j--) {
                if (numbers[j - 1] > temp) {
                    numbers[j] = numbers[j - 1];
                } else if (numbers[j - 1] < temp) {
                    numbers[j] = temp;
                    replacedFlag = true;
                    break;
                }
            }
            if (!replacedFlag) {
                numbers[0] = temp;
            }
        }
        return numbers;
    }

    public static void main(String args[]) {
        int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
        int[] sortedNumbers;
        InsertionSort insertionSort = new InsertionSort();
        sortedNumbers = insertionSort.sort(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));
    }
}
