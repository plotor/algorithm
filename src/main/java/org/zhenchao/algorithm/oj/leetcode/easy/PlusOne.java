package org.zhenchao.algorithm.oj.leetcode.easy;

import java.util.Arrays;

/**
 * No.66 Plus One
 *
 * @author zhenchao.wang 2017-06-05 21:07
 * @version 1.0.0
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1; // 进位
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && carry == 1) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
            }
        }
        int[] result = digits;
        if (carry == 1) {
            // 如果首位进位，则需要重新new一个长度加1的数组
            result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i <= digits.length; i++) {
                result[i] = digits[i - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] digits = {9, 9};
        System.out.println(Arrays.toString(po.plusOne(digits)));
    }

}
