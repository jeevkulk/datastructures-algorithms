package datastructure.queue;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueue<T> {

    private Object[] elements;

    private int head = 0;

    private int tail = 0;

    private int count = 0;

    private final Lock lock;

    private final Condition full;

    private final Condition empty;

    public ArrayBlockingQueue(int capacity) throws Exception {
        if(capacity < 0)
            throw new Exception();
        elements = new Object[capacity];
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
    }

    public boolean add(T t) throws Exception {
        final Object[] elements = this.elements;
        final Lock lock = this.lock;
        lock.lock();
        try {
            if(count == elements.length)
                throw new Exception();
            enqueue(t);
            return true;
        }
        finally {
            lock.unlock();
        }
    }

    public boolean remove() throws Exception {
        final Object[] elements = this.elements;
        final Lock lock = this.lock;
        lock.lock();
        try {
            if(count <= 0)
                throw new Exception();
            dequeue();
            return true;
        }
        finally {
            lock.unlock();
        }
    }

    public T element() throws Exception {
        Object object = null;
        final Object[] elements = this.elements;
        final Lock lock = this.lock;
        lock.lock();
        try {
            if(count <= 0)
                throw new Exception();
            object = elements[head];
        }
        finally {
            lock.unlock();
        }
        return (T)object;
    }

    public boolean offer(T t) {
        final Object[] elements = this.elements;
        final Lock lock = this.lock;
        lock.lock();
        try {
            if(count == elements.length)
                return false;
            else
                return enqueue(t);
        }
        finally {
            lock.unlock();
        }
    }

    public T poll() {
        Object object = null;
        final Lock lock = this.lock;
        lock.lock();
        try {
            if(count <= 0)
                return null;
            object = dequeue();
        }
        finally {
            lock.unlock();
        }
        return (T)object;
    }

    public T peek() {
        Object object = null;
        final Lock lock = this.lock;
        lock.lock();
        try {
            if(count <= 0)
                return null;
            object = elements[head];
        }
        finally {
            lock.unlock();
        }
        return (T)object;
    }

    public void put(T t) throws InterruptedException {
        final Lock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while(count == elements.length)
                full.await();
            enqueue(t);
        }
        finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        Object object = null;
        final Lock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while(count <= 0)
                empty.await();
            object = dequeue();
        }
        finally {
            lock.unlock();
        }
        return (T)object;
    }

    public boolean offer(T t, long waitTime, TimeUnit timeUnit) throws InterruptedException {
        final Lock lock = this.lock;
        long nanos = timeUnit.toNanos(waitTime);
        lock.lockInterruptibly();
        try {
            while(count == elements.length) {
                full.awaitNanos(nanos);
            }
            enqueue(t);
            return true;
        }
        finally {
            lock.unlock();
        }
    }

    public T poll(long waitTime, TimeUnit timeUnit) throws InterruptedException {
        final Lock lock = this.lock;
        long nanos = timeUnit.toNanos(waitTime);
        lock.lockInterruptibly();
        try {
            while(count == 0) {
                empty.awaitNanos(nanos);
            }
            return dequeue();
        }
        finally {
            lock.unlock();
        }
    }

    public int size() throws InterruptedException {
        final Lock lock = this.lock;
        lock.lockInterruptibly();
        try {
            return count;
        }
        finally {
            lock.unlock();
        }
    }

    private boolean enqueue(T t) {
        final Object[] elements = this.elements;
        elements[tail++] = t;
        if(tail == elements.length)
            tail = 0;
        count++;
        empty.signalAll();
        return true;
    }

    private T dequeue() {
        final Object[] elements = this.elements;
        Object object = elements[head];
        elements[head++] = null;
        if(head == elements.length)
            head = 0;
        count--;
        full.signalAll();
        return (T)object;
    }
}
