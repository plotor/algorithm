### Rotate List

> No.61, medium

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given `1->2->3->4->5->NULL` and k = `2`,

return `4->5->1->2->3->NULL`.

#### 分析

题目的意思是给定一个链表，将链表向左平移指定的单位。这种题目一看就应该想到是用两个指针，一个在前一个在后，不过整个题目需要注意一点的就是 k 可以大于数组的长度，如果大于则需要进行取余操作。

#### 实现

```java
/**
 * 双指针法
 *
 * @param head
 * @param k
 * @return
 */
public ListNode rotateRight(ListNode head, int k) {
    if (null == head || k == 0) {
        return head;
    }

    // 计算数组的长度
    ListNode p = head;
    int len = 0;
    while (p != null) {
        p = p.next;
        len++;
    }
    k %= len; // k是允许超出数组长度的

    ListNode before = head, after = head;
    while (k-- > 0 && before.next != null) {
        before = before.next;
    }

    while (before.next != null) {
        before = before.next;
        after = after.next;
    }

    before.next = head;
    ListNode newHead = after.next;
    after.next = null;
    return newHead;
}
```