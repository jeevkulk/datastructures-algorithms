package algorithm.cache.service;

import datastructure.map.LinkedHashMap;

public class CacheService<K, V> implements ICache<K, V> {

    private LinkedHashMap<K, V> cache = null;

    public CacheService(CacheType cacheType) {
        if(cacheType == CacheType.LRU_CACHE)
            cache = new LinkedHashMap<>(1 << 4, 1 << 10, LinkedHashMap.Order.ACCESS_ORDER);
        if(cacheType == CacheType.LFU_CACHE)
            cache = new LinkedHashMap<>(1 << 4, 1 << 10, LinkedHashMap.Order.ACCESS_FREQUENCY_ORDER);
    }

    @Override
    public void add(K k, V v) {
        cache.put(k, v);
    }

    @Override
    public void evict(K k) {
        cache.remove(k);
    }

    @Override
    public V get(K k) {
        return cache.get(k);
    }

    public enum CacheType {
        LRU_CACHE,
        LFU_CACHE
    }
}
