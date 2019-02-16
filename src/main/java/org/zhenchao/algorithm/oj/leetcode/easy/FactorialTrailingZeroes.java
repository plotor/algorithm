package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * 172. Factorial Trailing Zeroes
 *
 * @author zhenchao.wang 2015-10-3 15:45:55
 * @version 1.0.0
 */
public class FactorialTrailingZeroes {

    /**
     * 求 n! 末尾 0 的个数
     * 可以将一个 0 分解为 10， 10 = 2 × 5，于是就是 min(2, 5)， 显然 5 的个数更少，所以最终就是转换成求 5 的个数
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n / 5 > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

}
