package org.zhenchao.algorithm.search;

/**
 * 符号表定义
 *
 * @author zhenchao.wang 2017-03-12 17:26
 * @version 1.0.0
 */
public interface SymbolTable<K extends Comparable<K>, V> {

    /**
     * 将键值对存入表
     *
     * @param key
     * @param value
     */
    void put(K key, V value);

    /**
     * 获取key对应的值
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 删除key对应的值
     *
     * @param key
     */
    void delete(K key);

    /**
     * 表中是否包含key
     *
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 表的大小
     *
     * @return
     */
    int size();

    /**
     * 返回最小的键
     *
     * @return
     */
    K min();

    /**
     * 返回最大的键
     *
     * @return
     */
    K max();

    /**
     * 返回小于等于key的最大的键
     *
     * @param key
     * @return
     */
    K floor(K key);

    /**
     * 返回大于等于key的最小的键
     *
     * @param key
     * @return
     */
    K ceiling(K key);

    /**
     * 返回小于key的键的数量
     *
     * @param key
     * @return
     */
    int rank(K key);

    /**
     * 返回第k个键
     *
     * @param k
     * @return
     */
    K select(int k);

    /**
     * 删除最小的键
     */
    void deleteMin();

    /**
     * 删除最大的键
     */
    void deleteMax();

    /**
     * 返回[lo, hi]之间键的数量
     *
     * @param lo
     * @param hi
     * @return
     */
    int size(K lo, K hi);

    /**
     * 返回[lo, hi]之间的所有键，已排序
     *
     * @param lo
     * @param hi
     * @return
     */
    Iterable<K> keys(K lo, K hi);

    /**
     * 返回表中所有键的集合，已排序
     *
     * @return
     */
    Iterable<K> keys();

}
