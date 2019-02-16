package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * 152. Maximum Product Subarray
 *
 * @author zhenchao.wang 2017-09-02 13:22
 * @version 1.0.0
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int[] max = new int[nums.length], min = new int[nums.length];
        int result = max[0] = min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println(mps.maxProduct(nums));
    }

}
