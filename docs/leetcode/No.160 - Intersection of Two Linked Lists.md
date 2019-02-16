### Intersection of Two Linked Lists

> No.160, easy

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

```
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
```

begin to intersect at node c1.


Notes:

- If the two linked lists have no intersection at all, return null.
- The linked lists must retain their original structure after the function returns.
- You may assume there are no cycles anywhere in the entire linked structure.
- Your code should preferably run in O(n) time and use only O(1) memory.

#### 分析

寻找两个数组第一次相交的结点，首先我们需要知道数组的长度（这个时候都需要达到数组的最末端，如果最末端都不是同一个结点，那说明肯定不存在相交的结点），然后保证从两个数组平齐的位置开始出发，然后开始遍历，如果存在相同的结点则说明相交，返回即可。

#### 实现

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
        return null;
    }

    ListNode ha = headA, hb = headB;
    int la = 0, lb = 0;
    // 计算链表 A 的长度
    while (ha.next != null) {
        la++;
        ha = ha.next;
    }
    // 计算链表 B 的长度
    while (hb.next != null) {
        lb++;
        hb = hb.next;
    }
    // 如果最后一个结点都不相同，那么肯定不存在交叉
    if (ha != hb) {
        return null;
    }

    // 找到同一起点
    ha = headA; hb = headB;
    if (la > lb) {
        int i = 0;
        while (i < (la - lb)) {
            ha = ha.next;
            i++;
        }
    } else if (la < lb) {
        int i = 0;
        while (i < (lb - la)) {
            hb = hb.next;
            i++;
        }
    }
    // 遍历寻找交叉点
    while (ha != null) {
        if (ha == hb) {
            return ha;
        } else {
            ha = ha.next;
            hb = hb.next;
        }
    }
    return null;
}
```
