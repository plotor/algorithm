package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.15 Three Sum
 *
 * @author zhenchao.wang 2017-04-27 17:51
 * @version 1.0.0
 */
public class ThreeSum {

    /**
     * Two Sum
     *
     * @param nums
     * @param start
     * @param target
     * @return
     */
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int value = nums[left] + nums[right];
            if (value < target) {
                left++;
            } else if (value > target) {
                right--;
            } else {
                list.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                // 去重
                while (left < right && nums[left] == nums[left - 1]) left++;

                right--;
                // 去重
                while (left < right && nums[right] == nums[right + 1]) right--;
            }
        }
        return list;
    }

    /**
     * 基于 Two Sum 解 Three Sum
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (null == nums || nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int pre = nums[0];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == pre) {
                // 去重
                continue;
            }
            pre = nums[i];
            List<List<Integer>> inner = this.twoSum(nums, i + 1, -nums[i]);
            if (inner.size() > 0) {
                list.addAll(inner);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        // int[] nums = {-1, 0, 1, 2, -1, -4};
        // int[] nums = {-2, 0, 0, 2, 2};
        int[] nums = {0, 0, 0};
        System.out.println(ts.threeSum(nums));
    }

}
