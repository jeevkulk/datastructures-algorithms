package algorithm.common.array;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaxSumOfSubArray {

    Logger logger = LogManager.getLogger(MaxSumOfSubArray.class);

    public int findMaxSumOfSubArray(int[] inputArr, Algorithm algorithm) {
        int maxSum = Integer.MIN_VALUE;
        switch (algorithm) {
            case MY_ALGORITHM:
                maxSum = findMaxSumOfSubArrayMyAlgo(inputArr);
                break;
            case KADANES_ALGORITHM:
                maxSum = findMaxSumOfSubArrayKadanesAlgo(inputArr);
                break;
        }
        return maxSum;

    }

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
                currSubArrayLowerIndex = i+1;
            }
		}
        logger.info("Using Kadane's Algorithm: maxSum = "+maxSum+", maxSumLowerIndex = "+maxSumLowerIndex+", maxSumUpperIndex = "+maxSumUpperIndex);
		return maxSum;
	}

	public int findMaxSumOfSubArrayMyAlgo(int[] inputArr) {
		int maxSum = 0, maxSumLowerIndex = 0, maxSumUpperIndex = 0;
		int currSubArraySum = 0, currSumLowerIndex = 0, currSumUpperIndex = 0;

		for (int i = 0; i < inputArr.length; i++) {
            currSubArraySum = currSubArraySum + inputArr[i];
            currSumUpperIndex = i;
            if (i == 0) {
                maxSum = currSubArraySum;
                maxSumUpperIndex = i;
            }
		    if (inputArr[i] > 0) {
                if (currSubArraySum > maxSum) {
                    maxSum = currSubArraySum;
                    maxSumUpperIndex = i;
                }
                int lowerTempSum = 0;
                for (int j = currSumLowerIndex; j < i; j++) {
                    lowerTempSum = lowerTempSum + inputArr[j];
                    if (currSubArraySum < currSubArraySum - lowerTempSum) {
                        currSubArraySum = currSubArraySum - lowerTempSum;
                        currSumLowerIndex = j + 1;
                        lowerTempSum = 0;
                        if (currSubArraySum > maxSum) {
                            maxSum = currSubArraySum;
                            maxSumLowerIndex = j + 1;
                        }
                    }
                }
            }
		}
        logger.info("Using my algorithm: maxSum = "+maxSum+", maxSumLowerIndex = "+maxSumLowerIndex+", maxSumUpperIndex = "+maxSumUpperIndex);
		return maxSum;
	}

	enum Algorithm {
        MY_ALGORITHM,
        KADANES_ALGORITHM
    }
}
