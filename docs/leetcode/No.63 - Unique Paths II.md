### Unique Paths II

> No.63, medium

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

```
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
```

The total number of unique paths is 2.

Note: m and n will be at most 100.

#### 分析

题目相对于 I 的区别在矩阵中增加了障碍，所以针对障碍需要专门处理：

> 1. 如果只有一行，那么中间出现障碍，障碍之后的值都应该是 0
> 2. 如果只有一列，那么中间出现障碍，障碍之后的值都应该是 0
> 3. 其余情况，如果出现障碍，障碍所在位置的值应该是 0

#### 实现

```java
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
```