### Longest Common Prefix

> No.14, easy

Write a function to find the longest common prefix string amongst an array of strings.

#### 分析

题目意在给定一个字符串数组，然后寻找这些字符串的最长公共前缀。

- 思路一：纵向扫描  

将所有字符串按首字母对齐，然后纵向一列列对比，当某一列出现不相同字符的时候，则该列前面所有列组成的字符串就是最长公共前缀。

- 思路二：横向扫描

横向扫描即将每一个字符串与当前最长公共前缀进行比较，然后更新当前最长公共前缀，直到所有的字符串都与之比较了一遍，则算法结束。

#### 实现

- 思路一

```java
/**
 * 纵向扫描法
 *
 * @param strs
 * @return
 */
public String longestCommonPrefixByLongitudinalScan(String[] strs) {

    if (null == strs || strs.length == 0 || strs[0].length() == 0) {
        return "";
    }

    if (strs.length == 1) {
        return strs[0];
    }

    StringBuilder prefix = new StringBuilder();
    int n = 0;
    while (true) {
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() == 0 ||
                    strs[i - 1].length() == n || strs[i].length() == n ||
                    strs[i - 1].charAt(n) != strs[i].charAt(n)) {
                return prefix.toString();
            }
        }
        prefix.append(strs[0].charAt(n++));
    }
}
```

- 思路二

```java
/**
 * 横向扫描法
 *
 * @param strs
 * @return
 */
public String longestCommonPrefixByTransverseScan(String[] strs) {
    if (null == strs || strs.length == 0) {
        return "";
    }

    if (strs.length == 1) {
        return strs[0];
    }

    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < prefix.length() && j < strs[i].length(); j++) {
            if (prefix.charAt(j) != strs[i].charAt(j)) {
                prefix = sb.toString();
                break;
            }
            sb.append(prefix.charAt(j));
        }
        // 处理str[i]正好是最长公共前缀的情况
        prefix = prefix.length() > strs[i].length() ? strs[i] : prefix;

    }
    return prefix;
}
```