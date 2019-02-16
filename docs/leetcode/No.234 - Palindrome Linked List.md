### Palindrome Linked List

> No.234, easy

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

#### 分析

题目要求判定一个链表是不是回文的，要求时间复杂度是 O(n)，空间复杂度是 O(1)。如果没有这些限制，那么我们可以基于快慢指针找到链表的中点，同时将链表前半部分的元素压栈，然后在遍历后半部分元素时，出栈比对，但是现在不能这样做。

具体的思路还是基于快慢指针找到链表的中点（如果包含偶数个元素，则中点应该是靠左边的那个），然后对后半部分链表进行逆置处理，接下去就是遍历比对的过程，实际上这里就是利用了逆置链表来代替栈的功能。

#### 实现

```java
public boolean isPalindrome(ListNode head) {
    if (null == head || null == head.next) return true;

    // 采用快慢指针找到链表的中点（如果是偶数个元素则选择靠左的一个）
    ListNode fast = head, slow = head;
    while (true) {
        fast = fast.next;
        if (null == fast || null == fast.next) break;
        fast = fast.next;
        slow = slow.next;
    }

    // 将 slow 后续的链表逆置
    ListNode curr = slow.next.next, next;
    slow.next.next = null; // 必须设置作为逆置后链表的尾结点的next指针为null
    while (null != curr) {
        next = curr.next;
        curr.next = slow.next;
        slow.next = curr;
        curr = next;
    }

    // 遍历比对
    slow = slow.next;
    while (null != slow) {
        if (head.val != slow.val) return false;
        head = head.next;
        slow = slow.next;
    }
    return true;
}
```