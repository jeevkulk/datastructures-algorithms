package datastructure.tree.binary;

import datastructure.tree.Tree;

public abstract class BinaryHeap<T extends Comparable<T>> implements Tree<T> {

    protected T[] objectArr = null;

    protected final static Class<? extends Comparable<?>> DEFAULT_TYPE = Integer.class;

    protected final static int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    protected final static float DEFAULT_LOAD_FACTOR = 0.75f;

    protected int initialCapacity;

    protected float loadFactor;

    protected int currentSize = 0;

    public int size() {
        return currentSize;
    }

    @Override
    public void add(T element) {
        if (currentSize >= loadFactor * objectArr.length) {
            doubleArr();
        }
        objectArr[currentSize++] = element;
        heapifyUp(currentSize - 1);
    }

    @Override
    public boolean contains(T t) {
        for (int i = 0; i < currentSize; i++) {
            if (objectArr[i] == t)
                return true;
        }
        return false;
    }

    @Override
    public T peek() {
        if (currentSize == 0)
            throw new IllegalStateException();
        return objectArr[0];
    }

    @Override
    public T poll() {
        if (currentSize == 0)
            throw new IllegalStateException();
        T t = objectArr[0];
        objectArr[0] = objectArr[currentSize-1];
        objectArr[currentSize-1] = null;
        currentSize--;
        heapifyDown(0);
        return t;
    }

    public void delete(T t) {
        for (int i = 0; i < currentSize; i++) {
            if (objectArr[i] == t) {
                objectArr[i] = null;
                currentSize--;
                heapifyDown(i);
            }
        }
    }

    /**
     * Helper methods to swap two objects
     * @param index1
     * @param index2
     */
    protected void swap(int index1, int index2) {
        T temp = objectArr[index1];
        objectArr[index1] = objectArr[index2];
        objectArr[index2] = temp;
    }

    /**
     * Method to double the size of the array
     */
    private void doubleArr() {
        T[] newObjectArr = (T[]) new Object[initialCapacity << 1];
        for (int i = 0; i < currentSize; i++) {
            newObjectArr[i] = objectArr[i];
        }
        objectArr = newObjectArr;
    }

    /**
     * Abstract method to be implemented by MinimumBinaryHeap and MaximumBinaryHeap
     * @param index
     */
    protected abstract void heapifyUp(int index);

    /**
     * Abstract method to be implemented by MinimumBinaryHeap and MaximumBinaryHeap
     * @param index
     */
    protected abstract void heapifyDown(int index);

    /**
     * Helper methods to get parent, left child and right child indices
     */
    protected int getParentIndex(int index) {
        return (index - 1) / 2;
    }
    protected int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }
    protected int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    /**
     * Helper methods to check of parent, left child and right child exists
     */
    protected boolean hasParent(int index) {
        if ((index - 2) / 2 < 0)
            return false;
        else
            return true;
    }
    protected boolean hasLeftChild(int index) {
        if ((index * 2) + 1 < currentSize)
            return true;
        else
            return false;
    }
    protected boolean hasRightChild(int index) {
        if ((index * 2) + 2 < currentSize)
            return true;
        else
            return false;
    }

    /**
     * Helper methods to get of parent, left child and right child objects
     */
    protected T getParent(int index) {
        if (hasParent(index))
            return objectArr[getParentIndex(index)];
        else
            return null;
    }
    protected T getLeftChild(int index) {
        if (hasLeftChild(index))
            return objectArr[getLeftChildIndex(index)];
        else
            return null;
    }
    protected T getRightChild(int index) {
        if (hasRightChild(index))
            return objectArr[getRightChildIndex(index)];
        else
            return null;
    }

    protected void printHeap() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(objectArr[i]+", ");
        }
        System.out.println(" ");
    }
}
