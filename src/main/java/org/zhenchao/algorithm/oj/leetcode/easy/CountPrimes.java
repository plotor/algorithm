package org.zhenchao.algorithm.oj.leetcode.easy;

import java.util.Arrays;

/**
 * 204. Count Primes
 *
 * @author zhenchao.wang 2017-09-23 12:45
 * @version 1.0.0
 */
public class CountPrimes {

    /**
     * 基于埃拉托斯特尼筛法
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] mask = new boolean[n];
        Arrays.fill(mask, true);
        for (int i = 2; i < n; i++) {
            if (!mask[i]) {
                continue;
            }
            for (int j = i * 2; j < n; j += i) {
                mask[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (mask[i]) count++;
        }
        return count;
    }

}
