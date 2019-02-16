package org.zhenchao.algorithm.common;

/**
 * 最大堆
 *
 * @author zhenchao.wang 2017-03-05 15:34
 * @version 1.0.0
 */
public class MaxHeap<T extends Comparable<T>> extends BasicOperation<T> {

    public T[] array;

    /**
     * 上浮
     * 对于新元素，插入到数组的尾部，然后通过上浮让新元素到达合适的位置
     *
     * @param n
     */
    public void swim(int n) {
        int k = n;
        while (k / 2 > 0 && this.less(array[k / 2], array[k])) {
            this.exchange(array, k / 2, k);
            k /= 2;
        }
    }

    /**
     * 下沉
     * 如果从数组顶端删除最大元素，同时将最后一个元素放置到顶端，然后通过下沉将该元素达到合适的位置
     *
     * @param n
     * @param size
     */
    public void sink(int n, int size) {
        int k = n;
        while (2 * k < size) {
            int i = 2 * k, j = 2 * k + 1;
            if (j > size) {
                // 如果只有一个元素，则直接与2n比较
                if (this.less(array[k], array[i])) {
                    this.exchange(array, k, i);
                    k = i;
                } else {
                    break;
                }
            } else {
                // 和其中较大的元素交换
                int m = this.less(array[i], array[j]) ? j : i;
                if (this.less(array[k], array[m])) {
                    this.exchange(array, k, m);
                    k = m;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 校验是不是最大堆
     *
     * @return
     */
    public boolean isMaxHeap() {
        return this.isMaxHeap(1, array.length);
    }

    /**
     * 校验是不是最大堆
     *
     * @param start
     * @param end
     * @return
     */
    public boolean isMaxHeap(int start, int end) {
        int n = start;
        while (2 * n < end) {
            if (this.less(array[n], array[2 * n])) {
                System.out.println(String.format("index : %d < %d, val : %s < %s", n, 2 * n, array[n], array[2 * n]));
                return false;
            }
            int m = 2 * n + 1;
            if (m < end && this.less(array[n], array[m])) {
                System.out.println(String.format("index : %d < %d, val : %s < %s", n, m, array[n], array[m]));
                return false;
            }
            n++;
        }
        return true;
    }

}
