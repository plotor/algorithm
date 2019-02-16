package org.zhenchao.algorithm.sort;

/**
 * 快速排序
 *
 * @author zhenchao.wang 2017-02-26 20:13
 * @version 1.0.0
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

    /**
     * 每次都选择当前数组的第一个元素作为标杆，让数组中该数左边的元素都不大于该数，右边的数都不小于该数
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    public int partition(T[] a, int left, int right) {
        T tmp = a[left];
        int i = left, j = right;
        while (i < j) {
            // 从右边开始
            while (a[j].compareTo(tmp) >= 0 && j > left) {
                j--;
            }
            // 然后左边
            while (a[i].compareTo(tmp) <= 0 && i < right) {
                i++;
            }
            if (i < j) {
                this.exchange(a, i, j);
            }
        }
        this.exchange(a, left, j);
        return j;
    }

    /**
     * 分治思想
     *
     * @param a
     * @param left
     * @param right
     */
    private void sort(T[] a, int left, int right) {
        if (right <= 0 || left >= right) {
            return;
        }
        int index = this.partition(a, left, right);
        this.sort(a, left, index - 1);
        this.sort(a, index + 1, right);
    }

    @Override
    public void sort(T[] a) {
        this.sort(a, 0, a.length - 1);
    }

}
