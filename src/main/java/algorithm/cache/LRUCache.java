package algorithm.cache;

public class LRUCache implements ICache {

    @Override
    public boolean add(Object element) {
        return false;
    }

    @Override
    public boolean evict(Object element) {
        return false;
    }

    @Override
    public Object[] getCache() {
        return new Object[0];
    }
}
