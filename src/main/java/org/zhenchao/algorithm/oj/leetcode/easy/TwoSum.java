package org.zhenchao.algorithm.oj.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.1 Two Sum
 */
public class TwoSum {

    /**
     * 公共结点
     */
    class Node implements Comparable<Node> {

        int id;
        int val;

        public Node(int id, int val) {
            this.id = id;
            this.val = val;
        }

        @Override
        public int compareTo(Node other) {
            return this.val - other.val;
        }

    }

    /**
     * 采用排序策略
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        Node[] nodes = new Node[nums.length];

        // 重新构造数组
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(i, nums[i]);
        }

        // 从小到大排序
        Arrays.sort(nodes);

        int left = 0, right = nums.length - 1;

        // 查找
        int currentVal;
        while (left < right) {
            currentVal = nodes[left].val + nodes[right].val;
            //System.out.println(currentVal);
            if (currentVal == target) {
                result[0] = nodes[left].id;
                result[1] = nodes[right].id;
                return result;
            } else if (currentVal < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;

    }

    /**
     * 采用Map策略
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        int[] results = new int[2];

        // Map映射
        Map<Integer, List<Node>> nodeMap = new HashMap<Integer, List<Node>>();
        for (int i = 0; i < nums.length; i++) {
            List<Node> nodes = nodeMap.get(Integer.valueOf(nums[i]));
            if (null == nodes) {
                nodes = new ArrayList<Node>();
            }
            nodes.add(new Node(i, nums[i]));
            nodeMap.put(Integer.valueOf(nums[i]), nodes);
        }

        // 遍历寻找
        for (int i = 0; i < nums.length; i++) {
            List<Node> nodes = nodeMap.get(Integer.valueOf(target - nums[i]));
            if (null == nodes) {
                continue;
            }
            if (nodes.size() == 1) {
                Node node = nodes.get(0);
                if (node.val == nums[i]) {
                    continue;
                }
                results[0] = i;
                results[1] = node.id;
            } else {
                results[0] = i;
                results[1] = nodes.get(1).id;
            }

            return results;

        }

        return results;

    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum ts = new TwoSum();
        int[] result = ts.twoSum2(nums, target);
        System.out.println(Arrays.toString(result));
    }

}
