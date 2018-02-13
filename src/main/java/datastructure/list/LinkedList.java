package datastructure.list;

public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private Node<E> current;
    private int size = 0;

    public LinkedList() {
        first = last = current = null;
    }

    public void addFirst(E e) {
        Node<E> node = new Node<>(e);
        if (first == null) {
            last = node;
            first = node;
        } else {
            first.setPrevious(node);
            node.setNext(first);
            first = node;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> node = new Node<>(e);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }
        size++;
    }

    public boolean hasPrevious() {
        if (current == null) {
            current = first;
        }
        return current.getPrevious() != null;
    }

    public boolean hasNext() {
        if (current == null) {
            current = first;
        }
        return current.getNext() != null;
    }

    public Node<E> getPrevious() {
        if (current == null) {
            current = first;
        }
        Node<E> node = current.getPrevious();
        current = node;
        return node;
    }

    public Node<E> getCurrent() {
        if (current == null) {
            current = first;
        }
        return current;
    }

    public Node<E> getNext() {
        if (current == null) {
            current = first;
        }
        Node<E> node = current.getNext();
        current = node;
        return node;
    }

    public void removeNode(Node<E> node) {
        if (node == null) {
            throw new IllegalArgumentException();
        } else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            node = null;
        }
    }

    private static class Node<E> {
        private E object;
        private Node<E> previous;
        private Node<E> next;

        public Node(E object) {
            this.object = object;
        }

        public E getObject() {
            return object;
        }

        public void setObject(E object) {
            this.object = object;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "object=" + object +
                    '}';
        }
    }
}
