package org.zhenchao.algorithm.common;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhenchao.wang 2017-03-12 11:24
 * @version 1.0.0
 */
public class MaxHeapTest {

    private static final int SIZE = 100;

    private MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();

    @Before
    public void setUp() throws Exception {
        // 构建最大堆
        maxHeap.array = new Integer[SIZE];
        for (int i = 1; i < SIZE; i++) {
            maxHeap.array[i] = RandomUtils.nextInt(1, 100);
            maxHeap.swim(i);
        }
        System.out.print("最大堆：");
        maxHeap.show(maxHeap.array, 1);
    }

    @Test
    public void swim() throws Exception {
        Assert.assertTrue(maxHeap.isMaxHeap());
    }

    @Test
    public void sink() throws Exception {
        int max = maxHeap.array[1];
        System.out.println("max:" + max);
        // 将最后一个位置至于顶部
        maxHeap.exchange(maxHeap.array, 1, SIZE - 1);
        // 下沉
        maxHeap.sink(1, SIZE - 1);
        maxHeap.show(maxHeap.array, 1, SIZE - 1);
        Assert.assertTrue(maxHeap.isMaxHeap(1, SIZE - 1));
    }

}