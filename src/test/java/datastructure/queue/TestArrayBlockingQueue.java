package datastructure.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RunWith(MockitoJUnitRunner.class)
public class TestArrayBlockingQueue {

    private ArrayBlockingQueue<String> arrayBlockingQueue;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        try {
            arrayBlockingQueue = new ArrayBlockingQueue<String>(6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAdd() throws Exception {
        Assert.assertTrue(arrayBlockingQueue.add("A"));
        Assert.assertTrue(arrayBlockingQueue.add("B"));
        Assert.assertTrue(arrayBlockingQueue.add("C"));
        Assert.assertTrue(arrayBlockingQueue.add("D"));
        Assert.assertTrue(arrayBlockingQueue.add("E"));
        Assert.assertTrue(arrayBlockingQueue.add("F"));
        Assert.assertTrue(arrayBlockingQueue.size() == 6);

        expectedException.expect(Exception.class);
        arrayBlockingQueue.add("G");
    }

    @Test
    public void testRemove() throws Exception {
        Assert.assertTrue(arrayBlockingQueue.add("A"));
        Assert.assertTrue(arrayBlockingQueue.add("B"));
        Assert.assertTrue(arrayBlockingQueue.add("C"));
        Assert.assertTrue(arrayBlockingQueue.add("D"));
        Assert.assertTrue(arrayBlockingQueue.add("E"));
        Assert.assertTrue(arrayBlockingQueue.add("F"));
        Assert.assertTrue(arrayBlockingQueue.size() == 6);

        Assert.assertTrue(arrayBlockingQueue.remove());
        Assert.assertTrue(arrayBlockingQueue.remove());
        Assert.assertTrue(arrayBlockingQueue.remove());
        Assert.assertTrue(arrayBlockingQueue.remove());
        Assert.assertTrue(arrayBlockingQueue.remove());
        Assert.assertTrue(arrayBlockingQueue.remove());
        Assert.assertTrue(arrayBlockingQueue.size() == 0);

        expectedException.expect(Exception.class);
        arrayBlockingQueue.remove();
    }

    @Test
    public void testElement() throws Exception {
        Assert.assertTrue(arrayBlockingQueue.add("A"));
        Assert.assertTrue(arrayBlockingQueue.add("B"));
        Assert.assertTrue(arrayBlockingQueue.add("C"));
        Assert.assertTrue(arrayBlockingQueue.add("D"));
        Assert.assertTrue(arrayBlockingQueue.add("E"));
        Assert.assertTrue(arrayBlockingQueue.add("F"));
        Assert.assertTrue(arrayBlockingQueue.size() == 6);

        Assert.assertTrue("A".equals(arrayBlockingQueue.element()));
        Assert.assertTrue("A".equals(arrayBlockingQueue.element()));
        Assert.assertTrue(arrayBlockingQueue.size() == 6);
    }

    @Test
    public void testOffer() throws Exception {
        Assert.assertTrue(arrayBlockingQueue.offer("A"));
        Assert.assertTrue(arrayBlockingQueue.offer("B"));
        Assert.assertTrue(arrayBlockingQueue.offer("C"));
        Assert.assertTrue(arrayBlockingQueue.offer("D"));
        Assert.assertTrue(arrayBlockingQueue.offer("E"));
        Assert.assertTrue(arrayBlockingQueue.offer("F"));
        Assert.assertTrue(arrayBlockingQueue.size() == 6);

        Assert.assertTrue(!arrayBlockingQueue.offer("G"));
        Assert.assertTrue(arrayBlockingQueue.size() == 6);
    }

    @Test
    public void testPoll() throws Exception {
        Assert.assertTrue(arrayBlockingQueue.offer("A"));
        Assert.assertTrue(arrayBlockingQueue.offer("B"));
        Assert.assertTrue(arrayBlockingQueue.offer("C"));
        Assert.assertTrue(arrayBlockingQueue.offer("D"));
        Assert.assertTrue(arrayBlockingQueue.offer("E"));
        Assert.assertTrue(arrayBlockingQueue.offer("F"));
        Assert.assertTrue(arrayBlockingQueue.size() == 6);

        Assert.assertTrue("A".equals(arrayBlockingQueue.poll()));
        Assert.assertTrue("B".equals(arrayBlockingQueue.poll()));
        Assert.assertTrue("C".equals(arrayBlockingQueue.poll()));
        Assert.assertTrue("D".equals(arrayBlockingQueue.poll()));
        Assert.assertTrue("E".equals(arrayBlockingQueue.poll()));
        Assert.assertTrue("F".equals(arrayBlockingQueue.poll()));
        Assert.assertTrue(arrayBlockingQueue.size() == 0);

        Assert.assertTrue(arrayBlockingQueue.poll() == null);
    }

    @Test
    public void testPeek() throws Exception {
        Assert.assertTrue(arrayBlockingQueue.offer("A"));
        Assert.assertTrue(arrayBlockingQueue.offer("B"));
        Assert.assertTrue(arrayBlockingQueue.offer("C"));
        Assert.assertTrue(arrayBlockingQueue.offer("D"));
        Assert.assertTrue(arrayBlockingQueue.offer("E"));
        Assert.assertTrue(arrayBlockingQueue.offer("F"));
        Assert.assertTrue(arrayBlockingQueue.size() == 6);

        Assert.assertTrue("A".equals(arrayBlockingQueue.peek()));
        Assert.assertTrue("A".equals(arrayBlockingQueue.peek()));
        Assert.assertTrue(arrayBlockingQueue.size() == 6);
    }

    @Test
    public void testPut() throws Exception {

        try {


            ExecutorService service = Executors.newFixedThreadPool(2);

            //java.util.concurrent.ArrayBlockingQueue<String> arrayBlockingQueue = new java.util.concurrent.ArrayBlockingQueue<String>(6);


            Runnable task1 = () -> {
                try {
                    Assert.assertTrue(arrayBlockingQueue.offer("A", 10000, TimeUnit.MICROSECONDS));
                    Assert.assertTrue(arrayBlockingQueue.offer("B", 10000, TimeUnit.MICROSECONDS));
                    Assert.assertTrue(arrayBlockingQueue.offer("C", 10000, TimeUnit.MICROSECONDS));
                    Assert.assertTrue(arrayBlockingQueue.offer("D", 10000, TimeUnit.MICROSECONDS));
                    Assert.assertTrue(arrayBlockingQueue.offer("E", 10000, TimeUnit.MICROSECONDS));
                    Assert.assertTrue(arrayBlockingQueue.offer("F", 10000, TimeUnit.MICROSECONDS));

                    Assert.assertTrue("A".equals(arrayBlockingQueue.poll(10000, TimeUnit.MICROSECONDS)));
                    Assert.assertTrue("B".equals(arrayBlockingQueue.poll(10000, TimeUnit.MICROSECONDS)));

                    Assert.assertTrue(arrayBlockingQueue.offer("G", 100000, TimeUnit.MICROSECONDS));
                    Assert.assertTrue(arrayBlockingQueue.offer("H", 100000, TimeUnit.MICROSECONDS));
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            };

            service.submit(task1);

       /* Runnable task2 = () -> {
            try {
                Assert.assertTrue("A".equals(arrayBlockingQueue.poll(10000, TimeUnit.MICROSECONDS)));
                Assert.assertTrue("B".equals(arrayBlockingQueue.poll(10000, TimeUnit.MICROSECONDS)));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        };


        service.submit(task2);*/

            service.awaitTermination(100000, TimeUnit.MICROSECONDS);
            service.shutdown();

            //Assert.assertTrue(arrayBlockingQueue.size() == 6);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
