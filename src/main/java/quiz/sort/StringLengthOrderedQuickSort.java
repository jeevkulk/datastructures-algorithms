package quiz.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Statement:
 * Write a program in Java that takes an array of strings as input and returns the sorted array. Use the quick
 * sort algorithm for the program. Assume that the sorting needs to be done based on the size of each string.
 * So, a string with fewer characters should come before another string with more number of characters. Also,
 * in case of strings having the same size, it is NOT to be sorted in alphabetical order. As quick sort is not
 * a stable sorting algorithm, the order of the input strings passed also need not be maintained in that case.
 * Just implement the quick sort algorithm correctly based on size of strings to get the desired output. The code
 * will take the size of the array and its elements as inputs.
 *
 * Sample Input:
 * 8
 * Christene
 * Tomas
 * Zoro
 * Ki
 * Irmgard
 * Quiana
 * Neo
 * Kenyatta
 *
 * Output:
 * Ki
 * Neo
 * Zoro
 * Tomas
 * Quiana
 * Irmgard
 * Kenyatta
 * Christene
 */
public class StringLengthOrderedQuickSort {

    public void quickSort(String[] array, int left, int right) {
        if (left < right) {
            int position = partition(array, left, right);
            quickSort(array, left, position - 1);
            quickSort(array, position + 1, right);
        }
    }

    private int partition(String[] array, int left, int right) {
        int pivotIndex = right;
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j].length() <= array[pivotIndex].length()) {
                i++;
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        String temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;
        return (i + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input number of strings to be sorted length wise: ");
        int strArrLen = scanner.nextInt();
        System.out.println("Please input "+strArrLen+" strings that are to be sorted length wise.");
        String[] strArr = new String[strArrLen];
        int i = 0;
        while (i < strArrLen) {
            strArr[i++] = scanner.next();
        }
        StringLengthOrderedQuickSort quickSort = new StringLengthOrderedQuickSort();
        quickSort.quickSort(strArr, 0, strArr.length - 1);
        System.out.println(Arrays.toString(strArr));
    }
}
