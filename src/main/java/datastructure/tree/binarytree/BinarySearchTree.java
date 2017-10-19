package datastructure.tree;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public boolean insert(T t) {
        return insert(root, t);
    }

    private boolean insert(Node<T> node, T newElement) {
        if (node == null) {
            node = new Node<T>();
            root = node;
            node.data = newElement;
        } else if (node != null) {
            if (node.data == newElement) {
                return false;
            } else if (newElement.compareTo(node.data) < 0) {
                if (node.left != null) {
                    return insert(node.left, newElement);
                } else if (node.left == null) {
                    Node left = new Node();
                    left.data = newElement;
                    node.left = left;
                    return true;
                }
            } else if (node.data.compareTo(newElement) < 0) {
                if (node.right != null) {
                    return insert(node.right, newElement);
                } else if (node.right == null) {
                    Node right = new Node();
                    right.data = newElement;
                    node.right = right;
                    return true;
                }
            }
        }
        return true;
    }

    /**
     * Return true if the element is present in the tree or else returns false
     * @param element
     * @return
     */
    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(final Node<T> node, T element) {
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

    /**
     * Prints left-root-right
     */
    public void printInOrder() {
        System.out.println("");
        System.out.println("InOrder: ");
        if(root != null) {
            printInOrder(root);
        }
    }

    private void printInOrder(Node<T> node) {
        if(node.left != null) {
            printInOrder(node.left);
        }
        System.out.print(node.data + " ");
        if(node.right != null) {
            printInOrder(node.right);
        }
    }

    /**
     * Prints root-left-right
     */
    public void printPreOrder() {
        System.out.println("");
        System.out.println("PreOrder: ");
        if(root != null) {
            printPreOrder(root);
        }
    }

    private void printPreOrder(Node<T> node) {
        System.out.print(node.data + " ");
        if (node.left != null) {
            printPreOrder(node.left);
        }
        if (node.right != null) {
            printPreOrder(node.right);
        }
    }

    /**
     * Prints left-right-root
     */
    public void printPostOrder() {
        System.out.println("");
        System.out.println("PostOrder: ");
        if (root != null) {
            printPostOrder(root);
        }
    }

    private void printPostOrder(Node<T> node) {
        if (node.left != null) {
            printPostOrder(node.left);
        }
        if (node.right != null) {
            printPostOrder(node.right);
        }
        System.out.print(node.data + " ");
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

    public int getHeight() {
        if(root == null)
            return 0;
        return getHeight(root);
    }

    private int getHeight(Node<T> node) {
        if(node == null)
            return 0;
        else
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /*private int getHeight(Node node) {
        boolean counted = false;
        int height = 0;
        if(node.left != null) {
            counted = true;
            height++;
            height = getHeight(node.left) + height;
        }
        if(node.right != null) {
            if (!counted)
                height++;
            height = getHeight(node.right) + height;
        }
        return height;
    }*/

    public int getMaxWidth() {
        if(root == null)
            return 1;
        int maxWidth = 0;
        int tempWidth = 0;
        int height = getHeight(root);
        for(int i = 0; i < height; i++) {
            tempWidth = getWidth(root, i);
            if(tempWidth > maxWidth)
                maxWidth = tempWidth;
        }
        return maxWidth;
    }

    private int getWidth(Node<T> node, int depth) {
        if(node == null)
            return 0;
        else if(depth == 0)
            return 1;
        else
            return getWidth(node.left,depth - 1) + getWidth(node.right, depth - 1);
    }

    private class Node<T extends Comparable<T>> {
        T data;
        Node<T> left;
        Node<T> right;
    }
}


