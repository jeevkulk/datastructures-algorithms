package datastructure.tree;

public interface Tree<T> {

    public boolean insert(T t);

    public boolean contains(T t);

    public boolean delete(T t);
}
