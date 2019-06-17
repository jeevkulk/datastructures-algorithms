package algorithm.puzzle.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a quick sort variant that takes an array ‘A’ of integers and a random pivot as inputs, and returns the
 * subarray that has all the elements greater than or equal to A[pivot].
 *
 * This code will take three inputs:
 * 1. Size of the array
 * 2. Elements inside the array as per the given size. Choose an integer array for convenience.
 * 3. Index of the pivot element you want to choose.
 *
 * Note that you have to implement in-place quick sort and not use any extra space or declare another array. Also,
 * the subarray to be returned can be in an unsorted order. This doesn't mean you can return the subarray elements
 * in any order of your choice. You have to implement the correct algorithm for quick sort in-place sorting for the
 * minimum required number of runs to get the output and once you do that, the order that you get will be the correct
 * one. Do all the modifications and swaps within the input array. Use the copyOfRange function of arrays to return
 * the required part (subarray) of the modified array.
 *
 * Sample Input:
 * 10
 * 10 20 47 86 15 35 37 76 56 25
 * 2
 * Output:
 * 47
 * 76
 * 56
 * 86
 */
public class SubArrayGreaterThanPivotUsingQuickSort {

    public static int[] getSubarrayGreaterThan(int[] arr, int pivotIndex) {
        int i = -1;
        int left = 0;
        int right = arr.length;
        int pivot = arr[pivotIndex];

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (pivotIndex < i + 1) {
            int temp = pivot;
            for (int k = pivotIndex; k < i + 1; k++) {
                arr[k] = arr[k + 1];
            }
            arr[i + 1] = temp;
        } else if (pivotIndex > i + 1) {
            int temp = pivot;
            for (int k = pivotIndex; k > i + 1; k--) {
                arr[k] = arr[k - 1];
            }
            arr[i + 1] = temp;
        }

        int[] subArrayGreaterThanPivot = new int[arr.length - (i + 1)];
        int l = 0;
        for (int m = i + 1; m < arr.length; m++) {
            subArrayGreaterThanPivot[l++] = arr[m];
        }
        return subArrayGreaterThanPivot;
    }

    public static int[] getSubarrayGreaterThanPivotByPivotSwap(int[] arr, int pivot) {
        if ((pivot >= arr.length) || (pivot < 0)) {
            return null;
        }
        int smallerIndex = -1, temp;
        temp = arr[arr.length - 1];
        arr[arr.length - 1] = arr[pivot];
        arr[pivot] = temp;
        pivot = arr.length - 1;
        for (int i = 0; i < (arr.length - 1); i++) {
            if (arr[i] < arr[pivot]) {
                smallerIndex++;
                temp = arr[i];
                arr[i] = arr[smallerIndex];
                arr[smallerIndex] = temp;
            }
        }
        temp = arr[arr.length - 1];
        arr[arr.length - 1] = arr[smallerIndex + 1];
        arr[smallerIndex + 1] = temp;
        return Arrays.copyOfRange(arr, smallerIndex + 1, arr.length);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] arr = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = scanner.nextInt();
        }
        int pivotIndex = scanner.nextInt();
        int[] subArrayGreaterThanPivot = getSubarrayGreaterThan(arr, pivotIndex);
        for (int i = 0; i < subArrayGreaterThanPivot.length; i++) {
            System.out.println(subArrayGreaterThanPivot[i]);
        }
    }
}
