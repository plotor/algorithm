### Merge Two Sorted Lists

> No.21, easy

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

#### 分析

题目要求将两个已经有序的链表合并成为一个有序的链表，并且只能在原地实现。

两种思路，一是将一个链表中的元素逐个插入到另外一个链表合适的位置，另外一个就是在两个链表之间连线，修改 next 指针，最后连成的链表是一个由两个链表元素组成的、有序递增的链表。

#### 实现

下面的实现采用的是“穿线法”：

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (null == l1) {
        return l2;
    }
    if (null == l2) {
        return l1;
    }

    // 构建起始点
    ListNode p1 = l1, p2 = l2;
    ListNode index;
    if (p1.val <= p2.val) {
        index = p1;
        p1 = l1.next;
    } else {
        index = p2;
        p2 = p2.next;
    }

    ListNode header = index;

    // 穿线
    while (null != p1 && null != p2) {
        if (p1.val <= p2.val) {
            index.next = p1;
            p1 = p1.next;
        } else {
            index.next = p2;
            p2 = p2.next;
        }
        index = index.next;
    }

    // 剩下的全部拼接
    index.next = null != p1 ? p1 : p2;

    return header;
}
```