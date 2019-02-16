package org.zhenchao.algorithm.oj.leetcode.easy;

import java.util.Arrays;

/**
 * 169. Majority Element
 *
 * @author zhenchao.wang 2017-09-16 14:53
 * @version 1.0.0
 */
public class MajorityElement {

    /**
     * 解法一：直接对数组进行排序，然后选择最中间的数字
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 解法二：投票法
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0, result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count++;
            } else if (result == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = {1};
        System.out.println(me.majorityElement(nums));
    }

}
