### Add Two Numbers II

> No.445, medium

You are given two __non-empty__ linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

```
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
```

#### 分析

相对于 I 来说，这道的输入是顺序存储的，所以在进位处理上增加了难度，不过我们可以借助栈数据结构，将 l1 和 l2 中的元素分别压栈到 s1 和 s2，然后遍历处理栈，这也就可以从尾部开始累加，注意处理好进位。

#### 实现

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> s1 = new Stack<Integer>(), s2 = new Stack<Integer>(), sum = new Stack<Integer>();
    // 链表转栈存储
    while (null != l1) {
        s1.push(l1.val);
        l1 = l1.next;
    }
    while (null != l2) {
        s2.push(l2.val);
        l2 = l2.next;
    }

    // 执行求和的过程
    int carry = 0;
    while (!s1.isEmpty() && !s2.isEmpty()) {
        int s = s1.pop() + s2.pop() + carry;
        sum.push(s % 10);
        carry = s / 10;
    }
    while (!s1.isEmpty()) {
        int s = s1.pop() + carry;
        sum.push(s % 10);
        carry = s / 10;
    }
    while (!s2.isEmpty()) {
        int s = s2.pop() + carry;
        sum.push(s % 10);
        carry = s / 10;
    }
    if (carry > 0) sum.push(carry); // 防止最后一次进位

    // 栈转链表存储
    ListNode node = new ListNode(-1), root = node;
    while (!sum.isEmpty()) {
        node.next = new ListNode(sum.pop());
        node = node.next;
    }
    return root.next;
}
```
