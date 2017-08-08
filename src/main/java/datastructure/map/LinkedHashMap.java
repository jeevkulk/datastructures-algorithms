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

    public LinkedHashMap(int intialCapacity, int maximumCapacity, float loadFactor, Order order) {
        super(intialCapacity, maximumCapacity, loadFactor);
        this.order = order;
    }

    @Override
    HashMap.Node<K, V> createNode(K key, V value) {
        LinkedHashMap.Node<K, V> newNode = new LinkedHashMap.Node<K, V>(key, value);
        return newNode;
    }

    @Override
    HashMap.Node<K, V> replacementNode(HashMap.Node<K, V> node) {
        LinkedHashMap.Node<K, V> linkedHashMapNode = (LinkedHashMap.Node<K, V>)node;
        LinkedHashMap.Node<K, V> newNode = new LinkedHashMap.Node<K, V>(linkedHashMapNode.getKey(), linkedHashMapNode.getValue());
        newNode.setBefore(linkedHashMapNode.getBefore());
        newNode.setAfter(linkedHashMapNode.getAfter());
        newNode.setAccessCount(linkedHashMapNode.getAccessCount());
        return newNode;
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
        if(head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else if(this.head != null) {
            LinkedHashMap.Node<K, V> second = head;
            head = newNode;
            head.setAfter(second);
            second.setBefore(head);
        }
        if(evict) {
            LinkedHashMap.Node<K, V> last = tail;
            if(last.getBefore() != null) {
                tail = last.getBefore();
                last = null;
            }
        }
    }

    @Override
    void afterNodeAccess(HashMap.Node<K, V> node) {
        LinkedHashMap.Node<K, V> accessedNode = (LinkedHashMap.Node<K, V>) node;
        if (Order.ACCESS_ORDER == this.order) {
            //Removing accessed node from the list
            LinkedHashMap.Node<K, V> beforeNode = accessedNode.getBefore();
            LinkedHashMap.Node<K, V> afterNode = accessedNode.getAfter();
            if (beforeNode != null)
                beforeNode.setAfter(afterNode);
            if (afterNode != null)
                afterNode.setBefore(beforeNode);

            //Setting accessed node as head
            LinkedHashMap.Node<K, V> secondNode = head;
            head = accessedNode;
            head.setBefore(null);
            head.setAfter(secondNode);
            secondNode.setBefore(head);
        } else if (Order.ACCESS_FREQUENCY_ORDER == this.order) {
            //Searching for right position for accessed node to be inserted
            LinkedHashMap.Node<K, V> nodePosition = accessedNode.getBefore();
            accessedNode.setAccessCount(accessedNode.getAccessCount() + 1);
            while (nodePosition != null && nodePosition.getAccessCount() <= accessedNode.getAccessCount()) {
                nodePosition = nodePosition.getBefore();
            }

            //Removing accessed node from the list
            LinkedHashMap.Node<K, V> beforeNode = accessedNode.getBefore();
            LinkedHashMap.Node<K, V> afterNode = accessedNode.getAfter();
            if (beforeNode != null)
                beforeNode.setAfter(afterNode);
            if (afterNode != null)
                afterNode.setBefore(beforeNode);

            //Insert accessed node here
            LinkedHashMap.Node<K, V> secondNode = head;
            head = accessedNode;
            head.setBefore(null);
            head.setAfter(secondNode);
            secondNode.setBefore(head);
        }
    }

    @Override
    void afterNodeRemoval(HashMap.Node<K, V> node) {
        LinkedHashMap.Node<K, V> deletedNode = (LinkedHashMap.Node<K, V>)node;
        LinkedHashMap.Node<K, V> beforeNode = deletedNode.getBefore();
        LinkedHashMap.Node<K, V> afterdNode = deletedNode.getAfter();
        if(beforeNode != null)
            beforeNode.setAfter(afterdNode);
        if(afterdNode != null)
            afterdNode.setBefore(beforeNode);
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

    enum Order {
        ACCESS_ORDER,
        ACCESS_FREQUENCY_ORDER,
        INSERTION_ORDER
    }

}
