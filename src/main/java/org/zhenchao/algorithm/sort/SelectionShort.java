package org.zhenchao.algorithm.sort;

/**
 * 选择排序
 *
 * @author zhenchao.wang 2017-02-19 15:24
 * @version 1.0.0
 */
public class SelectionShort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

    @Override
    public void sort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                // 从备选元素中寻找最小的元素，将其下标赋值给min
                if (this.less(a[j], a[min])) {
                    min = j;
                }
            }
            // 交换当前元素与最小元素的位置
            this.exchange(a, i, min);
        }
    }

}
