package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.40 Combination Sum II
 *
 * @author zhenchao.wang 2017-05-14 15:28
 * @version 1.0.0
 */
public class CombinationSumII {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先对数组排序
        Arrays.sort(candidates);
        // 递归查找
        this.search(candidates, 0, target, new ArrayList<Integer>());
        return result;
    }

    public void search(int[] nums, int index, int target, List<Integer> list) {
        if (target == 0) {
            // 找到一个组合
            result.add(new ArrayList<Integer>(list));
            return;
        }
        int pre = -1; // 记录前一个元素
        for (int i = index; i < nums.length && nums[i] <= target; i++) {
            // 如果当前元素与之前的相同，则跳过
            if (nums[i] <= target && pre != nums[i]) {
                list.add(nums[i]);
                this.search(nums, i + 1, target - nums[i], list);
                // 删除无效的追加元素，继续回溯查找
                list.remove(list.size() - 1);
                pre = nums[i];
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII cs2 = new CombinationSumII();
        // int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int[] nums = {2, 2, 2};
        // int[] nums = {4, 4, 2, 1, 4, 2, 2, 1, 3};
        System.out.println(cs2.combinationSum2(nums, 4));
    }

}
