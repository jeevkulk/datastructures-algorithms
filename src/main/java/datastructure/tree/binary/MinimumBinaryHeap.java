package datastructure.tree.binary;

import java.lang.reflect.Array;

public class MinimumBinaryHeap<T extends Comparable<T>> extends BinaryHeap<T> {


    public MinimumBinaryHeap() {
        this(DEFAULT_TYPE, DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MinimumBinaryHeap(Class<?> type) {
        this(type, DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public MinimumBinaryHeap(Class<?> type, int initialCapacity, float loadFactor) {
        objectArr = (T[]) Array.newInstance(type, initialCapacity);
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;
    }

    public void modify(T objectToModify, T newObject) {
        if (objectToModify == null || newObject == null) {
            throw new IllegalStateException();
        }
        int index = getObjectIndex(objectToModify);
        T oldValue = objectArr[index];
        objectArr[index] = newObject;
        if (oldValue.compareTo(newObject) < 0)
            heapifyDown(index);
        else
            heapifyUp(index);
    }

    private int getObjectIndex(T object) {
        int index = 0;
        boolean objectFound = false;
        for (int i = 0; i < objectArr.length; i++) {
            if (objectArr[i] != null && object.equals(objectArr[i])) {
                index = i;
                objectFound = true;
                break;
            }
        }
        if (!objectFound) {
            throw new IllegalArgumentException();
        }
        return index;
    }

    @Override
    protected void heapifyUp(int index1) {
        int index2 = 0;
        if (index1 < 0 || index1 > currentSize)
            throw new IllegalStateException();

        if (hasParent(index1) && getParent(index1).compareTo(objectArr[index1]) > 0) {
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

        if (hasLeftChild(index1) && hasRightChild(index1)) {
            if (getLeftChild(index1).compareTo(getRightChild(index1)) < 0 && getLeftChild(index1).compareTo(objectArr[index1]) < 0) {
                index2 = getLeftChildIndex(index1);
            } else if (getLeftChild(index1).compareTo(getRightChild(index1)) > 0 && getRightChild(index1).compareTo(objectArr[index1]) < 0) {
                index2 = getRightChildIndex(index1);
            }
        } else if (!hasLeftChild(index1) && hasRightChild(index1) && getRightChild(index1).compareTo(objectArr[index1]) < 0) {
            index2 = getRightChildIndex(index1);
        } else if (!hasRightChild(index1) && hasLeftChild(index1) && getLeftChild(index1).compareTo(objectArr[index1]) < 0) {
            index2 = getLeftChildIndex(index1);
        }
        if (index2 > 0) {
            swap(index1, index2);
            heapifyDown(index2);
        }
    }
}
