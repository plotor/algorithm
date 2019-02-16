package org.zhenchao.algorithm.oj.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 *
 * @author zhenchao.wang 2017-09-23 12:08
 * @version 1.0.0
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (true) {
            if (1 == n) return true;
            if (set.contains(n)) return false;
            set.add(n);
            n = this.sum(n);
        }
    }

    private int sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += Math.pow(num % 10, 2);
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(7));
    }

}
