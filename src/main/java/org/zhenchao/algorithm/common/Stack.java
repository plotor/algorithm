package org.zhenchao.algorithm.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 栈
 *
 * @author zhenchao.wang 2017-02-19 10:28
 * @version 1.0.0
 */
public class Stack<T> implements Iterable<T> {

    private Node<T> top;     // top of stack

    private int size;          // size of the stack

    public Stack() {
        top = null;
        size = 0;
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 返回大小
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(T value) {
        Node<T> pre = top;
        top = new Node<T>(value);
        top.next = pre;
        size++;
    }

    /**
     * 出栈并删除栈顶元素
     *
     * @return
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }
        T value = top.value;        // save item to return
        top = top.next;            // delete top node
        size--;
        return value;                   // return the saved item
    }

    /**
     * 出栈但不删除栈顶元素
     *
     * @return
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }
        return top.value;
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
     * 返回一个LIFO迭代器
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(top);
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