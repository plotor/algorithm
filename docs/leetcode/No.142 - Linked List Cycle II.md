### Linked List Cycle II

> No.142, medium

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up: Can you solve it without using extra space?

#### 分析

相对于 I 来说，这题要求找到环所在的起点。按照 I 中的思路只能判定是否存在环路，但是相遇时所在的点不是一定是起点，此时需要用两个指针，一个从相遇点出发，一个从 head 出发，每次各走一步，再次相遇时所在的点就是环路起点

#### 实现

```java
/**
 * 按照 I 中的思路只能判定是否重合，但是重合时所在的点不是一定是起点，
 * 此时需要用两个指针，一个从重合点出发，一个从 head 出发，每次各走一步，相逢时所在的点就是环路起点
 *
 * @param head
 * @return
 */
public ListNode detectCycle(ListNode head) {
    ListNode p = head, q = head;
    while (null != p && null != q) {
        p = p.next;
        q = q.next;
        if (q == null) return null;
        q = q.next;
        if (p == q) break;
    }
    if (null == p || null == q) return null;

    // 走到这里，说明两个结点重合了，存在环
    while (p != head) {
        p = p.next;
        head = head.next;
    }
    return p;
}
```