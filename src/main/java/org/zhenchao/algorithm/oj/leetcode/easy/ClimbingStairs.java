package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * No.70 - Climbing Stairs
 *
 * @author zhenchao.wang 2017-06-06 20:17
 * @version 1.0.0
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(1));
    }

}
