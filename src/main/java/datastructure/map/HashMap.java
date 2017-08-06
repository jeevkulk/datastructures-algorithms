package datastructure.map;

import java.util.HashSet;
import java.util.Set;

public class HashMap<K, V> implements IMap<K, V>{

    private Entry<K, V>[] entryArr;

    private int count;

    private int initialCapacity;

    private int maximumCapacity;

    private double loadFactor;

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    private static final int DEFAULT_MAX_CAPACITY = 1 << 30;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int initialCapacity, float loadFactor) {
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;
    }

    public HashMap(int initialCapacity, int maximumCapacity, float loadFactor) {
        this.initialCapacity = initialCapacity;
        this.maximumCapacity = maximumCapacity;
        this.loadFactor = loadFactor;
    }

    @Override
    public boolean put(K k, V v) {
        Entry<K, V>[] entryArr = this.entryArr;
        if(entryArr == null)
            entryArr = initialize();
        if(count > initialCapacity * loadFactor) {
            entryArr = rehash();
        }
        entryArr = putEntry(entryArr, k, v);
        count++;
        return true;
    }

    private Entry<K, V>[] putEntry(Entry<K, V>[] entryArr, K k, V v) {
        int hash = k.hashCode();
        Entry<K, V> newEntry = new Entry(k, v, hash);
        int bin = getBin(hash);
        if(entryArr[bin] == null) {
            entryArr[bin] = newEntry;
        } else {
            Entry<K, V> existingEntry = entryArr[bin];
            while(existingEntry.getNext() != null)
                existingEntry = existingEntry.getNext();
            existingEntry.setNext(newEntry);
        }
        return entryArr;
    }

    private Entry<K, V>[] initialize() {
        Entry<K, V>[] entryArr = new Entry[initialCapacity];
        this.entryArr = entryArr;
        return entryArr;
    }

    private Entry<K, V>[] rehash() {
        Entry<K, V>[] entryArr = this.entryArr;
        this.initialCapacity = initialCapacity << 1;
        Entry<K, V>[] newEntryArr = new Entry[this.initialCapacity];
        for(int i=0; i<entryArr.length; i++) {
            Entry<K,V> entry = entryArr[i];
            if (entry != null) {
                while(entry.getNext() != null) {
                    newEntryArr = putEntry(newEntryArr, entry.getKey(), entry.getValue());
                    entry = entry.getNext();
                }
                newEntryArr = putEntry(newEntryArr, entry.getKey(), entry.getValue());
            }
        }
        this.entryArr = newEntryArr;
        return newEntryArr;
    }

    private int getBin(int hash) {
        return Math.abs(hash) % initialCapacity;
    }

    @Override
    public V get(K k) {
        Entry<K, V>[] entryArr = this.entryArr;
        int hash = k.hashCode();
        int index = getBin(hash);
        Entry<K, V> entry = entryArr[index];
        if(entry != null) {
            if (entry.getNext() != null) {
                while (entry.getNext() != null) {
                    if (k.equals(entry.getKey()))
                        return entry.getValue();
                    entry = entry.getNext();
                }
            }
            return entry.getValue();
        }
        return null;
    }

    @Override
    public boolean remove(K k) {
        Entry<K, V>[] entryArr = this.entryArr;
        int hash = k.hashCode();
        entryArr[getBin(hash)] = null;
        count--;
        return true;
    }

    @Override
    public Set<K> getKeySet() {
        Entry<K, V>[] entryArr = this.entryArr;
        Set<K> keySet = new HashSet<>();
        for(int i = 0; i < entryArr.length; i++) {
            keySet.add(entryArr[i].getKey());
        }
        return null;
    }

    private class Entry<K, V> implements IMap.IEntry<K, V> {
        private K key;
        private V value;
        private int hash;
        private Entry<K, V> next;

        public Entry(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}
