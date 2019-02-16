package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * No.9
 *
 * @author zhenchao.wang 2016-09-11 13:15
 * @version 1.0.0
 */
public class PalindromeNumber {

    /**
     * 负数不是回文
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {

        // 特例处理
        if (x < 0) return false;  // 负数不是回文
        if (x >= 0 && x <= 9) return true;

        // 构建除数
        int divider = 1;
        while (x / divider >= 10) divider *= 10;

        // 比对校验
        while (x > 0) {
            if (x / divider != x % 10) {
                return false;
            }
            x %= divider;
            x /= 10;
            divider /= 100;
        }

        return true;
    }

}
