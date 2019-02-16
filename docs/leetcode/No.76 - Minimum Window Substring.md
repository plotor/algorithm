### Minimum Window Substring

> No.76, hard

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,

```
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".
```

Note:  
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

#### 分析

题目的意思是给定一个字符串 S 和 T，从 S 中找出包含 T 中所有字符的长度最小的子字符串，如果不存在则返回空字符串。

这个题目还是比较难的，解题的基本思想是利用一个 map 记录 T 中各个字符的个数，其目的是记录当前各类字符还剩余多少个没有处于窗口内，然后用两个指针，pre 始终指向当前窗口的最左端，i 用来遍历字符串，遇到不是目标字符串中的字符则直接跳过，如果是目标字符串中的字符，但是当前还有未进入窗口的字符，则 i 继续向前扩大窗口，否则就开始缩小窗口，即 pre 开始往右移动，pre 向右移动的过程中，如果指向的字符不是目标字符，则直接扔出窗外，如果是目标字符，则需要反映到 map 中，表示当前有目标字符出窗口。

#### 实现

```java
public String minWindow(String s, String t) {
    String result = "";
    if (null == s || null == t || 0 == t.length() || s.length() < t.length()) return result;

    // map用于记录当前不在窗口中的各个字符的数目
    Map<Character, Integer> map = new HashMap<Character, Integer>(t.length());
    for (int i = 0; i < t.length(); i++) {
        map.put(t.charAt(i), map.containsKey(t.charAt(i)) ? map.get(t.charAt(i)) + 1 : 1);
    }

    int pre = 0, len = 0, min = s.length() + 1;
    for (int i = 0; i < s.length(); i++) {
        char curr = s.charAt(i);
        // 如果不是目标字符，则暂时先入窗口
        if (!map.containsKey(curr)) continue;

        /*只有当前字符是目标字符时才进行处理*/

        // 当前是目标字符，入窗口
        map.put(curr, map.get(curr) - 1);
        if (map.get(curr) >= 0) len++;

        // 当前字符串已经包含了所有目标字符
        while (len == t.length()) {
            // 当前pre位置不是目标字符，直接扔出窗口
            if (!map.containsKey(s.charAt(pre))) {
                pre++;
                continue;
            }

            // 当前pre位置是目标字符，扔出窗口之前检查当前是否是包含所有目标字符的最短字符
            map.put(s.charAt(pre), map.get(s.charAt(pre)) + 1);
            if (map.get(s.charAt(pre)) > 0) {
                if (min > i - pre + 1) {
                    min = i - pre + 1;
                    result = s.substring(pre, i + 1);
                }
                len--;
            }
            pre++;
        }
    }
    return result;
}
```