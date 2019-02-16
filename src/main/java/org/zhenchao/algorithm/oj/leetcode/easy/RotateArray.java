package org.zhenchao.algorithm.oj.leetcode.easy;

import java.util.Arrays;

/**
 * 189. Rotate Array
 *
 * @author zhenchao.wang 2017-09-16 16:34
 * @version 1.0.0
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (null == nums || nums.length == 0) return;
        k = Math.abs(k % nums.length);
        // 先整体逆置，再局部逆置
        this.reverse(nums, 0, nums.length - 1);
        this.reverse(nums, 0, k - 1);
        this.reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = {1, 2};
        ra.rotate(nums, 0);
        System.out.println(Arrays.toString(nums));
    }

}
