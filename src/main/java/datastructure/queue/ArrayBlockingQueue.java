package datastructure.queue;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueue<T> {

    private Object[] elements;

    private volatile int head = 0;

    private volatile int tail = 0;

    private volatile int count = 0;

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
        final Lock lock = this.lock;
        lock.lock();
        try {
            if(!enqueue(t))
                throw new Exception();
            return true;
        }
        finally {
            lock.unlock();
        }
    }

    public boolean remove() throws Exception {
        final Lock lock = this.lock;
        lock.lock();
        try {
            if(dequeue() == null)
                throw new Exception();
        }
        finally {
            lock.unlock();
        }
        return true;
    }

    public T element() throws Exception {
        Object object = null;
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
        boolean status;
        final Lock lock = this.lock;
        lock.lock();
        try {
            status = enqueue(t);
        }
        finally {
            lock.unlock();
        }
        return status;
    }

    public T poll() {
        Object object = null;
        final Lock lock = this.lock;
        lock.lock();
        try {
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
            while(!enqueue(t))
                full.await();
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
            while((object = dequeue()) == null)
                empty.await();
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
        if(tail > elements.length)
            tail = 0;
        count++;
        empty.signalAll();
        return true;
    }

    private T dequeue() {
        final Object[] elements = this.elements;
        if(head == elements.length)
            head = 0;
        Object object = elements[head];
        elements[head++] = null;
        count--;
        full.signalAll();
        return (T)object;
    }
}
