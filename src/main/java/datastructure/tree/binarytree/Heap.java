package datastructure.tree.binarytree;

import datastructure.tree.Tree;

public abstract class Heap<T extends Comparable<T>> implements Tree<T> {

    protected Object[] objectArr = null;

    protected final static int DEFAULT_INITIAL_SIZE = 1 << 4;

    protected final static float DEFAULT_LOAD_FACTOR = 0.75f;

    protected int initialSize;

    protected float loadFactor;

    protected int currentSize = -1;

    @Override
    public boolean insert(T element) {
        if (currentSize >= loadFactor * objectArr.length) {
            doubleArr();
        }
        objectArr[++currentSize] = element;
        validateHeap(element, currentSize);
        return true;
    }

    protected abstract void validateHeap(T element, int position);

    protected void swap(int position1, int position2) {
        Object temp = objectArr[position1];
        objectArr[position1] = objectArr[position2];
        objectArr[position2] = temp;
    }

    private void doubleArr() {
        Object[] newObjectArr = new Object[initialSize << 1];
        for (int i = 0; i < currentSize; i++) {
            newObjectArr[i] = objectArr[i];
        }
        objectArr = newObjectArr;
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
    public boolean delete(T t) {
        for (int i = 0; i < currentSize; i++) {
            if (objectArr[i] == t) {
                objectArr[i] = null;
                validateHeap(null, i);
                return true;
            }
        }
        return false;
    }
}
