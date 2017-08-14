package algorithm.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaxSumOfSubArrayTest {

    private MaxSumOfSubArray maxSumOfSubArray;

    @Before
    public void setup() {
        maxSumOfSubArray = new MaxSumOfSubArray();
    }

    @Test
    public void testMaxSumOfSubArray() {
        int[] inputArr = new int[]{-1, 2, 3, -4, 9, 2, -1, 10};
        int sum = maxSumOfSubArray.findMaxSumOfSubArray(inputArr);
        Assert.assertEquals(21, sum);

        inputArr = new int[]{0, 10, -50, 25, -10, 35, 20, -60};
        sum = maxSumOfSubArray.findMaxSumOfSubArray(inputArr);
        Assert.assertEquals(70, sum);

        inputArr = new int[]{0, -110, -50, 25, -10, 10, 20, -60};
        sum = maxSumOfSubArray.findMaxSumOfSubArray(inputArr);
        Assert.assertEquals(45, sum);
    }
}
