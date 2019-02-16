package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * No.53 Maximum Subarray
 *
 * @author zhenchao.wang 2017-05-25 16:30
 * @version 1.0.0
 */
public class MaximumSubarray {

    /**
     * Kadane算法
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum <= 0) sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(ms.maxSubArray(nums));
    }

}
