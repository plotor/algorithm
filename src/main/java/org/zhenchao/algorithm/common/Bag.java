package org.zhenchao.algorithm.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 背包定义
 * 背包可以看做一个容器，能够装东西，却不强调顺序性
 *
 * @author zhenchao.wang 2017-2-19 09:57:02
 * @version 1.0.0
 */
public class Bag<T> implements Iterable<T> {

    /** 起始节点 */
    private Node<T> first;

    /** 元素的个数 */
    private int size;

    public Bag() {
        first = null;
        size = 0;
    }

    /**
     * Returns true if this bag is empty.
     *
     * @return {@code true} if this bag is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    public int size() {
        return size;
    }

    /**
     * Adds the item to this bag.
     *
     * @param value the item to add to this bag
     */
    public void add(T value) {
        Node<T> pre = first;
        first = new Node<T>(value);
        first.next = pre;
        size++;
    }

    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    /**
     * 迭代器实现
     *
     * @param <T>
     */
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
            T item = current.value;
            current = current.next;
            return item;
        }
    }
}