package algorithm.sort;

public interface ISort<T extends Comparable<T>> {

    public T[] sort(T[] arr, Sort.SortMethod sortMethod);

}
