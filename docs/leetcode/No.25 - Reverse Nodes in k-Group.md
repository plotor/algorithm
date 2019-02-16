### Reverse Nodes in k-Group

> No.25, hard

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,  
Given this linked list: `1->2->3->4->5`

For k = 2, you should return: `2->1->4->3->5`

For k = 3, you should return: `3->2->1->4->5`

#### 分析

题目要求将给定的链表按照 K 个元素为一组进行逆序操作，前面做过的 __Swap Nodes in Pairs__ 是这道题目的特殊情况，其中的 k = 2。

这道题目的解题思路就是编写一个反转链表的函数 reverse，然后从头开始遍历链表，并记录当前节点的编号 n，一旦 n % k = 0 就调用 reverse 函数执行反转操作。

#### 实现

```java
public ListNode reverseKGroup(ListNode head, int k) {
    if (k <= 1) return head;
    ListNode cur = head, start = null, pre = null, next = null;
    int n = 0;
    while (cur != null) {
        next = cur.next;
        if ((++n) % k == 0) {
            start = null == pre ? head : pre.next;
            head = null == pre ? cur : head;
            this.reverse(pre, next, start, cur);
            pre = start;
        }
        cur = next;
    }
    return head;
}

// 执行反转操作
private void reverse(ListNode left, ListNode right, ListNode start, ListNode end) {
    ListNode pre = start, cur = start.next;
    ListNode next = null;
    while (cur != right) {
        next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
    }
    if (null != left) left.next = end;
    start.next = right;
}
```
