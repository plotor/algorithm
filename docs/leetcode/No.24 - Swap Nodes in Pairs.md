### Swap Nodes in Pairs

> No.24, medium

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given `1->2->3->4`, you should return the list as `2->1->4->3`.

Your algorithm should use only constant space. You may __not__ modify the values in the list, only nodes itself can be changed.

#### 分析

题目要求我们交换一个链表邻接两个结点的位置，并且要求不能通过交换值的方式实现，必须修改指针的指向，所以整个题目考察的就是遍历链表过程中，指针重定向操作的问题。

#### 实现

```java
/**
 * 两两交换结点
 *
 * @param head
 * @return
 */
public ListNode swapPairs(ListNode head) {
    if (null == head || null == head.next) {
        return head;
    }

    // 利用一个tmp结点串起所有的结点
    ListNode newHead = new ListNode(-1), tmp = newHead;
    ListNode l = head, r = head.next;
    while (null != r) {
        l.next = r.next;
        r.next = l;
        tmp.next = r;
        tmp.next.next = l;
        tmp = tmp.next.next;
        l = l.next;
        if (null == l) {
            break;
        }
        r = l.next;
    }
    return newHead.next;
}
```

__最初的实现仅使用了 left 和 right 两个指针，但是这会因为引用问题，导致最后的结果并不是我们希望的，所以还是需要用一个旁观指针去记录整一个链。__