### Remove Linked List Elements

> No.203, easy

Remove all elements from a linked list of integers that have value val.

Example
- Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
- Return: 1 --> 2 --> 3 --> 4 --> 5

#### 分析

#### 实现

```java
public ListNode removeElements(ListNode head, int val) {
    while (null != head && head.val == val) head = head.next;
    if (null == head) return null;
    ListNode pre = head, curr = head.next;
    while (null != curr) {
        if (curr.val == val) {
            pre.next = curr.next;
        } else {
            pre = pre.next;
        }
        curr = curr.next;
    }
    return head;
}
```
