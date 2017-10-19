package datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BinarySearchTreeTest {

    @Test
    public void testIntegerInsert() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(1);
        binarySearchTree.insert(9);

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

        binarySearchTree.insert("IBBS");
        binarySearchTree.insert("OrbiOne");
        binarySearchTree.insert("LDS");
        binarySearchTree.insert("PayableFinancing");
        binarySearchTree.insert("Astellas");
        binarySearchTree.insert("JVE");
        binarySearchTree.insert("LEMAP");
        binarySearchTree.insert("LEBCT");
        binarySearchTree.insert("TradeUtil");
        binarySearchTree.insert("Compass");

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
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);

        Assert.assertTrue(binarySearchTree.isBinarySearchTree());
    }

    @Test
    public void testGetHeight() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);

        Assert.assertTrue(binarySearchTree.getHeight() == 3);
    }

    @Test
    public void testGetMaxWidth() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);

        Assert.assertTrue(binarySearchTree.getMaxWidth() == 4);
    }
}
