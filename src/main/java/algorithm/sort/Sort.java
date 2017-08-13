package algorithm.sort;

public class Sort<T extends Comparable<T>> implements ISort<T> {

    @Override
    public T[] sort(T[] arr, SortMethod sortMethod) {
        switch(sortMethod) {
            case BUBBLE_SORT:
                arr = new BubbleSort<T>().bubbleSort(arr);
            case SELECTION_SORT:
                arr = new SelectionSort<T>().selectionSort(arr);
            case INSERTION_SORT:
                arr = new InsertionSort<T>().insertionSort(arr);
            case MERGE_SORT:
                arr = new MergeSort<T>().mergeSort(arr);
        }
        return arr;
    }

    enum SortMethod {
        BUBBLE_SORT,
        SELECTION_SORT,
        INSERTION_SORT,
        MERGE_SORT
    }
}
