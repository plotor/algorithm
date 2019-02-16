package org.zhenchao.algorithm.common;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenchao.wang 2017-03-12 14:29
 * @version 1.0.0
 */
public class MaxPriorityQueueTest {

    @Test
    public void test() throws Exception {
        MaxPriorityQueue<Integer> mpq = new MaxPriorityQueue<Integer>(Integer.class, 100);
        for (int i = 0; i < 68; i++) {
            mpq.insert(RandomUtils.nextInt(1, 100));
        }

        List<Integer> lists = new ArrayList<Integer>();
        while (!mpq.isEmpty()) {
            lists.add(mpq.delMax());
        }
        System.out.println(lists.size());
        System.out.println(lists);
    }

}