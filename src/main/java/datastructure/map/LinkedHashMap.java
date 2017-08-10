package datastructure.map;

public class LinkedHashMap<K, V> extends HashMap<K, V> implements IMap<K, V> {

    private Order order;

    /**
     * Youngest node
     */
    LinkedHashMap.Node<K,V> head;

    /**
     * Eldest node - will be evicted first
     */
    LinkedHashMap.Node<K,V> tail;

    public LinkedHashMap() {
        super();
        this.order = Order.INSERTION_ORDER;
    }

    public LinkedHashMap(int initialCapacity) {
        super(initialCapacity);
        this.order = Order.INSERTION_ORDER;
    }

    public LinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        this.order = Order.INSERTION_ORDER;
    }

    public LinkedHashMap(int initialCapacity, int maximumCapacity, Order order) {
        super(initialCapacity, maximumCapacity);
        this.order = order;
    }

    public LinkedHashMap(int initialCapacity, int maximumCapacity, float loadFactor, Order order) {
        super(initialCapacity, maximumCapacity, loadFactor);
        this.order = order;
    }

    @Override
    HashMap.Node<K, V> createNode(K key, V value) {
        LinkedHashMap.Node<K, V> newNode = new LinkedHashMap.Node<K, V>(key, value);
        return newNode;
    }

    @Override
    HashMap.Node<K, V> replacementNode(HashMap.Node<K, V> node) {
        LinkedHashMap.Node<K, V> newNode = (LinkedHashMap.Node<K, V>)node;
        newNode.setNext(null);
        return newNode;
        /*LinkedHashMap.Node<K, V> oldNode = (LinkedHashMap.Node<K, V>)node;
        LinkedHashMap.Node<K, V> newNode = new LinkedHashMap.Node<K, V>(oldNode.getKey(), oldNode.getValue());
        newNode.setBefore(oldNode.getBefore());
        newNode.setAfter(oldNode.getAfter());
        newNode.setAccessCount(oldNode.getAccessCount());
        oldNode = null;
        return newNode;*/
    }

    @Override
    public V get(K key) {
        LinkedHashMap.Node<K, V> node = (LinkedHashMap.Node<K, V>)getNode(key);
        if(node == null) {
            return null;
        }
        return node.getValue();
    }

    @Override
    void afterNodeInsertion(HashMap.Node<K, V> node, boolean evict) {
        LinkedHashMap.Node<K, V> newNode = (LinkedHashMap.Node<K, V>) node;
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            if (Order.ACCESS_FREQUENCY_ORDER == this.order) {
                insertNodeAsPerOrder(tail, newNode);
            } else {
                setAsHead(newNode);
            }
        }
        if(evict) {
            remove(tail.getKey());
        }
    }

    private void insertNodeAsPerOrder(LinkedHashMap.Node<K, V> startNodePosition, LinkedHashMap.Node<K, V> node) {
        LinkedHashMap.Node<K, V> nodePosition = startNodePosition;
        if (Order.ACCESS_FREQUENCY_ORDER == this.order) {
            while (nodePosition != null && nodePosition.getAccessCount() <= node.getAccessCount()) {
                nodePosition = nodePosition.getBefore();
            }
        }
        if (nodePosition != null) {
            LinkedHashMap.Node<K, V> tempNode = nodePosition;
            nodePosition.setAfter(node);
            node.setBefore(nodePosition);
            node.setAfter(tempNode);
            tempNode.setBefore(node);
        } else {
            setAsHead(node);
        }
    }

    private void setAsHead(LinkedHashMap.Node<K, V> node) {
        LinkedHashMap.Node<K, V> secondNode = head;
        head = node;
        head.setBefore(null);
        head.setAfter(secondNode);
        secondNode.setBefore(head);
    }

    @Override
    void afterNodeAccess(HashMap.Node<K, V> node) {
        LinkedHashMap.Node<K, V> accessedNode = (LinkedHashMap.Node<K, V>) node;
        if (Order.ACCESS_ORDER == this.order) {
            removeNodeReference(accessedNode);
            setAsHead(accessedNode);
        } else if (Order.ACCESS_FREQUENCY_ORDER == this.order) {
            accessedNode.setAccessCount(accessedNode.getAccessCount() + 1);
            LinkedHashMap.Node<K, V> beforeNode = accessedNode.getBefore();
            removeNodeReference(accessedNode);
            insertNodeAsPerOrder(beforeNode, accessedNode);
        }
    }

    private void removeNodeReference(LinkedHashMap.Node<K, V> node) {
        LinkedHashMap.Node<K, V> beforeNode = node.getBefore();
        LinkedHashMap.Node<K, V> afterNode = node.getAfter();
        if (beforeNode != null) {
            beforeNode.setAfter(afterNode);
        } else {
            head = afterNode;
        }
        if (afterNode != null) {
            afterNode.setBefore(beforeNode);
        } else {
            tail = beforeNode;
        }
    }

    @Override
    void afterNodeRemoval(HashMap.Node<K, V> node) {
        LinkedHashMap.Node<K, V> deletedNode = (LinkedHashMap.Node<K, V>)node;
        removeNodeReference(deletedNode);
        deletedNode = null;
    }

    static class Node<K, V> extends HashMap.Node<K, V> {
        Node before, after;
        int accessCount = 0;

        public Node(K key, V value) {
            super(key, value, key.hashCode(), null);
        }

        public Node(K key, V value, int hash, Node node) {
            super(key, value, hash, node);
        }

        public Node getBefore() {
            return before;
        }

        public void setBefore(Node before) {
            this.before = before;
        }

        public Node getAfter() {
            return after;
        }

        public void setAfter(Node after) {
            this.after = after;
        }

        public int getAccessCount() {
            return accessCount;
        }

        public void setAccessCount(int accessCount) {
            this.accessCount = accessCount;
        }
    }

    public enum Order {
        ACCESS_ORDER,
        ACCESS_FREQUENCY_ORDER,
        INSERTION_ORDER
    }

}
