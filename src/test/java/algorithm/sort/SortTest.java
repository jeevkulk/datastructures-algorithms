package algorithm.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SortTest {

    private ISort<Integer> sort = null;

    @Before
    public void setup() {
        sort = new Sort<>();
    }

    @Test
    public void testBubbleSort() {
        Integer[] arr = new Integer[]{10, 14, 91, 18, 72, 551, 82749, 23, 55, 26};
        Integer[] sortedArr = sort.sort(arr, Sort.SortMethod.BUBBLE_SORT);
        Assert.assertArrayEquals(new Integer[]{10, 14, 18, 23, 26, 55, 72, 91, 551, 82749}, sortedArr);
    }

    @Test
    public void testInsertionSort() {
        Integer[] arr = new Integer[]{10, 14, 91, 18, 72, 551, 82749, 23, 55, 26};
        Integer[] sortedArr = sort.sort(arr, Sort.SortMethod.INSERTION_SORT);
        Assert.assertArrayEquals(new Integer[]{10, 14, 18, 23, 26, 55, 72, 91, 551, 82749}, sortedArr);
    }

    @Test
    public void testSelectionSort() {
        Integer[] arr = new Integer[]{10, 14, 91, 18, 72, 551, 82749, 23, 55, 26};
        Integer[] sortedArr = sort.sort(arr, Sort.SortMethod.SELECTION_SORT);
        Assert.assertArrayEquals(new Integer[]{10, 14, 18, 23, 26, 55, 72, 91, 551, 82749}, sortedArr);
    }

    @Test
    public void testMergeSort() {
        Integer[] arr = new Integer[]{10, 14, 91, 18, 72, 551, 82749, 23, 55, 26};
        Integer[] sortedArr = sort.sort(arr, Sort.SortMethod.MERGE_SORT);
        Assert.assertArrayEquals(new Integer[]{10, 14, 18, 23, 26, 55, 72, 91, 551, 82749}, sortedArr);
    }

    @Test
    public void testQuickSort() {
        Integer[] arr = new Integer[]{10, 14, 91, 18, 72, 551, 82749, 23, 55, 26};
        Integer[] sortedArr = sort.sort(arr, Sort.SortMethod.QUICK_SORT);
        Assert.assertArrayEquals(new Integer[]{10, 14, 18, 23, 26, 55, 72, 91, 551, 82749}, sortedArr);
    }
}
