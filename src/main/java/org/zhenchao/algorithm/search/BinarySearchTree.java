package org.zhenchao.algorithm.search;

import org.zhenchao.algorithm.common.BSTreeNode;

/**
 * 二叉查找树
 *
 * @author zhenchao.wang 2017-03-12 18:17
 * @version 1.0.0
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements SymbolTable<K, V> {

    private BSTreeNode<K, V> root;

    public BinarySearchTree(BSTreeNode<K, V> root) {
        this.root = root;
    }

    @Override
    public void put(K key, V value) {
        this.put(root, key, value);
    }

    private void put(BSTreeNode<K, V> node, K key, V value) {
        int cValue = key.compareTo(node.key);
        if (cValue > 0) {
            if (null == node.right) {
                node.right = new BSTreeNode<K, V>(key, value, null, null, 1);
            } else {
                this.put(node.right, key, value);
            }
        } else if (cValue < 0) {
            if (null == node.left) {
                node.left = new BSTreeNode<K, V>(key, value, null, null, 1);
            } else {
                this.put(node.left, key, value);
            }
        } else {
            if (null != value) {
                node.value = value;
                node.n = this.size(node.left) + this.size(node.right) + 1;
            }
        }
    }

    @Override
    public V get(K key) {
        BSTreeNode<K, V> node = this.get(root, key);
        if (null == node) {
            return null;
        }
        return node.value;
    }

    private BSTreeNode<K, V> get(BSTreeNode<K, V> node, K key) {
        int cValue = key.compareTo(node.key);
        if (cValue > 0) {
            return this.get(node.right, key);
        } else if (cValue < 0) {
            return this.get(node.left, key);
        } else {
            return node;
        }
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return this.size(root);
    }

    private int size(BSTreeNode<K, V> node) {
        if (null == node) {
            return 0;
        }
        return node.n;
    }

    @Override
    public K min() {
        if (null == root) {
            return null;
        }
        return this.min(root);
    }

    private K min(BSTreeNode<K, V> node) {
        if (null != node.left) {
            this.min(node.left);
        }
        return node.key;
    }

    @Override
    public K max() {
        if (null == root) {
            return null;
        }
        return this.max(root);
    }

    private K max(BSTreeNode<K, V> node) {
        if (null != node.right) {
            this.max(node.right);
        }
        return node.key;
    }

    @Override
    public K floor(K key) {
        return this.floor(root, key);
    }

    /**
     * 返回小于等于key的最大的键
     *
     * @param node
     * @param key
     * @return
     */
    public K floor(BSTreeNode<K, V> node, K key) {
        if (null == node) {
            return null;
        }
        int n = node.key.compareTo(key);
        if (n == 0) {
            return node.key;
        }
        if (n > 0) {
            return this.floor(node.left, key);
        }
        K k = this.floor(node.right, key);
        if (null != k) {
            return k;
        }
        return node.key;
    }

    @Override
    public K ceiling(K key) {
        return this.ceiling(root, key);
    }

    /**
     * 返回大于等于key的最小的键
     *
     * @param node
     * @param key
     * @return
     */
    private K ceiling(BSTreeNode<K, V> node, K key) {
        if (null == node) {
            return null;
        }
        int n = node.key.compareTo(key);
        if (n == 0) {
            return node.key;
        }
        if (n < 0) {
            return this.ceiling(node.right, key);
        }
        K k = this.ceiling(node.left, key);
        if (null != k) {
            return k;
        }
        return node.key;
    }

    @Override
    public int rank(K key) {
        // 返回key在数中序号
        // TODO zhenchao 2017-3-18 13:52:20
        return 0;
    }

    @Override
    public K select(int k) {
        // TODO zhenchao 2017-3-18 13:52:52
        return null;
    }

    @Override
    public void deleteMin() {
        // TODO zhenchao 2017-3-18 13:53:05
    }

    @Override
    public void deleteMax() {
        // TODO zhenchao 2017-3-18 13:53:15
    }

    @Override
    public int size(K lo, K hi) {
        return 0;
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {
        return null;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    /**
     * 中序遍历
     */
    public void inorderTraverse() {
        this.inorderTraverse(root);
    }

    private void inorderTraverse(BSTreeNode<K, V> node) {
        if (null != node.left) {
            this.inorderTraverse(node.left);
        }
        System.out.print("(" + node.key + ", " + node.value + ") ");
        //System.out.print(node.key + ", ");
        if (null != node.right) {
            this.inorderTraverse(node.right);
        }
    }
}
