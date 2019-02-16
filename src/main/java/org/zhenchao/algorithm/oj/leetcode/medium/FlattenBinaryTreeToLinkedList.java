package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeNode;
import org.zhenchao.algorithm.util.TreeNodeUtils;

import java.util.List;
import java.util.Stack;

/**
 * 114. Flatten Binary Tree to Linked List
 *
 * @author zhenchao.wang 2017-08-05 09:26
 * @version 1.0.0
 */
public class FlattenBinaryTreeToLinkedList {

    /**
     * 非递归先序遍历
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (null == root) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode index = null;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (null != pop.right) stack.push(pop.right);
            if (null != pop.left) stack.push(pop.left);
            pop.left = null; // 注意：需要砍掉这些节点的左分支
            if (pop == root) {
                index = pop;
                continue;
            }
            index.right = pop;
            index = index.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        root.left = l1;
        /*TreeNode r1 = new TreeNode(5);
        root.left = l1; root.right = r1;
        TreeNode ll2 = new TreeNode(3);
        TreeNode lr2 = new TreeNode(4);
        l1.left = ll2; l1.right = lr2;
        TreeNode rr2 = new TreeNode(6);
        r1.right = rr2;*/

        List<Integer> list = TreeNodeUtils.preorderTraversal(root);
        System.out.println(list);

        FlattenBinaryTreeToLinkedList fbt = new FlattenBinaryTreeToLinkedList();
        fbt.flatten(root);
        while (null != root) {
            System.out.print(root.val + ", ");
            root = root.right;
        }

    }

}
