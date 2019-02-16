package org.zhenchao.algorithm.oj.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * No.30 Substring with Concatenation of All Words
 *
 * @author zhenchao.wang 2017-05-03 21:44
 * @version 1.0.0
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            list.add(this.strStr(s, words[i]));
        }
        return list;
    }

    public int strStr(String haystack, String needle) {
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
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        SubstringWithConcatenationOfAllWords scw = new SubstringWithConcatenationOfAllWords();
        System.out.println(scw.findSubstring(s, words));
    }

}
