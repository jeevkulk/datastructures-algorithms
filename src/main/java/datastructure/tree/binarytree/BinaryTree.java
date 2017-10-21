package datastructure.tree.binarytree;

import datastructure.tree.Tree;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

    protected Node<T> root;

    /**
     * Inserts element into the tree and returns true on success
     * @param t
     * @return
     */
    @Override
    public void add(T t) {
        add(root, t);
    }

    protected void add(Node<T> node, T newElement) {
        //TODO: To be implemented
    }

    /**
     * Return true if the element is present in the tree or else returns false
     * @param element
     * @return
     */
    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    protected boolean contains(Node<T> node, T newElement) {
        //TODO: To be implemented
        return false;
    }

    /**
     * Deletes element from the tree and returns true on success
     * @return
     */
    @Override
    public T poll() {
        //TODO: To be implemented
        return null;
    }

    @Override
    public T peek() {
        //TODO: To be implemented
        return null;
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

    protected class Node<T extends Comparable<T>> {
        T data;
        Node<T> left;
        Node<T> right;
    }
}
