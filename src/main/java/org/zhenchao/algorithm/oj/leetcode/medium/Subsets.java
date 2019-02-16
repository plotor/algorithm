package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No.78 - Subsets
 *
 * @author zhenchao.wang 2017-06-16 08:02
 * @version 1.0.0
 */
public class Subsets {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<Integer>());
        for (int i = 1; i <= nums.length; i++) {
            this.recursion(new ArrayList<Integer>(), 0, nums, i);
        }
        return result;
    }

    private void recursion(List<Integer> list, int start, int[] nums, int k) {
        if (k == list.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            this.recursion(list, i + 1, nums, k);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        s.subsets(new int[] {1});
        for (final List<Integer> list : s.result) {
            System.out.println(list);
        }
    }

}
