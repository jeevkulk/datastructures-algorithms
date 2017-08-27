package algorithm.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LargestRectangleInHistogramTest {

    private LargestRectangleInHistogram largestRectangleInHistogram;

    @Before
    public void setup() {
        largestRectangleInHistogram = new LargestRectangleInHistogram();
    }

    @Test
    public void testLargestArea() {
        int[] inputArr = new int[]{1, 2, 3, 4, 5};
        Assert.assertEquals(9, largestRectangleInHistogram.largestRectangle(inputArr));
    }
}
