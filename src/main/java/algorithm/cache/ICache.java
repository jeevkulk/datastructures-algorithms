package algorithm.cache;

public interface ICache {

    public boolean add(Object element);

    public boolean evict(Object element);

    public Object[] getCache();
}
