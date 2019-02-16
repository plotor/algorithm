### Path Sum II

> No.113, medium

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example: Given the below binary tree and sum = 22,

```
eg.
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
```

return

```
[
   [5,4,11,2],
   [5,8,4,5]
]
```

#### 分析

给定一棵二叉树，找出所有由根结点到叶结点的路径，保证路径上的值之和等于指定的值。

#### 实现

```java
private List<List<Integer>> result = new ArrayList<List<Integer>>();

public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (null == root) return result;
    this.findPath(root, sum, 0, new ArrayList<Integer>());
    return this.result;
}

private void findPath(TreeNode node, int sum, int val, List<Integer> list) {
    list.add(node.val);
    val += node.val;
    if (null == node.left && null == node.right) {
        if (val == sum) {
            this.result.add(new ArrayList<Integer>(list));
        }
    } else {
        if (null != node.left) {
            this.findPath(node.left, sum, val, list);
        }
        if (null != node.right) {
            this.findPath(node.right, sum, val, list);
        }
    }
    list.remove(list.size() - 1);
}
```