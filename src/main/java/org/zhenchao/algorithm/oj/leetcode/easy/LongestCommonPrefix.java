package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * No.14
 *
 * @author zhenchao.wang 2016-09-16 12:17
 * @version 1.0.0
 */
public class LongestCommonPrefix {

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

}
