### Copy List with Random Pointer

> No.138, medium

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

#### 分析

题目给定了一个链表，相对于普通链表来说这个链表每个结点多出了一个指针，用于指向链表中任意其它结点，要求返回该链表的一个深拷贝。

我们可以先处理 next 指针，建立好链表，同时用一个 map 集合记录每个结点的 random 指针指向，待链表构造好之后再补上。

#### 实现

```java
class RandomListNode {

    public int label;
    public RandomListNode next, random;

    public RandomListNode(int label) {
        this.label = label;
    }

}

public RandomListNode copyRandomList(RandomListNode head) {
    if (null == head) return null;
    Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    RandomListNode newHead = new RandomListNode(head.label), newPre = newHead;
    map.put(head, newHead);
    RandomListNode old = head.next;
    // 处理next：建立 old 和 new 之间的映射
    while (null != old) {
        RandomListNode node = new RandomListNode(old.label);
        newPre.next = node;
        map.put(old, node);
        newPre = node;
        old = old.next;
    }

    // 处理random
    RandomListNode tmp = newHead;
    while (null != head) {
        tmp.random = map.get(head.random);
        head = head.next;
        tmp = tmp.next;
    }
    return newHead;
}
```
