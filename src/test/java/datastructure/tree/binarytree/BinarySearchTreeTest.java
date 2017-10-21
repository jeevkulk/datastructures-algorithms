package datastructure.tree.binarytree;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BinarySearchTreeTest {

    @Test
    public void testIntegerInsert() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(5);
        binarySearchTree.add(3);
        binarySearchTree.add(7);
        binarySearchTree.add(4);
        binarySearchTree.add(6);
        binarySearchTree.add(2);
        binarySearchTree.add(8);
        binarySearchTree.add(1);
        binarySearchTree.add(9);

        binarySearchTree.printInOrder();
        binarySearchTree.printPreOrder();
        binarySearchTree.printPostOrder();

        Assert.assertTrue(binarySearchTree.contains(5));
        Assert.assertTrue(binarySearchTree.contains(9));
        Assert.assertFalse(binarySearchTree.contains(0));
        Assert.assertFalse(binarySearchTree.contains(10));
    }

    @Test
    public void testStringInsert() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.add("IBBS");
        binarySearchTree.add("OrbiOne");
        binarySearchTree.add("LDS");
        binarySearchTree.add("PayableFinancing");
        binarySearchTree.add("Astellas");
        binarySearchTree.add("JVE");
        binarySearchTree.add("LEMAP");
        binarySearchTree.add("LEBCT");
        binarySearchTree.add("TradeUtil");
        binarySearchTree.add("Compass");

        binarySearchTree.printInOrder();
        binarySearchTree.printPreOrder();
        binarySearchTree.printPostOrder();

        Assert.assertTrue(binarySearchTree.contains("Compass"));
        Assert.assertTrue(binarySearchTree.contains("JVE"));
        Assert.assertFalse(binarySearchTree.contains("COLT"));
        Assert.assertFalse(binarySearchTree.contains("GRID"));
    }

    @Test
    public void testIsBinarySearchTree() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(4);
        binarySearchTree.add(2);
        binarySearchTree.add(6);
        binarySearchTree.add(1);
        binarySearchTree.add(3);
        binarySearchTree.add(5);
        binarySearchTree.add(7);

        Assert.assertTrue(binarySearchTree.isBinarySearchTree());
    }

    @Test
    public void testGetHeight() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(4);
        binarySearchTree.add(2);
        binarySearchTree.add(6);
        binarySearchTree.add(1);
        binarySearchTree.add(3);
        binarySearchTree.add(5);
        binarySearchTree.add(7);

        Assert.assertTrue(binarySearchTree.getHeight() == 3);
    }

    @Test
    public void testGetMaxWidth() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(4);
        binarySearchTree.add(2);
        binarySearchTree.add(6);
        binarySearchTree.add(1);
        binarySearchTree.add(3);
        binarySearchTree.add(5);
        binarySearchTree.add(7);

        Assert.assertTrue(binarySearchTree.getMaxWidth() == 4);
    }
}
