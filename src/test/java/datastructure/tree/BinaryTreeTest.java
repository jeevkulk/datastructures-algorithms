package datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BinaryTreeTest {

    private BinaryTree binaryTree = null;

    @Before
    public void setup() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void testInsert() {

        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(4);
        binaryTree.insert(6);
        binaryTree.insert(2);
        binaryTree.insert(8);
        binaryTree.insert(1);
        binaryTree.insert(9);

        binaryTree.printInOrder();
        binaryTree.printPreOrder();
        binaryTree.printPostOrder();

        Assert.assertTrue(binaryTree.contains(5));
        Assert.assertTrue(binaryTree.contains(9));
        Assert.assertFalse(binaryTree.contains(0));
        Assert.assertFalse(binaryTree.contains(10));
    }

    @Test
    public void testIsBinarySearchTree() {
        binaryTree.insert(4);
        //binaryTree.insert(2);
        binaryTree.insert(6);
        //binaryTree.insert(1);
        //binaryTree.insert(3);
        binaryTree.insert(5);
        binaryTree.insert(7);

        Assert.assertTrue(binaryTree.isBinarySearchTree());
    }
}
