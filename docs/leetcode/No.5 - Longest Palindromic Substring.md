### Longest Palindromic Substring

> No.5, meidum

Given a string _s_, find the longest palindromic substring in _s_. You may assume that the maximum length of _s_ is 1000.

Example:

```
Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
```

Example:

```
Input: "cbbd"

Output: "bb"
```

#### 分析

题目要求一个字符串的最长回文子字符串。

- 思路一

这是一道经典的 __动态规划__ 题目，《算法导论》上的例题，动态规划的核心思想如下：

假设 `p[i, j]` 表示第 i 到 j 的字符串满足回文子串，则有：

> P[i, j] = P[i + 1, j - 1] ∩ Si == Sj

所以我们可以定义一个 bool 型的二维数组，true 表示 i, j 之间对应的子串是回文的，false 则不是，如下图，1 表示 true，0 表示 false，`p[i, i]`, `p[i, i+ 1]` 的值是可以事先确定，即图中斜对角线中值，当这些值确定之后，我们就可以利用前面给的公式，按照图中红色箭头的指向，从上到下，从左到右，依次计算每个格子对应数值，当上三角区域所有的位置全部计算完毕之后，如果某一行中两个 1 之间的距离最大，那么这两个格子的坐标可以确定最长回文。

![image](https://github.com/procyon-lotor/procyon-lotor.github.io/blob/master/images/2017/20170425221455.png?raw=false)

- 思路二

假设有一个字符串 A，可以将其逆置，得到字符串 B，然后可以利用 __求最长公共子串的思想__ 求解 A 和 B 的最长公共子串，其结果就是对应的最长回文子串，如下图。

求解 __最长公共子序列__ 和 __最长公共子串__ 的思路是一样的，差别只是在最后遍历得到的二维数组的时候，最后我们只需要找斜线上连续的斜箭头（图中红色箭头）最长的一条对应的就是最长公共子串，而最长公共子序列需要从右下角最后一个元素开始，按照箭头的方向依次向前遍历，遇到斜箭头就记录，最后得到最长公共子序列。

![image](https://github.com/procyon-lotor/procyon-lotor.github.io/blob/master/images/2017/20170425221632.png?raw=false)

#### 实现

- 思路一

```java
/**
 * 动态规划法
 *
 * @param s
 * @return
 */
public String longestPalindrome(String s) {
    if (null == s || s.length() == 0) {
        return "";
    }
    if (s.length() == 1) {
        return s;
    }

    int length = s.length();
    boolean[][] flag = new boolean[length][length];
    // 初始化数组
    for (int i = 0; i < length; i++) {
        flag[i][i] = true;
        if (i + 1 == length) {
            continue;
        }
        flag[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
    }

    // 按照动态规划公式来计算
    for (int j = 2; j < length; j++) {
        for (int i = 0; i < j - 1; i++) {
            flag[i][j] = flag[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
        }
    }

    // 寻找标记数组中横向间隔最大的两个坐标
    int left = 0, right = -1;
    for (int i = 0; i < length; i++) {
        for (int j = length - 1; j > i; j--) {
            if (flag[i][j]) {
                if (j - i > right - left) {
                    left = i;
                    right = j;
                }
                break;
            }
        }
    }
    // 如果不存在回文，则返回第一个字符
    return -1 == right ? String.valueOf(s.charAt(0)) : s.substring(left, right + 1);
}
```

- 思路二

```java
// 略
```
