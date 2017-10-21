package datastructure.tree;

public interface Tree<T> {

    public void add(T t);

    public boolean contains(T t);

    public T poll();

    public T peek();
}
