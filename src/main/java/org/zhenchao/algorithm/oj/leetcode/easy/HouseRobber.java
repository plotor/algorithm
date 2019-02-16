package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * 198. House Robber
 *
 * @author zhenchao.wang 2017-09-16 16:53
 * @version 1.0.0
 */
public class HouseRobber {

    /**
     * 动态规划
     * dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(result[i - 2] + nums[i], result[i - 1]);
        }
        return result[nums.length - 1];
    }

}
