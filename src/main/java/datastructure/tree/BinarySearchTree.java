package datastructure.tree;


public class BinarySearchTree {

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
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node node, int min, int max) {
        if (node == null)
            return true;
        else if (min < node.data && node.data < max && isBinarySearchTree(node.left, min, node.data) && isBinarySearchTree(node.right, node.data, max))
            return true;
        else
            return false;
    }

    public int getHeight() {
        if(root == null)
            return 0;
        return getHeight(root);
    }

    private int getHeight(Node node) {
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

    private int getWidth(Node node, int depth) {
        if(node == null)
            return 0;
        else if(depth == 0)
            return 1;
        else
            return getWidth(node.left,depth - 1) + getWidth(node.right, depth - 1);
    }

    private class Node {
        int data;
        Node left;
        Node right;
    }
}


