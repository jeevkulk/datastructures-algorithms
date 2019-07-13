package algorithm.puzzle.array;

import java.util.Scanner;

public class LargestRectangleInHistogram {

    public long largestRectangle(int[] arr) {
        long area = findArea(arr, 0, arr.length - 1);
        return area;
    }

    private long findArea(int[] arr, int startPos, int endPos) {
        long area = 0, area1 = 0, area2 = 0;
        int positionOfLeastValue = startPos;
        int leastValue = arr[startPos];
        for (int i = startPos; i < endPos; i++) {
            if (arr[i] < leastValue) {
                positionOfLeastValue = i;
                leastValue = arr[i];
            }
        }
        area = leastValue * (endPos - startPos + 1);
        if (positionOfLeastValue > startPos) {
            area1 = findArea(arr, startPos, positionOfLeastValue - 1);
        }
        if (positionOfLeastValue < endPos) {
            area2 = findArea(arr, positionOfLeastValue + 1, endPos);
        }
        return Math.max(area, Math.max(area1, area2));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for(int h_i = 0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        long result = largestRectangleInHistogram.largestRectangle(h);
        in.close();
    }
}
