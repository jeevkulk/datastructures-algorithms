package datastructure.tree;


public class BinaryTree {

    private Node root;

    public boolean insert(int newElement) {
        return insert(root, newElement);
    }

    private boolean insert(Node node, int newElement) {
        if (node == null) {
            node = new Node();
            root = node;
            node.data = newElement;
        } else if (node != null) {
            if (node.data == newElement) {
                return false;
            } else if (newElement < node.data) {
                if (node.left != null) {
                    return insert(node.left, newElement);
                } else if (node.left == null) {
                    Node left = new Node();
                    left.data = newElement;
                    node.left = left;
                    return true;
                }
            } else if (node.data < newElement) {
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
    public boolean contains(int element) {
        return contains(root, element);
    }

    private boolean contains(final Node node, int element) {
        boolean isPresent = false;
        if (node != null) {
            if(node.data == element) {
                isPresent = true;
            } else if (element < node.data) {
                isPresent = contains(node.left, element);
            } else if (node.data < element) {
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

    private void printInOrder(Node node) {
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

    private void printPreOrder(Node node) {
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

    private void printPostOrder(Node node) {
        if (node.left != null) {
            printPostOrder(node.left);
        }
        if (node.right != null) {
            printPostOrder(node.right);
        }
        System.out.print(node.data + " ");
    }

    public boolean isBinarySearchTree() {
        return checkBST(root);
    }

    private boolean checkBST(Node node) {
        if (node.left != null && !checkBST(node.left))
            return false;
        if (node.right != null && !checkBST(node.right))
            return false;
        if (node.left != null && node.right != null && node.left.data < node.data && node.right.data > node.data)
            return true;
        else if (node.left != null && node.right == null && node.left.data < node.data)
            return true;
        else if (node.left == null && node.right != null && node.right.data > node.data)
            return true;
        else if (node.left == null && node.right == null)
            return true;
        else
            return false;
    }

    private class Node {
        int data;
        Node left;
        Node right;
    }
}


