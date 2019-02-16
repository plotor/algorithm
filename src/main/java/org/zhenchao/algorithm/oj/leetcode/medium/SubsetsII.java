package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 *
 * @author zhenchao.wang 2017-06-25 22:35
 * @version 1.0.0
 */
public class SubsetsII {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);  // 输入不一定有序
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
            // 相对于1，只需要添加下面一行
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }

    public static void main(String[] args) {
        SubsetsII s = new SubsetsII();
        s.subsetsWithDup(new int[] {2, 2, 2, 1, 2});
        for (final List<Integer> list : s.result) {
            System.out.println(list);
        }
    }

}
