package org.zhenchao.algorithm.common;

/**
 * 优先级队列
 *
 * @author zhenchao.wang 2017-03-05 14:13
 * @version 1.0.0
 */
public interface PriorityQueue<T extends Comparable<T>> {

    /**
     * 往优先级队列插入一个值
     *
     * @param value
     */
    void insert(T value);

    /**
     * 判空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 获取大小
     *
     * @return
     */
    int size();

}
