package datastructure.tree.binary;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    @Override
    protected void add(Node<T> node, T newElement) {
        if (node == null) {
            node = new Node<T>();
            root = node;
            node.data = newElement;
        } else if (node != null) {
            if (node.data == newElement) {
                throw new IllegalStateException();
            } else if (newElement.compareTo(node.data) < 0) {
                if (node.left != null) {
                    add(node.left, newElement);
                } else if (node.left == null) {
                    Node left = new Node();
                    left.data = newElement;
                    node.left = left;
                }
            } else if (node.data.compareTo(newElement) < 0) {
                if (node.right != null) {
                    add(node.right, newElement);
                } else if (node.right == null) {
                    Node right = new Node();
                    right.data = newElement;
                    node.right = right;
                }
            }
        }
    }

    @Override
    protected boolean contains(final Node<T> node, T element) {
        boolean isPresent = false;
        if (node != null) {
            if(node.data == element) {
                isPresent = true;
            } else if (element.compareTo(node.data) < 0) {
                isPresent = contains(node.left, element);
            } else if (node.data.compareTo(element) < 0) {
                isPresent = contains(node.right, element);
            }
        } else {
            isPresent = false;
        }
        return isPresent;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, null, null);
    }

    private boolean isBinarySearchTree(Node<T> node, T minElement, T maxElement) {
        if (node == null)
            return true;
        else if ((minElement == null || minElement.compareTo(node.data) < 0)
                && (maxElement == null || node.data.compareTo(maxElement) < 0)
                && isBinarySearchTree(node.left, minElement, node.data)
                && isBinarySearchTree(node.right, node.data, maxElement))
            return true;
        else
            return false;
    }
}


