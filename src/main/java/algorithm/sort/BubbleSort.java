package algorithm.sort;

public class BubbleSort<T extends Comparable<T>> {

    /**
     * Bubble sort: Has time complexity O(N^2), space complexity O(1)
     * @param arr
     * @return
     */
    public T[] bubbleSort(T[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
