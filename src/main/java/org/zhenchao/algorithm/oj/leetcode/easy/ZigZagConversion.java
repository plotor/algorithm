package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * No.6
 *
 * @author zhenchao.Wang  2016-8-29 22:13:06
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        // 顺序存放下标
        int[] indexs = new int[s.length()];

        int n = 0;
        for (int i = 0; i < numRows; i++) {
            // 一行一行来
            for (int j = 0; ; j++) {
                // 计算每个列的下标值
                if (j % 2 == 0) {
                    // 偶数列
                    int index = i + (numRows - 1) * j;
                    if (index >= s.length()) {
                        break;
                    }
                    indexs[n++] = index;
                } else if (i > 0) {
                    // 奇数列
                    int index = i + (numRows - 1) * (j + 1) - 2 * i;
                    if (index >= s.length()) {
                        break;
                    }
                    if (index > indexs[n - 1]) {
                        indexs[n++] = index;
                    }
                }
            }

        }

        for (final int i : indexs) {
            sb.append(s.charAt(i));
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        ZigZagConversion zzc = new ZigZagConversion();

        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println(zzc.convert(s, numRows));

    }

}
