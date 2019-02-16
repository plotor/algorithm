### Interleaving String

> No.97, hard

Given s1, s2, s3, find whether s3 is formed by the interleaving（交叉） of s1 and s2.

For example,
Given:

```
s1 = "aabcc",
s2 = "dbbca",
```

When s3 = `"aadbbcbcac"`, return true.

When s3 = `"aadbbbaccc"`, return false.

#### 分析

题目的意思是给定字符串 s1， s2， s3，判断 s3 是否是由 s1 和 s2 交叉构成的。

基于二维动态规划的思想。

#### 实现

```java
public boolean isInterleave(String s1, String s2, String s3) {
    // 如果长度上不满足则肯定不是
    if (s1.length() + s2.length() != s3.length()) return false;

    boolean[][] flag = new boolean[s1.length() + 1][s2.length() + 1];

    // 初始化二维动态规划数组
    flag[0][0] = true;
    for (int i = 1; i <= s1.length() && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
        flag[i][0] = true;
    }
    for (int i = 1; i <= s2.length() && s2.charAt(i - 1) == s3.charAt(i - 1); i++) {
        flag[0][i] = true;
    }

    for (int i = 1; i <= s1.length(); i++) {
        for (int j = 1; j <= s2.length(); j++) {
            char c = s3.charAt(i + j - 1);
            if (c == s1.charAt(i - 1) && flag[i - 1][j]) {
                flag[i][j] = true;
            } else if (c == s2.charAt(j - 1) && flag[i][j - 1]) {
                flag[i][j] = true;
            }
        }
    }
    return flag[s1.length()][s2.length()];
}
```