package org.zhenchao.algorithm.sort;

/**
 * 归并排序
 *
 * @author zhenchao.wang 2017-02-26 16:33
 * @version 1.0.0
 */
public abstract class MergeSort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

    protected T[] aux;

    /**
     * 对一个数组merge有序
     * 数组a[left...mid]和a[mid+1...right]已经有序
     *
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    protected void merge(T[] a, int left, int mid, int right) {

        // 先复制一份数组a，用于比较
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }

        // 因为数组a的两部分之前已经是有序的，所以只需要从两个有序数数组开始位置一一比较
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // 左边数组已经消耗完
                a[k] = aux[j++];
            } else if (j > right) {
                // 右边数组已经消耗完
                a[k] = aux[i++];
            } else if (this.less(aux[i], aux[j])) {
                // 选择两个数中较小的一个
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }

    }

}
