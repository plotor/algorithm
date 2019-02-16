package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * No.5 Longest Palindromic Substring
 *
 * @author zhenchao.wang 2017-04-25 20:58
 * @version 1.0.0
 */
public class LongestPalindromicSubstring {

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

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "abcda";
        System.out.println(lps.longestPalindrome(s));
    }

}
