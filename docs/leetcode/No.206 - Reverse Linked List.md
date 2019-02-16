### Reverse Linked List

> No.206, easy

Reverse a singly linked list.

#### 分析

题目的意思是给定一个链表，然后将其逆置返回。

#### 实现

```java
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        ListNode root = head;
        while (p != null) {
            //删除p结点
            root.next = p.next;
            // 将p结点插入到头结点后面
            ListNode q = p;
            p = p.next;
            q.next = head;
            head = q;
        }
        return head;
    }
}
```