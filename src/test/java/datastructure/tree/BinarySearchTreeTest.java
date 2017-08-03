package datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree = null;

    @Before
    public void setup() {
        binarySearchTree = new BinarySearchTree();
    }

    @Test
    public void testInsert() {

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
    public void testIsBinarySearchTree() {
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
