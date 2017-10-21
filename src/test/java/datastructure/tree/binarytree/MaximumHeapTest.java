package datastructure.tree.binarytree;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaximumHeapTest {

    @Test
    public void testIntegerAdd() {
        MaximumHeap<Integer> maximumHeap = new MaximumHeap<>();
        maximumHeap.add(5);
        maximumHeap.add(3);
        maximumHeap.add(7);
        maximumHeap.add(4);
        maximumHeap.add(6);
        maximumHeap.add(2);
        maximumHeap.add(8);
        maximumHeap.add(1);
        maximumHeap.add(9);

        maximumHeap.printHeap();

        Assert.assertTrue(maximumHeap.contains(5));
        Assert.assertTrue(maximumHeap.contains(9));
        Assert.assertFalse(maximumHeap.contains(0));
        Assert.assertFalse(maximumHeap.contains(10));
    }

    @Test
    public void testStringInsert() {
        MaximumHeap<String> maximumHeap = new MaximumHeap<>(String.class);

        maximumHeap.add("IBBS");
        maximumHeap.add("OrbiOne");
        maximumHeap.add("LDS");
        maximumHeap.add("PayableFinancing");
        maximumHeap.add("Astellas");
        maximumHeap.add("JVE");
        maximumHeap.add("LEMAP");
        maximumHeap.add("LEBCT");
        maximumHeap.add("TradeUtil");
        maximumHeap.add("Compass");

        maximumHeap.printHeap();

        Assert.assertTrue(maximumHeap.contains("Compass"));
        Assert.assertTrue(maximumHeap.contains("JVE"));
        Assert.assertFalse(maximumHeap.contains("COLT"));
        Assert.assertFalse(maximumHeap.contains("GRID"));
    }
}
