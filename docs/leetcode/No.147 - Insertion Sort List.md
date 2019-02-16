### Insertion Sort List

> No.147, medium

Sort a linked list using insertion sort.

#### 分析

基于插入排序的方式来对一个链表进行排序。

#### 实现

```java
public ListNode insertionSortList(ListNode head) {
    ListNode first = new ListNode(-1);
    while (null != head) {
        ListNode pre = first, cur = first.next;
        while (cur != null && cur.val < head.val) {
            pre = cur;
            cur = cur.next;
        }
        ListNode node = head;
        head = head.next;
        node.next = pre.next;
        pre.next = node;
    }
    return first.next;
}
```
