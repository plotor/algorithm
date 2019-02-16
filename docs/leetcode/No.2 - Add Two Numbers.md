### Add Two Numbers

> No.2, medium

You are given two __non-empty__ linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
```

#### 分析

题目的意思由两个链表存储两个数（__反序排列__），数中的每个组成数值（非负数）构成链表的一个结点，要求对这两个数进行求和操作。

题目给的链表是对一个数的反序表示，这样的输入简化了编码实现，因为我们的进行加法运算时，都是从数的最低位开始，然后累加、进位操作，而反序让进位更加易于处理。在编码实现中，我们只需要考虑好进位的问题即可。

#### 实现

```java
/**
 * 加法计算都是从末位开始，所以题目中的链表已经反向存储，实则降低了题目难度
 *
 * @param l1
 * @param l2
 * @return
 */
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (null == l1 && null == l2) {
        return null;
    }

    ListNode result = new ListNode(0);
    ListNode head = result;
    int carry = 0;
    while (null != l1 && null != l2) {
        int value = l1.val + l2.val + carry;
        result.next = new ListNode(value % 10);
        carry = value / 10;
        result = result.next;
        l1 = l1.next;
        l2 = l2.next;
    }

    while (null != l1) {
        int value = l1.val + carry;
        result.next = new ListNode(value % 10);
        carry = value / 10;
        result = result.next;
        l1 = l1.next;
    }

    while (null != l2) {
        int value = l2.val + carry;
        result.next = new ListNode(value % 10);
        carry = value / 10;
        result = result.next;
        l2 = l2.next;
    }

    if (carry == 1) {
        // 不要忘了最后一次的进位
        result.next = new ListNode(1);
    }

    return head.next;
}
```