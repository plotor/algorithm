package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.47 Permutations II
 *
 * @author zhenchao.wang 2017-05-24 18:11
 * @version 1.0.0
 */
public class PermutationsII {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);  // 排序
        int[] visited = new int[nums.length];
        this.recursion(nums, visited, new ArrayList<Integer>());
        return result;
    }

    private void recursion(int[] nums, int[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1] == 0) continue; // 去重
            if (visited[i] == 0) {
                list.add(nums[i]);
                visited[i] = 1;
                this.recursion(nums, visited, list);
                list.remove(list.size() - 1);
                visited[i] = 0;
            }
        }

    }

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = p.permuteUnique(nums);
        for (final List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
