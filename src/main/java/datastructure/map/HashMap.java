package datastructure.map;

import java.util.HashSet;
import java.util.Set;

public class HashMap<K, V> implements IMap<K, V>{

    private Node<K, V>[] nodeArr;

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
        Node<K, V>[] nodeArr = this.nodeArr;
        if(nodeArr == null)
            nodeArr = initialize();
        if(count > initialCapacity * loadFactor) {
            nodeArr = rehash();
        }
        Node<K, V> newNode = createNode(k, v);
        nodeArr = putEntry(nodeArr, newNode);
        count++;
        afterNodeInsertion(newNode,count >= maximumCapacity);
        return true;
    }

    private Node<K, V>[] initialize() {
        Node<K, V>[] nodeArr = new Node[initialCapacity];
        this.nodeArr = nodeArr;
        return nodeArr;
    }

    private Node<K, V>[] rehash() {
        Node<K, V>[] nodeArr = this.nodeArr;
        this.initialCapacity = initialCapacity << 1;
        Node<K, V>[] newNodeArr = new Node[this.initialCapacity];
        for(int i = 0; i< nodeArr.length; i++) {
            Node<K,V> node = nodeArr[i];
            if (node != null) {
                while(node.getNext() != null) {
                    newNodeArr = putEntry(newNodeArr, replacementNode(node));
                    node = node.getNext();
                }
                newNodeArr = putEntry(newNodeArr, replacementNode(node));
            }
        }
        this.nodeArr = newNodeArr;
        return newNodeArr;
    }

    private Node<K, V>[] putEntry(Node<K, V>[] nodeArr, Node<K, V> newNode) {
        int bin = getBin(newNode.getHash());
        if(nodeArr[bin] == null) {
            nodeArr[bin] = newNode;
        } else {
            Node<K, V> existingNode = nodeArr[bin];
            while(existingNode.getNext() != null)
                existingNode = existingNode.getNext();
            existingNode.setNext(newNode);
        }
        return nodeArr;
    }

    Node<K, V> createNode(K key, V value) {
        return new Node<K, V>(key, value, key.hashCode());
    }

    Node<K, V> replacementNode(Node<K, V> node) {
        return new Node<K, V>(node.getKey(), node.getValue(), node.getHash());
    }

    private int getBin(int hash) {
        return Math.abs(hash) % initialCapacity;
    }

    @Override
    public V get(K k) {
        Node<K, V> node = getNode(k);
        return (node == null) ? null : node.getValue();
    }

    final Node<K, V> getNode(K k) {
        Node<K, V>[] nodeArr = this.nodeArr;
        int hash = k.hashCode();
        int index = getBin(hash);
        Node<K, V> node = nodeArr[index];
        if (node != null) {
            if (node.getNext() != null) {
                while (node.getNext() != null) {
                    if (k.equals(node.getKey())) {
                        afterNodeAccess(node);
                        return node;
                    }
                    node = node.getNext();
                }
            }
            afterNodeAccess(node);
            return node;
        }
        return null;
    }

    @Override
    public boolean remove(K k) {
        Node<K, V>[] nodeArr = this.nodeArr;
        int hash = k.hashCode();
        Node<K, V> node = nodeArr[getBin(hash)];
        nodeArr[getBin(hash)] = null;
        count--;
        afterNodeRemoval(node);
        return true;
    }

    @Override
    public Set<K> getKeySet() {
        Node<K, V>[] nodeArr = this.nodeArr;
        Set<K> keySet = new HashSet<>();
        for(int i = 0; i < nodeArr.length; i++) {
            keySet.add(nodeArr[i].getKey());
        }
        return keySet;
    }

    /**
     * Callback methods for LinkedHashMap
     * @param node
     * @param evict
     */
    void afterNodeInsertion(HashMap.Node<K,V> node, boolean evict) { }
    void afterNodeAccess(HashMap.Node<K,V> node) { }
    void afterNodeRemoval(HashMap.Node<K,V> node) { }


    static class Node<K, V> implements IMap.IEntry<K, V> {
        private K key;
        private V value;
        private int hash;
        private Node<K, V> next;

        public Node(K key, V value) {
            this(key, value, key.hashCode(), null);
        }

        public Node(K key, V value, int hash) {
            this(key, value, hash, null);
        }

        public Node(K key, V value, int hash, Node<K, V> node) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = node;
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

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }
}
