package datastructure.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class LinkedListTest {

    private LinkedList<Integer> linkedList = null;

    @Before
    public void setup() {
        linkedList = new LinkedList<>();
    }

    @Test
    public void testAddNode() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);

        while (linkedList.hasNext()) {
            System.out.println(linkedList.getNext());
        }
    }
}
