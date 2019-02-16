package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * No.62 Unique Paths
 *
 * @author zhenchao.wang 2017-06-01 21:28
 * @version 1.0.0
 */
public class UniquePaths {

    /**
     * 动态规划
     *
     * @param m
     * @param n
     * @return
     */
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

    /*基于递归会超时*/

    private int count = 0;

    public int uniquePaths2(int m, int n) {
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], 0);
        }
        this.recursion(visited, 0, 0);
        return count;
    }

    private void recursion(int[][] visited, int i, int j) {
        if (i == (visited.length - 1) && (j == visited[0].length - 1)) {
            count++;
            return;
        }
        visited[i][j] = 1;
        if (j < (visited[0].length - 1) && visited[i][j + 1] == 0) {
            this.recursion(visited, i, j + 1);
            visited[i][j + 1] = 0;
        }
        if (i < (visited.length - 1) && visited[i + 1][j] == 0) {
            this.recursion(visited, i + 1, j);
            visited[i + 1][j] = 0;
        }
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(100, 100));
    }

}
