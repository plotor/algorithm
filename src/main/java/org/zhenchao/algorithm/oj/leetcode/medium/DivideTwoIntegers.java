package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * No.29 Divide Two Integers
 *
 * @author zhenchao.wang 2017-05-02 21:24
 * @version 1.0.0
 */
public class DivideTwoIntegers {

    /**
     * 不能使用乘、除，取模
     *
     * @param dividend 被除数
     * @param divisor 除数
     * @return
     */
    public int divide(int dividend, int divisor) {

        if (dividend == 0 || divisor == 0) return 0;

        // 题目规定溢出时返回MAX_INT
        if (Integer.MIN_VALUE == dividend && divisor == -1) return Integer.MAX_VALUE;

        // 将所有的数字都转成正数进行操作，最后再处理符号
        long dd = dividend, dr = divisor;  // 防止溢出，转成long型操作
        boolean isNag = false;
        if (dd < 0) {
            isNag = !isNag;
            dd = -dd;
        }
        if (dr < 0) {
            isNag = !isNag;
            dr = -dr;
        }
        if (dr > dd) {
            return 0;
        }

        int result = 0;
        while (dd >= dr) {
            long d = dr, x = 0;
            while (dd >= d) {
                dd -= d;
                result += 1 << x++; // 每次减去的除数数量都是上次的一倍
                d = d << 1;  // 除数加倍
            }
        }
        return isNag ? -result : result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers dti = new DivideTwoIntegers();
        System.out.println(dti.divide(-2147483648, -1));
        // System.out.println(Integer.MIN_VALUE);
    }

}
