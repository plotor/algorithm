package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * No.43 Multiply Strings
 *
 * @author zhenchao.wang 2017-05-17 21:28
 * @version 1.0.0
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int length = num1.length() + num2.length();
        int[] sum = new int[length];
        Arrays.fill(sum, 0);
        // 这里的逻辑就是日常笔算陈法的过程
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                sum[i + j + 1] += (num1.charAt(i) - 48) * (num2.charAt(j) - 48);
            }
        }

        // System.out.println(Arrays.toString(sum));
        // 处理进位
        int carry = 0;
        for (int i = length - 1; i >= 0; i--) {
            sum[i] += carry;
            carry = sum[i] / 10;
            sum[i] %= 10;
        }

        // 去掉开头的0
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (sum[i] == 0 && !flag) {
                continue;
            }
            sb.append(sum[i]);
            flag = true;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("1", "758"));
    }

}
