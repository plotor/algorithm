### Longest Substring Without Repeating Characters

> No.3, medium

Given a string, find the length of the longest substring without repeating characters.

__Examples:__

Given `"abcabcbb"`, the answer is `"abc"`, which the length is 3.

Given `"bbbbb"`, the answer is `"b"`, with the length of 1.

Given `"pwwkew"`, the answer is `"wke"`, with the length of 3.

Note that the answer must be a substring, `"pwke"` is a subsequence and not a substring.

#### 分析

题目的意思简单的说就是 __求不包含重复字符的最长子字符串（非子序列）的长度__，对于该题，如果用一个集合去存储已经访问过的字符串，需要考虑许多边界问题，不建议这样做。

我们可以借鉴 KMP 算法的思路，考虑一个基本原则，__如果一个字符串具有重复字符，那么包含它的父串也必然包含重复字符__，所以我们可以从左边开始扫描，当遇到一个重复字符时，就回退到该字符上次出现位置 `+1` 处开始新的扫描。

#### 实现

```java
/**
 * 借鉴KMP算法的思想，从左往右扫描，当遇到重复字符时，就从上次出现该字符位置+1处开始新的扫描
 *
 * @param s
 * @return
 */
public int lengthOfLongestSubstring(String s) {
    if (null == s || s.length() == 0) {
        return 0;
    }

    int[] last = new int[128]; // 存放某个字符最近一次出现的位置，以字符的ascii值作为下标
    Arrays.fill(last, -1); // 将数组初始化为 -1
    int start = 0, max = 0;
    // 从左边开始往右边扫描
    for (int i = start; i < s.length(); i++) {
        if (last[s.charAt(i)] >= start) {
            /*
             * 当前字符上次出现的位置在[start, 当前]范围之内，说明是重复字符串
             * 比较区间长度是否大于之前的最大值，同时将start置为新的值
             */
            max = Math.max(max, i - start);
            start = last[s.charAt(i)] + 1; // 将start置为重复位置+1，继续开始
        }
        // 更新位置值
        last[s.charAt(i)] = i;
    }

    // 如果最后一次扫描中的区间长度更大，会因为没有进入if语句而丢失，在这里进行弥补
    return Math.max(max, s.length() - start);
}
```
