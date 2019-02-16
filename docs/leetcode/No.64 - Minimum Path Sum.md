### Minimum Path Sum

> No.64, medium

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

#### 分析

题目的意思是给定一个二维的矩阵，每一格都包含一个非负数，求出从左上角到右下角最小的路径和。

这个题目还是采用二维动态规划的思想，思想上与 Unique Paths 相同，采用一个二维数组 dp 记录到当前位置的最小路径值，初始化：

> - dp[i][0] = dp[i - 1][0] + grid[i][0];
> - dp[0][i] = dp[0][i - 1] + grid[0][i];

动态规划公式：dp[i][j] = Min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];

#### 实现

```java
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
```