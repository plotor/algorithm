package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * 136. Single Number
 *
 * @author zhenchao.wang 2017-08-13 12:11
 * @version 1.0.0
 */
public class SingleNumber {

    /**
     * 采用异或的思想，因为：
     * 1. 任何两个相同的数字异或结果都是0
     * 2. 0与任何数字异或都等于该数字
     * 3. 异或满足交换律
     *
     * 交换律 A XOR B = B XOR A
     * 结合律 A XOR B XOR C = A XOR (B XOR C) = (A XOR B) XOR C
     * 自反性 A XOR B XOR B = A XOR 0 = A
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
