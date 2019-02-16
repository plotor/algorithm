package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * No.64 Minimum Path Sum
 *
 * @author zhenchao.wang 2017-06-04 16:04
 * @version 1.0.0
 */
public class MinimumPathSum {

    /**
     * 还是利用动态规划的思想，不需要用最小生成树
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            // 只有一列
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            // 只有一行
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

}
