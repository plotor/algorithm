package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * No.63 Unique Paths II
 *
 * @author zhenchao.wang 2017-06-04 15:36
 * @version 1.0.0
 */
public class UniquePathsII {

    /**
     * 思路同UniquePaths，只是遇到障碍时，需要将对应的值设为0
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int num = 1 - obstacleGrid[0][0];
        for (int i = 0; i < m; i++) {
            // 如果只有一列，有障碍就到达不到终点，所以障碍之后的值都是0
            num = 0 == num ? 0 : 1 - obstacleGrid[i][0];
            dp[i][0] = num;
        }
        num = 1 - obstacleGrid[0][0];
        for (int i = 0; i < n; i++) {
            // 如果只有一行，有障碍就到达不到终点，所以障碍之后的值都是0
            num = 0 == num ? 0 : 1 - obstacleGrid[0][i];
            dp[0][i] = num;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 障碍的位置置为0，其余与UniquePaths计算方式相同
                dp[i][j] = 1 == obstacleGrid[i][j] ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII up = new UniquePathsII();
        int[][] obstacleGrid = {{0}};
        System.out.println(up.uniquePathsWithObstacles(obstacleGrid));
    }

}
