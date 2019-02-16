### Climbing Stairs

> No.70, easy

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

#### 解析

属于经典的题目，爬楼梯，一次只能走 1 格或 2 格，问有多少种走法可以达到顶端。

典型的一维动态规划题目，因为只能走 1 格或 2 格，所以第 n 格可以由第 n - 1 跨一步到达，也可以由 n - 2 格跨两步到达，所以可以总结出：

> dp[n] = dp[n-1] + dp[n-2]

我们可以计算出 dp[0] = 1, dp[1] = 2，所以最终的结果不难推导出。

#### 实现

```java
public int climbStairs(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;

    int[] dp = new int[n];
    dp[0] = 1; dp[1] = 2;
    for (int i = 2; i < n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n - 1];
}
```