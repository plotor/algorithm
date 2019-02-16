package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 *
 * @author zhenchao.wang 2017-7-29 21:56:28
 * @version 1.0.0
 */
public class PathSumII {

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(8);
        root.left = l1;
        root.right = r1;
        TreeNode ll2 = new TreeNode(11);
        l1.left = ll2;
        TreeNode rl2 = new TreeNode(13);
        TreeNode rr2 = new TreeNode(4);
        r1.left = rl2;
        r1.right = rr2;
        TreeNode lll3 = new TreeNode(7);
        TreeNode llr3 = new TreeNode(2);
        ll2.left = lll3;
        ll2.right = llr3;
        TreeNode rrl3 = new TreeNode(5);
        TreeNode rrr3 = new TreeNode(1);
        rr2.left = rrl3;
        rr2.right = rrr3;
        PathSumII pathSumII = new PathSumII();
        pathSumII.pathSum(root, 22);
        List<List<Integer>> list = pathSumII.result;
        for (final List<Integer> li : list) {
            System.out.println(li);
        }
    }

}
