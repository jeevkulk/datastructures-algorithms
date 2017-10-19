package datastructure.tree.binarytree;

public class MinimumHeap<T extends Comparable<T>> extends Heap<T> {


    public MinimumHeap() {
        this(DEFAULT_INITIAL_SIZE, DEFAULT_LOAD_FACTOR);
    }

    public MinimumHeap(int initialSize, float loadFactor) {
        objectArr = new Object[initialSize];
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;
    }

    @Override
    protected void validateHeap(T element, int position) {
        //TODO
    }
}
