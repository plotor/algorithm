package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 *
 * @author zhenchao.wang 2017-08-19 10:02
 * @version 1.0.0
 */
public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (null == head) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label), newPre = newHead;
        map.put(head, newHead);
        RandomListNode old = head.next;
        // 处理next：建立 old 和 new 之间的映射
        while (null != old) {
            RandomListNode node = new RandomListNode(old.label);
            newPre.next = node;
            map.put(old, node);
            newPre = node;
            old = old.next;
        }

        // 处理random
        RandomListNode tmp = newHead;
        while (null != head) {
            tmp.random = map.get(head.random);
            head = head.next;
            tmp = tmp.next;
        }
        return newHead;
    }

}
