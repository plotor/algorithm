package org.zhenchao.algorithm.common;

import java.lang.reflect.Array;

/**
 * 最大优先级队列
 *
 * @author zhenchao.wang 2017-03-05 14:15
 * @version 1.0.0
 */
public class MaxPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private MaxHeap<T> maxHeap = new MaxHeap<T>();  // 利用数组形式存储大端堆

    private int position = 0;  // 0位置不存放元素

    public MaxPriorityQueue() {
    }

    public MaxPriorityQueue(Class<T> type, int size) {
        maxHeap.array = (T[]) Array.newInstance(type, size);
    }

    public MaxPriorityQueue(T[] init) {
        this.maxHeap.array = init;
    }

    @Override
    public void insert(T value) {
        maxHeap.array[++position] = value;
        maxHeap.swim(position);
    }

    @Override
    public boolean isEmpty() {
        return this.position == 0;
    }

    @Override
    public int size() {
        return this.position;
    }

    /**
     * 返回当前队列最大的元素
     *
     * @return
     */
    public T max() {
        if (this.isEmpty()) {
            return null;
        }
        return maxHeap.array[1];
    }

    /**
     * 删除当前队列最大的元素
     *
     * @return
     */
    public T delMax() {
        if (this.isEmpty()) {
            return null;
        }
        T max = maxHeap.array[1];
        maxHeap.exchange(maxHeap.array, 1, position);
        position--;
        maxHeap.sink(1, position);
        return max;
    }

}
