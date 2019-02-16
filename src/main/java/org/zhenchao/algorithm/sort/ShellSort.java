package org.zhenchao.algorithm.sort;

/**
 * 希尔排序
 *
 * @author zhenchao.wang 2017-02-19 18:30
 * @version 1.0.0
 */
public class ShellSort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

    @Override
    public void sort(T[] a) {
        // 构造区间，区间对于排序性能影响较大
        int interval = 1;
        while (interval < a.length / 3) {
            interval = 3 * interval + 1;
        }

        while (interval >= 1) {
            for (int i = interval; i < a.length; i++) {
                for (int j = i; j >= interval && this.less(a[j], a[j - interval]); j -= interval) {
                    this.exchange(a, j, j - interval);
                }
            }
            interval /= 3;  // 区间收敛
        }
    }

}
