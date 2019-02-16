package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * No.80 Remove Duplicates from Sorted Array II
 *
 * @author zhenchao.wang 2017-06-18 14:56
 * @version 1.0.0
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (null == nums) return 0;
        if (nums.length <= 2) return nums.length;
        int pre = nums[0], count = 1, length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                if (count < 2) {
                    length++;
                    count++;
                }
            } else {
                pre = nums[i];
                count = 1;
                length++;
            }
            if (i >= length) {
                int tmp = nums[length - 1];
                nums[length - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII rds = new RemoveDuplicatesFromSortedArrayII();
        int[] nums = {1, 2, 2, 3, 3};
        System.out.println(rds.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

}
