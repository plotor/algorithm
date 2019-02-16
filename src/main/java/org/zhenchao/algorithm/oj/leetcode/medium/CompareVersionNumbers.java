package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * 165. Compare Version Numbers
 *
 * @author zhenchao.wang 2017-09-10 12:42
 * @version 1.0.0
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        if (null == version1 || version1.length() == 0
            || null == version2 || version2.length() == 0) {
            return 0;
        }
        String[] items1 = version1.split("\\.");
        String[] items2 = version2.split("\\.");
        int len = Math.max(items1.length, items2.length);
        for (int i = 0; i < len; i++) {
            if (i < items1.length && i < items2.length) {
                int v1 = Integer.parseInt(items1[i]);
                int v2 = Integer.parseInt(items2[i]);
                if (v1 > v2) {
                    return 1;
                } else if (v2 > v1) return -1;
            } else if (i < items1.length) {
                if (Integer.parseInt(items1[i]) > 0) return 1;
            } else if (i < items2.length) {
                if (Integer.parseInt(items2[i]) > 0) return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers cvn = new CompareVersionNumbers();
        System.out.println(cvn.compareVersion("1.2.1", "1.2.0.1"));
    }

}
