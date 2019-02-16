package org.zhenchao.algorithm.sort;

import org.zhenchao.algorithm.common.BasicOperation;

/**
 * 排序算法模板
 *
 * @author zhenchao.wang 2017-02-19 14:59
 * @version 1.0.0
 */
public abstract class AbstractSortAlgorithm<T extends Comparable<T>> extends BasicOperation<T> {

    /**
     * 排序函数
     *
     * @param a
     */
    public abstract void sort(T[] a);

    /**
     * 校验是否有序
     *
     * @param a
     * @return
     */
    public boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1].compareTo(a[i]) > 0) {
                return false;
            }
        }
        return true;
    }

}
