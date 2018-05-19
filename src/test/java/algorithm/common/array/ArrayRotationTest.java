package algorithm.common.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArrayRotationTest {

    private ArrayRotation arrayRotation;

    @Before
    public void setup() {
        arrayRotation = new ArrayRotation();
    }

    @Test
    public void testArrayRotation() {
        int[] inputArr = new int[]{1, 2, 3, 4, 5};
        int[] rotatedArr = arrayRotation.rotateArray(inputArr, 1);
        Assert.assertArrayEquals(new int[]{5, 1, 2, 3, 4}, rotatedArr);

        inputArr = new int[]{1, 2, 3, 4, 5};
        rotatedArr = arrayRotation.rotateArray(inputArr, 2);
        Assert.assertArrayEquals(new int[]{4, 5, 1, 2, 3}, rotatedArr);

        inputArr = new int[]{1, 2, 3, 4, 5};
        rotatedArr = arrayRotation.rotateArray(inputArr, 3);
        Assert.assertArrayEquals(new int[]{3, 4, 5, 1, 2}, rotatedArr);

        inputArr = new int[]{1, 2, 3, 4, 5};
        rotatedArr = arrayRotation.rotateArray(inputArr, 4);
        Assert.assertArrayEquals(new int[]{2, 3, 4, 5, 1}, rotatedArr);

        inputArr = new int[]{1, 2, 3, 4, 5};
        rotatedArr = arrayRotation.rotateArray(inputArr, 5);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, rotatedArr);
    }
}
