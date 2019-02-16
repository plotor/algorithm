package org.zhenchao.algorithm.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * @author zhenchao.wang 2017-02-19 15:38
 * @version 1.0.0
 */
public class SortAlgorithmTest {

    private static final int SIZE = 1000;

    private Integer[] array = new Integer[SIZE];

    @Before
    public void setUp() throws Exception {
        // 构造随机数组
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(2000) - 1000;
        }
    }

    @Test
    public void selectionSortTest() throws Exception {
        SelectionShort<Integer> ss = new SelectionShort<Integer>();
        ss.sort(array);
        ss.show(array);
        Assert.assertTrue(ss.isSorted(array));
    }

    @Test
    public void insertionSortTest() throws Exception {
        InsertionSort<Integer> is = new InsertionSort<Integer>();
        is.sort(array);
        is.show(array);
        Assert.assertTrue(is.isSorted(array));
    }

    @Test
    public void shellSortTest() throws Exception {
        ShellSort<Integer> ss = new ShellSort<Integer>();
        ss.sort(array);
        ss.show(array);
        Assert.assertTrue(ss.isSorted(array));
    }

    @Test
    public void t2bMergeSortTest() throws Exception {
        TopToBottomMergeSort ms = new TopToBottomMergeSort();
        ms.sort(array);
        ms.show(array);
        Assert.assertTrue(ms.isSorted(array));
    }

    @Test
    public void b2tMergeSortTest() throws Exception {
        BottomToTopMergeSort ms = new BottomToTopMergeSort();
        ms.sort(array);
        ms.show(array);
        Assert.assertTrue(ms.isSorted(array));
    }

    @Test
    public void quickSortTest() throws Exception {
        QuickSort<Integer> qs = new QuickSort<Integer>();
        qs.sort(array);
        qs.show(array);
        Assert.assertTrue(qs.isSorted(array));
    }

}