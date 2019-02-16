package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * No.8
 *
 * @author zhenchao.wang 2016-09-10 16:06
 * @version 1.0.0
 */
public class StringToInteger {

    /**
     * 主要考虑如下几种情况：
     * 1.忽略首尾的空字符
     * 2.以唯一一个“+”或“-”开头的视为正常情况
     * 3.内部若有非数字字符，直接break
     * 4.越界
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (null == str || str.matches("^\\s*$")) {
            return 0;
        }

        /*
         * 预处理
         */
        str = str.trim();
        boolean isNeg;
        if (str.startsWith("+")) {
            isNeg = false;
            str = str.substring(1);
        } else if (str.startsWith("-")) {
            isNeg = true;
            str = str.substring(1);
        } else {
            isNeg = false;
        }

        long l = 0;  // long即可，检测到整数越界直接break
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if (s.matches("[0-9]") && l <= Integer.MAX_VALUE) {
                l = l * 10 + Long.parseLong(s);
            } else {
                break;
            }
        }

        l = isNeg ? -l : l;
        int result;
        if (isNeg) {
            result = l < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) l;
        } else {
            result = l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) l;
        }

        return result;
    }

}
