### Linked List Cycle

> No.141, easy

Given a linked list, determine if it has a cycle in it.

Follow up: Can you solve it without using extra space?

#### 分析

题目要求判断一个链表是否存在环。我们可以选择两个指针，一个指针一次走一步，一个指针一次走两步，如果存在环路则这两个指针迟早会相遇。

#### 实现

```java
/**
 * 采用双指针
 * 一个一次走一步，一个一次走两步，如果存在环，一定会碰面
 *
 * @param head
 * @return
 */
public boolean hasCycle(ListNode head) {
    ListNode p = head, q = head;
    while (null != p && null != q) {
        p = p.next;
        q = q.next;
        // 如果能够走到末尾，说明肯定没有环
        if (null == q) return false;
        q = q.next;
        if (p == q) return true;
    }
    return false;
}
```