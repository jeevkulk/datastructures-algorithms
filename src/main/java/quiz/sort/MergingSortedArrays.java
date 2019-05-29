package quiz.sort;

import java.util.Scanner;

/**
 * Problem statement:
 * Write a function that merges two sorted arrays in descending order, where the number of the elements is between 1 and 100,000 (0 < array size <= 100000).
 * This code will take the following inputs in the sequence mentioned here:
 * -> The size of the first sorted array.
 * -> The size of the second sorted array.
 * -> Elements of the first sorted array.
 * -> Elements of the second sorted array.
 *
 * Sample Input:
 * 3
 * 4
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * Output:
 * 7
 * 6
 * 5
 * 4
 * 3
 * 2
 * 1
 */
public class MergingSortedArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array1Size = scanner.nextInt();
        int array2Size = scanner.nextInt();
        int[] sortedArray1 = getArrayInput(array1Size, scanner);
        int[] sortedArray2 = getArrayInput(array2Size, scanner);
        int[] descendingMerge = mergeBothInDescendingOrder(sortedArray1, sortedArray2);
        for (int i = 0; i < descendingMerge.length; i++) {
            System.out.println(descendingMerge[i]);
        }
    }

    private static int[] getArrayInput(int arraySize, Scanner scanner) {
        int i = 0;
        int[] intArray = new int[arraySize];
        while (i < arraySize) {
            intArray[i] = scanner.nextInt();
            i++;
        }
        return intArray;
    }

    private static int[] mergeBothInDescendingOrder(int[] sortedArray1, int[] sortedArray2) {
        int i = 0;
        int j = sortedArray1.length - 1;
        int k = sortedArray2.length - 1;
        int mergedArrayLength = sortedArray1.length + sortedArray2.length;
        int[] mergedArray = new int[mergedArrayLength];
        while (i < mergedArrayLength) {
            while (j >= 0 && k >= 0) {
                if (sortedArray1[j] > sortedArray2[k]) {
                    mergedArray[i] = sortedArray1[j];
                    j--;
                } else if (sortedArray2[k] > sortedArray1[j]) {
                    mergedArray[i] = sortedArray2[k];
                    k--;
                }
                i++;
            }
            while (j >= 0) {
                mergedArray[i] = sortedArray1[j];
                i++;
                j--;
            }
            while (k >= 0) {
                mergedArray[i] = sortedArray2[k];
                i++;
                k--;
            }
        }
        return mergedArray;
    }
}
