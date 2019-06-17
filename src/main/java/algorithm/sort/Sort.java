package algorithm.sort;

public class Sort<T extends Comparable<T>> implements ISort<T> {

    @Override
    public T[] sort(T[] arr, SortMethod sortMethod) {
        switch(sortMethod) {
            case BUBBLE_SORT:
                arr = new BubbleSort<T>().bubbleSort(arr);
                break;
            case INSERTION_SORT:
                arr = new InsertionSort<T>().insertionSort(arr);
                break;
            case SELECTION_SORT:
                arr = new SelectionSort<T>().selectionSort(arr);
                break;
            case HEAP_SORT:
                //TODO: Need to change to heap algorithm.assignment.sort
                arr = new SelectionSort<T>().selectionSort(arr);
                break;
            case MERGE_SORT:
                arr = new MergeSort<T>().mergeSort(arr);
                break;
            case QUICK_SORT:
                arr = new QuickSort<T>().quickSort(arr);
                break;
            default:
                System.out.println("Invalid option!");
        }
        return arr;
    }

    enum SortMethod {
        BUBBLE_SORT,
        INSERTION_SORT,
        SELECTION_SORT,
        HEAP_SORT,
        MERGE_SORT,
        QUICK_SORT
    }
}
