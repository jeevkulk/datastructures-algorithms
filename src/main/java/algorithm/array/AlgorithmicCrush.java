package algorithm.array;

import java.util.Scanner;

public class AlgorithmicCrush {

    /**
     * AlgorithmicCrush:
     *
     * You are given a list of size n, initialized with zeroes. You have to perform m operations
     * on the list and output the maximum of final values of all the n elements in the list.
     * For every operation, you are given three integers a, b and k and you have to add value k
     * to all the elements ranging from index a to b (both inclusive).
     *
     * Input Format
     * First line will contain two integers n and m separated by a single space.
     * Next m lines will contain three integers a, b and k separated by a single space.
     * Numbers in list are numbered from 1 to n.
     *
     * Sample Input
     * 5 3
     * 1 2 100
     * 2 5 100
     * 3 4 100
     *
     * Sample Output
     * 200
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int a0 = 0; a0 < m; a0++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();

            arr[a-1] += k;
            if (b < n) {
                arr[b] -= k;
            }
        }
        in.close();

        long max = 0;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (max < sum)
                max = sum;
        }
        System.out.print(max);
    }
}
