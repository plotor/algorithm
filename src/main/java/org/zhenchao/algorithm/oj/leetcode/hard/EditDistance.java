package org.zhenchao.algorithm.oj.leetcode.hard;

/**
 * No.72 Edit Distance
 *
 * @author zhenchao.wang 2017-06-08 21:38
 * @version 1.0.0
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 如果当前字母相同
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果当前字母不同则选择 左、左上、上 三个方向最小的
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

}
