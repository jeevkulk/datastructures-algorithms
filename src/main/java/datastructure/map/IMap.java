package datastructure.map;

import java.util.Set;

public interface IMap<K, V> {

    public boolean put(K k, V v);

    public V get(K k);

    public boolean remove(K k);

    public Set<K> getKeySet();

    interface IEntry<K, V> {
        public K getKey();

        public void setKey(K key);

        public V getValue();

        public void setValue(V value);
    }
}
