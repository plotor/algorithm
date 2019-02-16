package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.39 Combination Sum
 *
 * @author zhenchao.wang 2017-05-13 13:02
 * @version 1.0.0
 */
public class CombinationSum {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        for (int i = index; i < nums.length && nums[i] <= target; i++) {
            if (nums[i] <= target) {
                list.add(nums[i]);
                this.search(nums, i, target - nums[i], list);
            }
            // 删除无效的追加元素，继续回溯查找
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] nums = {2, 3, 6, 7};
        cs.combinationSum(nums, 7);
        System.out.println(cs.result);
    }

}
