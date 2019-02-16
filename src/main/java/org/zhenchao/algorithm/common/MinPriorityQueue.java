package org.zhenchao.algorithm.common;

/**
 * 最小优先级队列
 * TODO 未实现 2017-3-12 14:21:03
 *
 * @author zhenchao.wang 2017-03-05 14:22
 * @version 1.0.0
 */
public class MinPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private T[] array[];  // 利用数组形式存储小端堆

    private int N = 0;

    public MinPriorityQueue() {
    }

    public MinPriorityQueue(int size) {
    }

    public MinPriorityQueue(T[] init) {
    }

    @Override
    public void insert(T value) {
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    public T min() {
        return null;
    }

    public T delMin() {
        return null;
    }
}
