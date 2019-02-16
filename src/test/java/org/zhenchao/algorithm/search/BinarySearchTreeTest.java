package org.zhenchao.algorithm.search;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.zhenchao.algorithm.common.BSTreeNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhenchao.wang 2017-03-12 21:04
 * @version 1.0.0
 */
public class BinarySearchTreeTest {

    @Test
    public void test() throws Exception {
        Integer rKey = RandomUtils.nextInt(0, 100), rValue = RandomUtils.nextInt(0, 100);
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>(
            new BSTreeNode<Integer, Integer>(rKey, rValue, null, null, 1));
        TreeMap<Integer, Integer> backup = new TreeMap<Integer, Integer>();
        backup.put(rKey, rValue);
        for (int i = 0; i < 10000; i++) {
            Integer key = RandomUtils.nextInt(0, 100);
            Integer value = RandomUtils.nextInt(0, 100);
            System.out.print("(" + key + ", " + value + ") ");
            backup.put(key, value);
            bst.put(key, value);
        }
        System.out.println();
        bst.inorderTraverse();
        System.out.println();
        for (final Map.Entry<Integer, Integer> entry : backup.entrySet()) {
            // System.out.print(entry.getKey() + ", ");
            System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ") ");
            Assert.assertEquals(entry.getValue(), bst.get(entry.getKey()));
        }

    }

}