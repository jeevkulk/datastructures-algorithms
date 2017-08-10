package algorithm.cache.service;

public interface ICache<K, V> {

    public void add(K k, V v);

    public void evict(K k);

    public V get(K k);
}
