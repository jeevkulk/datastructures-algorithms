package datastructure.tree.binarytree;

public class MaximumHeap<T extends Comparable<T>> extends Heap<T> {


    public MaximumHeap() {
        this(DEFAULT_INITIAL_SIZE, DEFAULT_LOAD_FACTOR);
    }

    public MaximumHeap(int initialSize, float loadFactor) {
        objectArr = new Object[initialSize];
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;
    }

    @Override
    protected void validateHeap(T element, int position) {
        if (element == null) {
            //TODO
        }
        //TODO
    }
}
