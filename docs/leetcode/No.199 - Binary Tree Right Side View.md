### Binary Tree Right Side View

> No.199, medium

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example: Given the following binary tree,

```
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```

You should return [1, 3, 4].

#### 分析

题目的意思是打印给定二叉树的右侧视图。

#### 实现

```java
/**
 * 类似于层序遍历的思想
 *
 * @param root
 * @return
 */
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (null == root) return result;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        // 保证每次开始循环之前，队列中存储的都是当前一层结点的逆序集合
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (i == 0) result.add(node.val);
            // 先放右结点，再放左结点
            if (null != node.right) queue.add(node.right);
            if (null != node.left) queue.add(node.left);
        }
    }
    return result;
}
```
