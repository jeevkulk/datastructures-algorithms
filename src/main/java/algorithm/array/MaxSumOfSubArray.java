package algorithm.array;

public class MaxSumOfSubArray {

	public int findMaxSumOfSubArray(int[] inputArr) {
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
		return maxSum;
	}
}
