package quiz.sort;

import java.util.Scanner;

/**
 * Write a bubble sort program that prints the number of swaps made after M number of iterations. In this case, ‘M’ should be an input value. For example, if M = 0, the bubble sort program will perform 0 comparisons in 0 iterations. In bubble sort, an iteration is defined as the total number of times the outer loop runs. Assume that: 1) M <= the array size and 2) the program sorts in descending order. The code should ask the user to input the values for M, the array size, and finally the elements of the array. So, there will be three types of inputs:
 * Input 1: The value of M (iterationCount)
 * Input 2: The size of the array
 * Input 3: The elements inside the array
 *
 * Sample Input:
 * 2
 * 4
 * 1
 * 2
 * 3
 * 4
 *
 * Sample Output:
 * 5
 */
public class BubbleSortIterationCount {

    private static int totalBubbleSortSwaps(int[] array, int iterationCount) {
        int arraySize = array.length;
        int totalSwaps = 0;

        for (int i = 0; i < iterationCount; i++) {
            for (int j = 0; j < arraySize - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    totalSwaps++;
                }
            }
        }
        return totalSwaps;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int iterationCount = scanner.nextInt();
        int arraySize = scanner.nextInt();
        int[] arr = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = scanner.nextInt();
        }
        int swapCount = totalBubbleSortSwaps(arr, iterationCount);
        System.out.println(swapCount);
    }
}
