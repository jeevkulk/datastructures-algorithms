package algorithm.puzzle.array;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthOfSubArrayWithEqualZeroesOnes {

    /**
     * Copied
     * @param array
     */
    static void maxSubarray(int[] array) {
        Map<Integer, Integer> hash = new HashMap<>();
        int len = 0, end = -1, sum = 0;
        hash.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                sum += -1;
            else
                sum += 1;
            if ((hash.containsKey(sum)) && (len < i - hash.get(sum))) {
                len = i - hash.get(sum);
                end = i;
            } else {
                hash.put(sum, i);
            }
        }
        if (end != -1)
            System.out.println("Starting index: " + (end - len + 1) + " Ending index: " + end + " Length: " + len);
        else
            System.out.println("No such sub-array exists");
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 1, 0, 1, 0, 0};
        maxSubarray(array);
    }
}
