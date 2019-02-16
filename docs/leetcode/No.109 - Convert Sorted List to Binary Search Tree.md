### Convert Sorted List to Binary Search Tree

> No.109, medium

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

### 分析

### 实现

```java
private static ListNode node;

/**
 * 自底部向上构造
 *
 * @param head
 * @return
 */
public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    node = head;

    // 计算链表的长度
    int len = 0;
    ListNode temp = head;
    while (temp != null) {
        len++;
        temp = temp.next;
    }
    return this.build(0, len - 1);
}

private TreeNode build(int start, int end) {
    if (start > end) return null;
    int mid = (start + end) / 2;
    TreeNode left = this.build(start, mid - 1);
    TreeNode root = new TreeNode(node.val);
    root.left = left;
    node = node.next;
    root.right = this.build(mid + 1, end);
    return root;
}
```