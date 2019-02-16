package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * No.16 Three Sum Closest
 *
 * @author zhenchao.wang 2017-04-28 17:54
 * @version 1.0.0
 */
public class ThreeSumClosest {

    /**
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tSum = nums[left] + nums[right] + nums[i];
                int tClosest = Math.abs(target - tSum);
                if (tSum == target) {
                    // 找到相等的，直接返回
                    return tSum;
                } else if (tSum > target) {
                    right--;
                } else {
                    left++;
                }
                if (tClosest < closest) {
                    sum = tSum;
                    closest = tClosest;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        // int[] nums = {-1, 2, 1, -4};
        // int[] nums = {0, 0, 0};
        // int[] nums = {1, 1, 1, 1};
        int[] nums = {1, 2, 5, 10, 11};
        System.out.println(tsc.threeSumClosest(nums, 12));
    }

}
