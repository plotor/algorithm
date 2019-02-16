### Remove Duplicates from Sorted List

> No.83, easy

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,

Given 1->1->2, return 1->2.

Given 1->1->2->3->3, return 1->2->3.

#### 分析

题目的意思是给定一个已排序的链表，然后从中删除重复的结点，考察的是链表指针的操作。

#### 实现

```java
public ListNode deleteDuplicates(ListNode head) {
    if (null == head || null == head.next) return head;
    ListNode op = head, pre = head, idx = head.next;
    while (idx != null) {
        if (pre.val != idx.val) {
            op.next = idx;
            op = op.next;
            pre = idx;
        }
        idx = idx.next;
    }
    if(op.next != null) op.next = null;
    return head;
}
```