package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 *
 * @author zhenchao.wang 2017-09-23 10:36
 * @version 1.0.0
 */
public class BinaryTreeRightSideView {

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

    public static void main(String[] args) {
        BinaryTreeRightSideView view = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        //root.left.left.left = new TreeNode(4);
        //root.left.left.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        List<Integer> list = view.rightSideView(root);
        System.out.println(list);
    }

}
