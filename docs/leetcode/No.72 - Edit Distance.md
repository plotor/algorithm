### Edit Distance

> No.72, hard

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

1. Insert a character
2. Delete a character
3. Replace a character

#### 分析

题目的意思是给定两个字符串 word1 和 word2，找出将 1 转换成 2 的最小步骤数。这道题目可以采用二维动态规划来解答，假设 1 的长度为 l1，2 的长度为 l2，则可以定义一个大小为 dp[l1][l2] 的数组，初始化：

> - dp[i][0] = i;
> - dp[0][i] = i;

核心计算逻辑伪代码：

```java
if (字符串当前位置字符相同) {
    // 如果当前字母相同
    dp[i][j] = dp[i - 1][j - 1];
} else {
    // 如果当前字母不同则选择 左、左上、上 三个方向最小的
    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
}
```

#### 实现

```java
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
```
