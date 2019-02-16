package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * No.7
 *
 * @author zhenchao.wang 2016-09-04 11:00
 * @version 1.0.0
 */
public class ReverseInteger {

    /**
     * 题目没有明说，但是当出现越界情况的时候，返回0
     *
     * @param x
     * @return
     */
    public int reverse(int x) {

        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) {
            return 0;
        }

        long lx = x;  // 考虑越界情况，先转换成long再说

        // 先统一转换成非负数处理
        boolean isNeg = lx < 0 ? true : false;
        lx = isNeg ? -lx : lx;

        long reverse = 0;
        while (lx != 0) {
            long n = lx % 10;
            reverse = reverse * 10 + n;
            lx /= 10;
        }

        if (isNeg) {
            reverse = -reverse < Integer.MIN_VALUE ? 0 : -reverse;
        } else {
            reverse = reverse > Integer.MAX_VALUE ? 0 : reverse;
        }

        return (int) reverse;

    }

    public static void main(String[] args) {

        ReverseInteger ri = new ReverseInteger();

        //System.out.println(Integer.MAX_VALUE + "\t" + Integer.MIN_VALUE);
        System.out.println(ri.reverse(-2147483648));

    }

}
