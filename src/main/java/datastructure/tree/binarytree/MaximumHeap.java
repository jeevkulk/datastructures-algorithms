package datastructure.tree.binarytree;

import java.lang.reflect.Array;

public class MaximumHeap<T extends Comparable<T>> extends Heap<T> {

    public MaximumHeap() {
        this(DEFAULT_TYPE, DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MaximumHeap(Class<?> type) {
        this(type, DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public MaximumHeap(Class<?> type, int initialCapacity, float loadFactor) {
        objectArr = (T[]) Array.newInstance(type, initialCapacity);
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;
    }

    @Override
    protected void heapifyUp(int index1) {
        int index2 = 0;
        if (index1 < 0 || index1 > currentSize)
            throw new IllegalStateException();

        if (hasParent(index1) && getParent(index1).compareTo(objectArr[index1]) < 0) {
            index2 = getParentIndex(index1);
            swap(index1, index2);
            heapifyUp(index2);
        }
    }

    @Override
    protected void heapifyDown(int index1) {
        int index2 = 0;
        if (index1 < 0 || index1 > currentSize)
            throw new IllegalStateException();

        if (hasLeftChild(index1) && hasParent(index1)) {
            if (getLeftChild(index1).compareTo(getRightChild(index1)) < 0 && getLeftChild(index1).compareTo(objectArr[index1]) > 0) {
                index2 = getLeftChildIndex(index1);
            } else if (getLeftChild(index1).compareTo(getRightChild(index1)) > 0 && getRightChild(index1).compareTo(objectArr[index1]) > 0) {
                index2 = getRightChildIndex(index1);
            }
        } else if (!hasLeftChild(index1) && getRightChild(index1).compareTo(objectArr[index1]) > 0) {
            index2 = getRightChildIndex(index1);
        } else if (!hasRightChild(index1) && getLeftChild(index1).compareTo(objectArr[index1]) > 0) {
            index2 = getLeftChildIndex(index1);
        }
        if (index2 > 0) {
            swap(index1, index2);
            heapifyDown(index2);
        }
    }
}
