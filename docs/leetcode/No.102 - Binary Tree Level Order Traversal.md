### Binary Tree Level Order Traversal

> No.102, medium

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

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

return its level order traversal as:

```
[
  [3],
  [9,20],
  [15,7]
]
```

#### 分析

题目要求实现二叉树的层序遍历，需要注意的是树不一定是完全二叉树，所以不能通过结点的数目来做分层。

思路是可以定义一个数据结构来记录结点，和结点所在的层次，这里有一个技巧就是结点所在的层次与所在集合中的层次是相对应的。

#### 实现

```java
/**
 * 存放结点和所在层次
 */
private class Pair {
    TreeNode node;
    int level;

    public Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (null == root) return result;
    Queue<Pair> queue = new LinkedList<Pair>();
    queue.add(new Pair(root, 0));
    List<Integer> list = new ArrayList<Integer>();
    while (!queue.isEmpty()) {
        Pair pair = queue.poll();
        if (pair.level != result.size()) {
            result.add(new ArrayList<Integer>(list));
            list = new ArrayList<Integer>();
        }
        list.add(pair.node.val);
        if (null != pair.node.left) queue.add(new Pair(pair.node.left, pair.level + 1));
        if (null != pair.node.right) queue.add(new Pair(pair.node.right, pair.level + 1));
    }
    if (!list.isEmpty()) result.add(new ArrayList<Integer>(list));
    return result;
}
```