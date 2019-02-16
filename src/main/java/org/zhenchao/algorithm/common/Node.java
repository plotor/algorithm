package org.zhenchao.algorithm.common;

/**
 * 节点定义
 *
 * @author zhenchao.wang 2017-02-19 10:30
 * @version 1.0.0
 */
public class Node<T> {

    public T value;

    public Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
