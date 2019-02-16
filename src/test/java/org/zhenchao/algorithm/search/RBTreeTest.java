package org.zhenchao.algorithm.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhenchao.wang 2018-03-17 16:15
 * @version 1.0.0
 */
public class RBTreeTest {

    @Test
    public void test() throws Exception {

        RBTree<Integer, Integer> rbt = new RBTree<Integer, Integer>();
        int size = 100000;
        for (int i = 0; i < size; i++) {
            rbt.put(i, i * i);
        }

        for (int i = 0; i < size; i++) {
            Assert.assertTrue(rbt.contains(i));
            Assert.assertEquals(i * i, rbt.get(i).intValue());
        }

        for (int i = size; i < size * 2; i++) {
            Assert.assertFalse(rbt.contains(i));
        }

    }
}