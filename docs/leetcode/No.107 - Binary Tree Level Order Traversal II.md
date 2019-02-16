### Binary Tree Level Order Traversal II

> No.107, easy

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:  
Given binary tree `[3,9,20,null,null,15,7]`,

```
eg.
    3
   / \
  9  20
    /  \
   15   7
```

return its bottom-up level order traversal as:

```
eg.
[
  [15,7],
  [9,20],
  [3]
]
```

#### 分析

相对于 I 的区别在于，这里要求返回自低而上得到层序结果。所以我们只需要在往 List 集合插入时选择前置插入即可。

#### 实现

```java
class TreeNodeWithLevel {
    TreeNode node;
    int level;

    public TreeNodeWithLevel(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

/**
 * 相对于 I 来说，只需要在插入一个 list 到结果集中时选择前置插入即可
 *
 * @param root
 * @return
 */
public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (null == root) return result;
    Queue<TreeNodeWithLevel> queue = new LinkedList<TreeNodeWithLevel>();
    queue.add(new TreeNodeWithLevel(root, 0));
    List<Integer> list = new ArrayList<Integer>();
    while (!queue.isEmpty()) {
        TreeNodeWithLevel lnode = queue.poll();
        if (lnode.level != result.size()) {
            result.add(0, new ArrayList<Integer>(list));
            list = new ArrayList<Integer>();
        }
        list.add(lnode.node.val);
        if (null != lnode.node.left) queue.add(new TreeNodeWithLevel(lnode.node.left, lnode.level + 1));
        if (null != lnode.node.right) queue.add(new TreeNodeWithLevel(lnode.node.right, lnode.level + 1));
    }
    if (!list.isEmpty()) {
        result.add(0, list);
    }
    return result;
}
```