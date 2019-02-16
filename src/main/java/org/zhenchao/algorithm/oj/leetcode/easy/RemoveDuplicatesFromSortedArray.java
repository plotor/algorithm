package org.zhenchao.algorithm.oj.leetcode.easy;

import java.util.Arrays;

/**
 * No.26
 *
 * @author zhenchao.wang 2016-10-15 10:03
 * @version 1.0.0
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int index = 0;  // 兼记录当前最新发现的不重复元素的个数和目标位置
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();
        int[] a = {1};
        System.out.println(rd.removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }

}
