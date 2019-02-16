package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No.46 Permutations
 *
 * @author zhenchao.wang 2017-05-24 17:40
 * @version 1.0.0
 */
public class Permutations {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        this.recursion(nums, visited, new ArrayList<Integer>());
        return result;
    }

    private void recursion(int[] nums, int[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            // Arrays.fill(visited, 0);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
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
        Permutations p = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = p.permute(nums);
        for (final List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
