package org.zhenchao.algorithm.oj.leetcode.medium;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;

/**
 * No.75 Sort Colors
 *
 * @author zhenchao.wang 2017-06-13 20:51
 * @version 1.0.0
 */
public class SortColors {

    public void sortColors(int[] nums) {
        // if (null == nums || 0 == nums.length || 1 == nums.length) return;
        int l = 0, index = l, r = nums.length - 1;
        while (index <= r) {
            while (l < r && nums[l] == 0) {
                l++;
                index++;
            }
            while (r > l && nums[r] == 2) {
                r--;
            }
            if (l < r && nums[index] == 0) {
                int tmp = nums[l];
                nums[l] = nums[index];
                nums[index] = tmp;
                l++;
            } else if (r > l && nums[index] == 2) {
                int tmp = nums[r];
                nums[r] = nums[index];
                nums[index] = tmp;
                r--;
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = new int[1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = RandomUtils.nextInt(0, 1);
        }
        System.out.println(Arrays.toString(nums));
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
