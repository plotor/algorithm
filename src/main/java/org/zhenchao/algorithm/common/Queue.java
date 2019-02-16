package org.zhenchao.algorithm.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 队列
 *
 * @author zhenchao.wang 2017-02-19 10:41
 * @version 1.0.0
 */
public class Queue<T> implements Iterable<T> {

    private Node<T> first;    // beginning of queue

    private Node<T> last;     // end of queue

    private int size;         // number of elements on queue

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * 判断当前队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 返回当前队列的大小
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 返回队首元素
     *
     * @return
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        return first.value;
    }

    /**
     * 入队列
     *
     * @param value
     */
    public void enqueue(T value) {
        Node<T> pre = last;
        last = new Node<T>(value);
        last.next = null;
        if (this.isEmpty()) {
            first = last;
        } else {
            pre.next = last;
        }
        size++;
    }

    /**
     * 出队列
     *
     * @return
     */
    public T dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T value = first.value;
        first = first.next;
        size--;
        if (this.isEmpty()) {
            last = null;   // to avoid loitering
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T value : this) {
            builder.append(value);
            builder.append(' ');
        }
        return builder.toString();
    }

    /**
     * 返回一个迭FIFO代器
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}