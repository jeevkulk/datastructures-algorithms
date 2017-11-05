package datastructure.tree.binary;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MinimumBinaryHeapTest {

    @Test
    public void testIntegerAdd() {
        MinimumBinaryHeap<Integer> minimumHeap = new MinimumBinaryHeap<>();
        minimumHeap.add(5);
        minimumHeap.add(3);
        minimumHeap.add(7);
        minimumHeap.add(4);
        minimumHeap.add(6);
        minimumHeap.add(2);
        minimumHeap.add(8);
        minimumHeap.add(1);
        minimumHeap.add(9);

        minimumHeap.printHeap();

        Assert.assertTrue(minimumHeap.contains(5));
        Assert.assertTrue(minimumHeap.contains(9));
        Assert.assertFalse(minimumHeap.contains(0));
        Assert.assertFalse(minimumHeap.contains(10));
    }

    @Test
    public void testStringInsert() {
        MinimumBinaryHeap<String> minimumHeap = new MinimumBinaryHeap<>(String.class);

        minimumHeap.add("IBBS");
        minimumHeap.add("OrbiOne");
        minimumHeap.add("LDS");
        minimumHeap.add("PayableFinancing");
        minimumHeap.add("Astellas");
        minimumHeap.add("JVE");
        minimumHeap.add("LEMAP");
        minimumHeap.add("LEBCT");
        minimumHeap.add("TradeUtil");
        minimumHeap.add("Compass");

        minimumHeap.printHeap();

        Assert.assertTrue(minimumHeap.contains("Compass"));
        Assert.assertTrue(minimumHeap.contains("JVE"));
        Assert.assertFalse(minimumHeap.contains("COLT"));
        Assert.assertFalse(minimumHeap.contains("GRID"));
    }
}
