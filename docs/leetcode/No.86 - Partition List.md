### Partition List

> No.86, medium

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,

Given 1->4->3->2->5->2 and x = 3,

return 1->2->2->4->3->5.

#### 分析

题目要求给定一个链表和一个数 x，返回的链表需要保证链表中小于 x 的数都在链表的左边，大于 x 的数都在链表的右边。两种思路：

1. 找到链表中第一个大于等于目标值的点，然后从这个点开始依次寻找小于目标值的数，插入该结点的前面；
2. 从链表中逐一找出小于目标值的结点构成一个新的链表，同时将对应结点从原先链表中删除，最后将新的链表拼接在老的链表前面，下面是第一种思路的实现。

#### 实现

```java
public ListNode partition(ListNode head, int x) {
    ListNode g = head, op = new ListNode(-1), nh = op;
    while (null != g && g.val < x) {
        op = g;
        g = g.next;
    }
    // System.out.println(g.val);
    if (null == g) return head;
    ListNode idx = g.next, pre = g;
    while (null != idx) {
        if (idx.val < x) {
            pre.next = idx.next;
            ListNode tmp = idx;
            idx = idx.next;
            tmp.next = g;
            op.next = tmp;
            op = op.next;
        } else {
            pre = pre.next;
            idx = idx.next;
        }
    }
    return null == nh.next ? head : nh.next;
}
```