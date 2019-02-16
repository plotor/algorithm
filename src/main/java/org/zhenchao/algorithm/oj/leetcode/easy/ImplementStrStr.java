package org.zhenchao.algorithm.oj.leetcode.easy;

import java.util.Arrays;

/**
 * No.28 Implement strStr()
 *
 * 判断needle是不是haystack的子串，是的话就返回index，否则就返回-1
 *
 * @author zhenchao.wang 2017-04-30 17:46
 * @version 1.0.0
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle || needle.length() == 0) return 0;
        int hl = haystack.length(), nl = needle.length();
        if (nl > hl) return -1;
        // 暴力枚举
        for (int i = 0; i <= hl - nl; i++) {
            int j;
            for (j = 0; j < nl; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if (j == nl) return i;
        }
        return -1;
    }

    public int strStrWithDfa(String haystack, String needle) {
        int lenHay = haystack.length(), lenNeedle = needle.length();
        if (lenNeedle > lenHay) {
            return -1;
        }
        if (lenNeedle == 0) {
            return 0;
        }
        int[][] dfa = this.dfa(needle);
        for (int i = 0; i < dfa.length; i++) {
            System.out.println(Arrays.toString(dfa[i]));
        }
        int i, j;
        for (i = 0, j = 0; i < lenHay && j < lenNeedle; i++) {
            j = dfa[haystack.charAt(i)][j];
        }
        if (j == lenNeedle) {
            // 找到匹配（到达模式字符串的结尾）
            return i - lenNeedle;
        } else {
            // 未找到匹配（到达文本字符串的结尾）
            return -1;
        }
    }

    public int[][] dfa(String needle) {
        int M = needle.length();
        int R = 256;
        int[][] dfa = new int[R][M];
        dfa[needle.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            // 计算dfa
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[needle.charAt(j)][j] = j + 1;
            X = dfa[needle.charAt(j)][X];
        }
        return dfa;
    }

    public int strStrWithNext(String haystack, String needle) {
        int lenHay = haystack.length(), lenNeed = needle.length();
        if (lenNeed > lenHay) {
            return -1;
        }
        if (lenNeed == 0) {
            return 0;
        }
        int i = 0, j = 0;
        int[] next = this.next(needle);
        while (i < lenHay && j < lenNeed) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }
        if (j == lenNeed) {
            return i - lenNeed;
        }
        return -1;
    }

    private int[] next(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1; // 首字母的next值始终为-1
        int k = -1;
        for (int i = 1; i < needle.length(); ) {
            if (k == -1 || needle.charAt(i - 1) == needle.charAt(k)) {
                next[i] = ++k;
                i++;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        ImplementStrStr str = new ImplementStrStr();
        // String haystack = "BCBAABACAABABACAA";
        // String needle = "ABABAC";
        // String haystack = "BBC ABCDAB ABCDABCDABDE";
        // String needle = "ABCDABD";
        // Assert.assertEquals(15, str.strStr(haystack, needle));
        System.out.println(str.strStr("a", "a"));
        // System.out.println(Arrays.toString(str.next("ABCDABD")));
    }

}
