package org.zhenchao.algorithm.util;

import org.junit.Test;
import org.zhenchao.algorithm.oj.ListNode;

/**
 * @author zhenchao.wang 2017-04-23 10:25
 * @version 1.0.0
 */
public class ListNodeUtilsTest {

    @Test
    public void test() throws Exception {
        ListNode node = ListNodeUtils.build(-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ListNodeUtils.display(node);
    }
}