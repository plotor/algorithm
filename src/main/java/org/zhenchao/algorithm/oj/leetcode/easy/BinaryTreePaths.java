package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 *
 * @author zhenchao.wang 2017-09-10 12:01
 * @version 1.0.0
 */
public class BinaryTreePaths {

    private List<String> result = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (null == root) return result;
        this.preOrderTraversal(root, new ArrayList<Integer>());
        return result;
    }

    private void preOrderTraversal(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if (null == node.left && null == node.right) {
            result.add(this.join(new ArrayList<Integer>(list)));
            return;
        }

        if (null != node.left) {
            this.preOrderTraversal(node.left, list);
            list.remove(list.size() - 1);
        }
        if (null != node.right) {
            this.preOrderTraversal(node.right, list);
            list.remove(list.size() - 1);
        }
    }

    private String join(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (final Integer val : list) {
            sb.append(val + "->");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public static void main(String[] args) {
        BinaryTreePaths btp = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        //root.left.left.left = new TreeNode(4);
        //root.left.left.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        List<String> paths = btp.binaryTreePaths(root);
        for (final String path : paths) {
            System.out.println(path);
        }
    }

}
