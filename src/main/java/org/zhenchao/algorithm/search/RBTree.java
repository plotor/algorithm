package org.zhenchao.algorithm.search;

import org.zhenchao.algorithm.common.RBTreeNode;

import java.util.NoSuchElementException;

/**
 * 红黑树
 *
 * @author zhenchao.wang 2017-03-25 15:32
 * @version 1.0.0
 */
public class RBTree<K extends Comparable<K>, V> {

    private RBTreeNode<K, V> root;

    /**
     * 查找key对应的value
     *
     * @param key
     * @return
     */
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key can't be null!");
        }
        return this.get(root, key);
    }

    private V get(RBTreeNode<K, V> node, K key) {
        while (node != null) {
            int cmp = key.compareTo(node.getKey());
            if (cmp < 0) {
                node = node.getLeft();
            } else if (cmp > 0) {
                node = node.getRight();
            } else {
                return node.getValue();
            }
        }
        return null;
    }

    /**
     * 是否包含指定的key
     *
     * @param key
     * @return
     */
    public boolean contains(K key) {
        return this.get(key) != null;
    }

    /**
     * 插入结点
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        root = this.put(root, key, value);
        root.setColor(RBTreeNode.Color.BLACK);
    }

    private RBTreeNode<K, V> put(RBTreeNode<K, V> node, K key, V value) {
        if (null == node) {
            return new RBTreeNode<K, V>(key, value, RBTreeNode.Color.BLACK, 1);
        }

        // 1. 插入结点

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            // 左插入
            node.setLeft(this.put(node.getLeft(), key, value));
        } else if (cmp > 0) {
            // 右插入
            node.setRight(this.put(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }

        // 2. 再平衡

        if (this.isRed(node.getRight()) && this.isBlack(node.getLeft())) {
            node = this.rotateLeft(node);
        }

        if (this.isRed(node.getLeft()) && this.isRed(node.getLeft().getLeft())) {
            node = this.rotateRight(node);
        }

        if (this.isRed(node.getLeft()) && this.isRed(node.getRight())) {
            this.flipColors(node);
        }

        node.setSize(this.size(node.getLeft()) + this.size(node.getRight()) + 1);
        return node;
    }

    /**
     * 删除指定的结点
     *
     * @param key
     */
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!this.contains(key)) {
            return;
        }

        if (this.isBlack(root.getLeft()) && this.isBlack(root.getRight())) {
            root.setColor(RBTreeNode.Color.RED);
        }

        root = this.delete(root, key);
        if (!this.isEmpty()) {
            root.setColor(RBTreeNode.Color.BLACK);
        }
    }

    private RBTreeNode<K, V> delete(RBTreeNode<K, V> node, K key) {

        if (key.compareTo(node.getKey()) < 0) {
            if (this.isBlack(node.getLeft()) && this.isBlack(node.getLeft().getLeft())) {
                node = this.moveRedLeft(node);
            }
            node.setLeft(this.delete(node.getLeft(), key));
        } else {
            if (this.isRed(node.getLeft())) {
                node = this.rotateRight(node);
            }
            if (key.compareTo(node.getKey()) == 0 && (node.getRight() == null)) {
                return null;
            }
            if (this.isBlack(node.getRight()) && this.isBlack(node.getRight().getLeft())) {
                node = this.moveRedRight(node);
            }
            if (key.compareTo(node.getKey()) == 0) {
                RBTreeNode<K, V> x = this.min(node.getRight());
                node.setKey(x.getKey());
                node.setValue(x.getValue());
                node.setRight(this.deleteMin(node.getRight()));
            } else {
                node.setRight(this.delete(node.getRight(), key));
            }
        }
        return this.balance(node);
    }

    /**
     * 删除最小的结点
     */
    public void deleteMin() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        if (this.isBlack(root.getLeft()) && this.isBlack(root.getRight())) {
            root.setColor(RBTreeNode.Color.RED);
        }

        root = this.deleteMin(root);
        if (!this.isEmpty()) {
            root.setColor(RBTreeNode.Color.BLACK);
        }
    }

    private RBTreeNode<K, V> deleteMin(RBTreeNode<K, V> node) {
        if (node.getLeft() == null) {
            return null;
        }

        if (this.isBlack(node.getLeft()) && this.isBlack(node.getLeft().getLeft())) {
            node = this.moveRedLeft(node);
        }

        node.setLeft(this.deleteMin(node.getLeft()));
        return this.balance(node);
    }

    /**
     * 删除最大的结点
     */
    public void deleteMax() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        if (this.isBlack(root.getLeft()) && this.isBlack(root.getRight())) {
            root.setColor(RBTreeNode.Color.RED);
        }

        root = this.deleteMax(root);
        if (!this.isEmpty()) {
            root.setColor(RBTreeNode.Color.BLACK);
        }
    }

    private RBTreeNode<K, V> deleteMax(RBTreeNode<K, V> node) {
        if (this.isRed(node.getLeft())) {
            node = this.rotateRight(node);
        }

        if (node.getRight() == null) {
            return null;
        }

        if (this.isBlack(node.getRight()) && this.isBlack(node.getRight().getLeft())) {
            node = this.moveRedRight(node);
        }

        node.setRight(this.deleteMax(node.getRight()));

        return this.balance(node);
    }

    /**
     * 返回最小的key
     *
     * @return
     */
    public K min() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("called min() with empty symbol table");
        }
        return this.min(root).getKey();
    }

    private RBTreeNode<K, V> min(RBTreeNode<K, V> node) {
        return null == node.getLeft() ? node : this.min(node.getLeft());
    }

    /**
     * 返回最大的key
     *
     * @return
     */
    public K max() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("called max() with empty symbol table");
        }
        return this.max(root).getKey();
    }

    private RBTreeNode<K, V> max(RBTreeNode<K, V> node) {
        return null == node.getRight() ? node : this.max(node.getRight());
    }

    /**
     * 获取树的总结点数
     *
     * @return
     */
    public long size() {
        return this.size(root);
    }

    /**
     * 返回当前节点子节点的数目，若没有子节点则返回0
     *
     * @param node
     * @return
     */
    private long size(RBTreeNode<K, V> node) {
        if (null == node) {
            return 0;
        }
        return node.getSize();
    }

    /**
     * 是否是一棵空树
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 颜色转换
     * 将节点node的两个子节点颜色变黑，并将自己的颜色变为红色
     *
     * @param node
     */
    private void flipColors(RBTreeNode<K, V> node) {
        node.setColor(RBTreeNode.Color.RED);
        node.getLeft().setColor(RBTreeNode.Color.BLACK);
        node.getRight().setColor(RBTreeNode.Color.BLACK);
    }

    /**
     * 判断是否是红结点
     *
     * @param node
     * @return
     */
    private boolean isRed(RBTreeNode<K, V> node) {
        if (null == node) {
            return false;
        }
        return RBTreeNode.Color.RED.equals(node.getColor());
    }

    /**
     * 判断是否是黑结点
     *
     * @param node
     * @return
     */
    private boolean isBlack(RBTreeNode<K, V> node) {
        return !this.isRed(node);
    }

    private RBTreeNode<K, V> moveRedLeft(RBTreeNode<K, V> node) {
        this.flipColors(node);
        if (this.isRed(node.getRight().getLeft())) {
            node.setRight(this.rotateRight(node.getRight()));
            node = this.rotateLeft(node);
            this.flipColors(node);
        }
        return node;
    }

    private RBTreeNode<K, V> moveRedRight(RBTreeNode<K, V> node) {
        this.flipColors(node);
        if (this.isRed(node.getLeft().getLeft())) {
            node = this.rotateRight(node);
            this.flipColors(node);
        }
        return node;
    }

    private RBTreeNode<K, V> balance(RBTreeNode<K, V> node) {
        if (this.isRed(node.getRight())) {
            node = this.rotateLeft(node);
        }
        if (this.isRed(node.getLeft()) && this.isRed(node.getLeft().getLeft())) {
            node = this.rotateRight(node);
        }
        if (this.isRed(node.getLeft()) && this.isRed(node.getRight())) {
            this.flipColors(node);
        }

        node.setSize(this.size(node.getLeft()) + this.size(node.getRight()) + 1);
        return node;
    }

    /**
     * 左旋转
     * 红色右链接 -> 红色左链接
     *
     * @param node
     * @return
     */
    private RBTreeNode<K, V> rotateLeft(RBTreeNode<K, V> node) {
        RBTreeNode<K, V> parent = node.getRight();
        node.setRight(parent.getLeft());
        parent.setLeft(node);
        parent.setColor(node.getColor());
        node.setColor(RBTreeNode.Color.RED);
        parent.setSize(node.getSize());
        node.setSize(1 + this.size(node.getLeft()) + this.size(node.getRight()));
        return parent;
    }

    /**
     * 右旋转
     *
     * @param node
     * @return
     */
    private RBTreeNode<K, V> rotateRight(RBTreeNode<K, V> node) {
        RBTreeNode<K, V> parent = node.getLeft();
        node.setLeft(parent.getRight());
        parent.setRight(node);
        parent.setColor(node.getColor());
        node.setColor(RBTreeNode.Color.RED);
        parent.setSize(node.getSize());
        node.setSize(1 + this.size(node.getLeft()) + this.size(node.getRight()));
        return parent;
    }
}
