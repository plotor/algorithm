package org.zhenchao.algorithm.sort;

/**
 * 归并排序（自底向上）
 * 按照1,2,4,8...大小来逐渐归并
 *
 * @author zhenchao.wang 2017-02-26 16:30
 * @version 1.0.0
 */
public class BottomToTopMergeSort extends MergeSort<Integer> {

    @Override
    public void sort(Integer[] a) {
        this.aux = new Integer[a.length];
        for (int n = 1; n < a.length; n *= 2) {
            for (int i = 0; i <= a.length - n; i += 2 * n) {
                this.merge(a, i, (i + n - 1), Math.min(i + 2 * n - 1, a.length - 1));
            }
        }
    }

}
