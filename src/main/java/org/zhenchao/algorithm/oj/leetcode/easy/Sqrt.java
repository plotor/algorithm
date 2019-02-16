package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * 69. Sqrt(x)
 *
 * @author zhenchao.wang 2017-11-11 10:30
 * @version 1.0.0
 */
public class Sqrt {

    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            long mid = (left + right) / 2; // mid可能会溢出，需要用long型
            long sq = mid * mid;
            if (sq == x) {
                return (int) mid;
            } else if (sq < x) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        // 这里一定要返回right
        return right;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(2147395599));
    }

}
