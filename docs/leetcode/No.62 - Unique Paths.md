### Unique Paths

> No.62, medium

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

![image](https://github.com/procyon-lotor/procyon-lotor.github.io/blob/master/images/2016/robot_maze.png?raw=false)

How many possible unique paths are there?

Note: m and n will be at most 100.

#### 分析

题目的意思是给定一个二维数组，规定只能向右和向下走，计算从起点（左上角）到终点（右下角）的走法的总数。一开始想到用递归来实现，发现超时，这个题目需要用到动态规划，思想如下：

定义一个二维数组 `int[][] dp = new int[m][n]` 如果输入的数组只有一行，则 `dp[0][i] = 1`，如果输入的数组只有一列，则 `dp[i][0] = 1`，因为在这种情况下，从起点到终点要么全部横着走，要么全部竖着走，所以只有一种走法，然后 `dp[i][j] = dp[i-1][j] + dp[i][j-1]`。

#### 实现

```java
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
        // 如果只有一列，则到终点只有一种走法
        dp[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
        // 如果只有一行，则到终点只有一种走法
        dp[0][i] = 1;
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }
    return dp[m - 1][n - 1];
}
```