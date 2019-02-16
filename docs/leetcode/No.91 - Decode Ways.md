### Decode Ways

> No.91, medium

A message containing letters from A-Z is being encoded to numbers using the following mapping:

```
'A' -> 1
'B' -> 2
...
'Z' -> 26
```

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,

Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

#### 分析

对于 0 的处理不是很理解。

#### 实现

```java
/**
 * 动态规划
 *
 * @param s
 * @return
 */
public int numDecodings(String s) {
    if (null == s || "".equals(s)) return 0;
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = this.isValid(s.substring(0, 1)) ? 1 : 0;

    for (int i = 2; i <= s.length(); i++) {
        if (this.isValid(s.substring(i - 1, i))) dp[i] += dp[i - 1];
        if (this.isValid(s.substring(i - 2, i))) dp[i] += dp[i - 2];
    }
    return dp[s.length()];
}

private boolean isValid(String s) {
    if (s.charAt(0) == '0') return false;
    int iv = Integer.parseInt(s);
    return iv >= 1 && iv <= 26;
}
```