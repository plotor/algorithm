package org.zhenchao.algorithm.sort;

/**
 * 归并排序（自顶向下）
 * 逐渐将待排序数组利用递归的方式切割成小的数组
 *
 * @author zhenchao.wang 2017-02-19 19:05
 * @version 1.0.0
 */
public class TopToBottomMergeSort extends MergeSort<Integer> {

    /**
     * 分治思想
     *
     * @param a
     * @param left
     * @param right
     */
    private void sort(Integer[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        this.sort(a, left, mid);
        this.sort(a, mid + 1, right);
        this.merge(a, left, mid, right);
    }

    @Override
    public void sort(Integer[] a) {
        this.aux = new Integer[a.length];
        this.sort(a, 0, a.length - 1);
    }
}
