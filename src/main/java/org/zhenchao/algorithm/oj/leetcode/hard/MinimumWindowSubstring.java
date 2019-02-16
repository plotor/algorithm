package org.zhenchao.algorithm.oj.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * No.76 - Minimum Window Substring
 *
 * @author zhenchao.wang 2017-06-14 07:43
 * @version 1.0.0
 */
public class MinimumWindowSubstring {

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

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow("ABC", "C"));
    }

}
