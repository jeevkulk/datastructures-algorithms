package algorithm.puzzle.array;

public class MinNumberOfJumps {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 0, 1, 4};
        MinNumberOfJumps minNumberOfJumps = new MinNumberOfJumps();
        System.out.println(minNumberOfJumps.findMinNumberOfJumps(arr, 0));
    }

    private int findMinNumberOfJumps(int[] arr, int startPos) {
        int minNumberOfJumps = Integer.MAX_VALUE;
        int numberOfJumps = 0;
        if (arr[startPos] == 0) {
            return -1;
        } else if (startPos >= arr.length - 1) {
            return 1;
        }
        for (int i = startPos; i < startPos + arr[startPos]; i++) {
            numberOfJumps = findMinNumberOfJumps(arr, i + arr[i]) + 1;
        }
        if (numberOfJumps < minNumberOfJumps) {
            minNumberOfJumps = numberOfJumps;
        }
        return minNumberOfJumps;
    }
}
