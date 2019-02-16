### Reverse Linked List II

> No.92, medium

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:

Given `1->2->3->4->5->NULL`, m = 2 and n = 4,

return `1->4->3->2->5->NULL`.

Note:  
Given m, n satisfy the following condition:  
1 ? m ? n ? length of list.

#### 分析

题目的意思是给定一个链表，和一个区间，然后该区间内的结点逆置。

#### 实现

```java
/**
 * 三指针法，不用考虑m和n的越界问题
 *
 * @param head
 * @param m
 * @param n
 * @return
 */
public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m >= n) return head;
    ListNode pt = new ListNode(-1), nh = pt;
    pt.next = head;
    ListNode left = head, right = head;
    int dis = n - m;
    while (dis-- > 0) right = right.next;
    dis = 1;
    while (dis++ < m) {
        pt = left;
        left = left.next;
        right = right.next;
    }
    pt.next = right;
    while (left != right) {
        ListNode tmp = left;
        left = left.next;
        tmp.next = right.next;
        right.next = tmp;
    }
    return nh.next;
}
```