package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * No.3 Longest Substring Without Repeating Characters
 *
 * @author zhenchao.wang 2017-04-23 13:36
 * @version 1.0.0
 */
public class LongestSubstringWithoutRepeatingCharacters {

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

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("au"));
    }

}
