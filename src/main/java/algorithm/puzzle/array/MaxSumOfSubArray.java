package algorithm.puzzle.array;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaxSumOfSubArray {

    private Logger logger = LogManager.getLogger(MaxSumOfSubArray.class);

    public int findMaxSumOfSubArray(int[] inputArr, Algorithm algorithm) {
        int maxSum = Integer.MIN_VALUE;
        switch (algorithm) {
            case KADANES_ALGORITHM:
                maxSum = findMaxSumOfSubArrayKadanesAlgo(inputArr);
                break;
        }
        return maxSum;
    }

    /**
     * Max sum of a sub-array - using Kadane's Algorithm
     * @param inputArr
     * @return
     */
	public int findMaxSumOfSubArrayKadanesAlgo(int[] inputArr) {
		int maxSum = Integer.MIN_VALUE, maxSumLowerIndex = 0, maxSumUpperIndex = 0;
		int currSubArraySum = 0, currSubArrayLowerIndex = 0;

		for (int i = 0; i < inputArr.length; i++) {
            currSubArraySum = currSubArraySum + inputArr[i];
            if (maxSum < currSubArraySum) {
                maxSum = currSubArraySum;
                maxSumLowerIndex = currSubArrayLowerIndex;
                maxSumUpperIndex = i;
            }
		    if (currSubArraySum < 0) {
                currSubArraySum = 0;
                currSubArrayLowerIndex = i + 1;
            }
		}
        logger.info("Using Kadane's Algorithm: maxSum = "+maxSum+", maxSumLowerIndex = "+maxSumLowerIndex+", maxSumUpperIndex = "+maxSumUpperIndex);
		return maxSum;
	}

	enum Algorithm {
        KADANES_ALGORITHM
    }
}
