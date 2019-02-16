package org.zhenchao.algorithm.common;

/**
 * 二叉查找树节点
 *
 * @author zhenchao.wang 2017-03-12 18:19
 * @version 1.0.0
 */
public class BSTreeNode<K, V> {

    public K key;

    public V value;

    public BSTreeNode<K, V> left, right;

    public int n; // 以该节点为根的子树中的节点总数

    public BSTreeNode(K key, V value, BSTreeNode<K, V> left, BSTreeNode<K, V> right, int n) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.n = n;
    }
}
